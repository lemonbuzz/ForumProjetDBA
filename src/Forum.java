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
import java.util.Date;
import java.util.Locale;
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

        //ourForum.addDiscution("Bonjour", "Sors les caliss de poubelles");

        ourForum.addMessage("ok ok, capote pas", new ObjectId("56756c084c0fba17803898a3"));

        ourForum.printAllDocsInCollection();

        new ForumView(ourForum);

    }
}