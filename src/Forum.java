/**
 * Created by Alexandre on 2015-11-20.
 */

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;

import java.lang.annotation.Documented;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.Format;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import org.bson.types.ObjectId;

import javax.print.Doc;

import static java.util.Arrays.asList;


public class Forum {

    MongoClient mongoClient;
    MongoDatabase forumDataBase;
    MongoCollection<Document> collectionDicussions;

    public Forum() throws Exception {

        this.mongoClient = new MongoClient();

        this.forumDataBase = mongoClient.getDatabase("forumDataBase");

        this.collectionDicussions = forumDataBase.getCollection("collectionMessages");
    }

    public Document getMessageDoc(String message) throws ParseException {

        return new Document("message", message).append("date", getDate());
    }

    public void addDiscution(String nomDuSujet,String message) throws ParseException {

        Document nouvelleDiscution = new Document("nomSujet", message).append("messages", asList(getMessageDoc(message)));

        collectionDicussions.insertOne(nouvelleDiscution);
    }

    public Vector<Dicussion> getDicussions() {

        FindIterable<Document> iterable = forumDataBase.getCollection("collectionMessages").find();
        Vector<Dicussion> vectDicussion = new Vector<Dicussion>();
        Vector<String> vectMessages = new Vector<String>();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {

                ObjectId _id = (ObjectId)document.get("_id");
                String nomSujet = (String)document.get("nomSujet");

                ArrayList<Document> messages = (ArrayList<Document>)document.get("messages");


                //System.out.println("--------------------");
                //System.out.println(nomSujet);
                //System.out.println(_id);
                // System.out.println(messages);

                vectDicussion.add( new Dicussion(nomSujet,_id,messages ) );

            }});

        return vectDicussion;
    }


    public void addMessage(String message, ObjectId id) throws ParseException {

        collectionDicussions.updateOne( new Document("_id", id), new Document("$push", new Document("messages", getMessageDoc(message))));
    }


    public void printAllDocsInCollection() {

        FindIterable<Document> iterable = forumDataBase.getCollection("collectionMessages").find();

        this.iterateDocumentsInCollection("collectionMessages",iterable);

    }

    public void findThis(int idOfDicussion) {

        FindIterable<Document> iterable = forumDataBase.getCollection("collectionMessages").find(
                new Document("sujetConcerne", idOfDicussion));

        this.iterateDocumentsInCollection("collectionMessages",iterable);

    }

    public void iterateDocumentsInCollection(String collection, FindIterable<Document> iterable) {

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }

    public String getDate() throws ParseException {

        Date aujourdhui = new Date();
        DateFormat formatDeDate = new SimpleDateFormat("d MMM", Locale.CANADA_FRENCH);

        return formatDeDate.format(aujourdhui);
    }

    /*FONCTION TEMPORAIRE MAIN*/

    public static void main ( String [] args) throws Exception {

        Forum ourForum = new Forum();

        //ourForum.addDiscution("Le forum fonctionne", "Caliss de sain ciboire");

        ourForum.addMessage("connard", new ObjectId("56758d834c0fba1a9005ad21"));

        Vector<Dicussion> discussions = ourForum.getDicussions();


        System.out.println("BIENVENU AU FORUM DES BROS!!!!!!!!!!!");
        System.out.println("--------------------------------------");


        for ( Dicussion myDicussions : discussions) {

            String titre = myDicussions.getTitre();

            System.out.println("-->DISCUSSION: " + titre);

            System.out.println("----MESSAGES------");


            ArrayList<Document> messages = myDicussions.getVectMessages();

            for ( Document messagesInThread : messages ) {
                System.out.println("MESSAGE : " + messagesInThread.get("message"));
                System.out.println("DATE : " + messagesInThread.get("date"));
                System.out.println("--------------------------------------");
            }
        }

        new ForumView(ourForum);

    }
}