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
import org.bson.Document;
import com.mongodb.client.FindIterable;

import javax.print.Doc;


public class Forum {

    MongoClient mongoClient;
    MongoDatabase forumDataBase;
    MongoCollection<Document> collectionDicussions;


    public Forum() throws Exception {

        this.mongoClient = new MongoClient("127.0.0.1", 27017);

        this.forumDataBase = mongoClient.getDatabase("forumDataBase");

        this.collectionDicussions = forumDataBase.getCollection("collectionMessages");


    }

    public void addDiscution(String nomDuSujet,String message) throws ParseException {

        Document doc = new Document("nomDuSujet", nomDuSujet).
                append("message", message).
                append("date", this.getDate());

        this.collectionDicussions.insertOne(doc);
    }

    public void addMessage(String message, int idSujet) throws ParseException {

        Document doc = new Document("message", message).
                append("date", this.getDate()).
                append("sujetConcerne", idSujet);

        this.collectionDicussions.insertOne(doc);
    }

    public void printAllDocsInCollection(String collection) {

        FindIterable<Document> iterable = forumDataBase.getCollection(collection).find();

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });

    }

    public void findThis(int idOfDicussion) {

        FindIterable<Document> iterable = forumDataBase.getCollection("collectionMessages").find(
                new Document("sujetConcerne", idOfDicussion));

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });

    }

    public void getAllIds(String collection) {

        FindIterable<Document> iterable = forumDataBase.getCollection(collection).find();

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {

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

        ourForum.addDiscution("Bonjour", "LES POUBELLES CALISS, SORT LES!");

        ourForum.addMessage("YOOO", 321312);
        ourForum.addMessage("YOdadad", 321312);
        ourForum.addMessage("Ydwqdqwdqw", 321312);
        ourForum.addMessage("Ydwqdqwdqwdqwdwq", 321312);



        ourForum.printAllDocsInCollection("collectionMessages");
        System.out.println("---------------------");
        System.out.println("THIS IS WHAT YOU WANT");
        ourForum.findThis(321312);

    }
}