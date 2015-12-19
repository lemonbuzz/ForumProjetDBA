/**
 * Created by Alexandre on 2015-11-20.
 */

import com.mongodb.MongoClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import org.bson.types.ObjectId;

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

    public Vector<Discussion> getDicussions() {

        FindIterable<Document> iterable = forumDataBase.getCollection("collectionMessages").find();
        Vector<Discussion> vectDicussion = new Vector<Discussion>();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {

                ObjectId _id = (ObjectId)document.get("_id"); //renvoie le ID du thread
                String nomSujet = (String)document.get("nomSujet"); //renvoie le nom du thread

                ArrayList<Document> messages = (ArrayList<Document>)document.get("messages"); //renvoie un arraylist des items de l'array 'messages'. chacun contenant un message,un auteur et une date de publication

                vectDicussion.add( new Discussion(nomSujet,_id,messages ) );

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

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM HH:mm");
        return sdf.format(cal.getTime());
    }
}