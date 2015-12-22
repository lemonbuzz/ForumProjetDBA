
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

    public Forum() throws Exception { //instancie un forum - un client mongo, une db et une collection contenant les dicussions

        this.mongoClient = new MongoClient();
        this.forumDataBase = mongoClient.getDatabase("forumDataBase");
        this.collectionDicussions = forumDataBase.getCollection("collectionMessages");
    }
    //*****METHOD TO MODIFY*****TO ADD: AUTHOR OF MESSAGE//
    public Document getMessageDoc(String message) throws ParseException {

        return new Document("message", message).append("date", getDate()).append("_id", new ObjectId()); //renvoie un doc bson qui représente UN message **TO ADD: AUTHOR OF MESSAGE**
    }
    ///////////////////////////////

    public void addDiscution(String nomDuSujet,String message) throws ParseException { //Ajoute une discussion a la collection discussion

        Document nouvelleDiscution = new Document("nomSujet", nomDuSujet).append("messages", asList(getMessageDoc(message))); // insert une discussion et y ajoute un item 'message' dans le tableau "messages"
        collectionDicussions.insertOne(nouvelleDiscution);
    }

    public void addMessage(String message, ObjectId id) throws ParseException {

        collectionDicussions.updateOne( new Document("_id", id), new Document("$push", new Document("messages", getMessageDoc(message)))); // ajoute un item 'message' dans le tableau "messages"
    }

    public void supprimerDiscution(ObjectId id) { //delete par ID

        collectionDicussions.deleteOne(new Document("_id", id));
    }

    public void supprimerMessageFromThread(ObjectId objectIdMessage, ObjectId objectIdthread) {
            collectionDicussions.updateOne( new Document("_id", objectIdthread), new Document("$pull", new Document("messages", new Document("_id", objectIdMessage))));
    }

    public Vector<Discussion> getDicussions() { //cette methode renvoie un vecteur contenant toutes les discussions du forum sous forme d'objet contenant le nom du sujet, l'auteur et tous ses messages

        FindIterable<Document> iterable = forumDataBase.getCollection("collectionMessages").find();
        final Vector<Discussion> vectDicussion = new Vector<Discussion>();
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

    public String getDate() throws ParseException { //renvoie la date en francais avec le mois abrégé

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM HH:mm");
        return sdf.format(cal.getTime());
    }

    public void iterateDocumentsInCollection(String collection, FindIterable<Document> iterable) { //itere les objets Documents avec un objet iterable pour print tous les documents

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }

    public void test() {

        FindIterable<Document> iterable = forumDataBase.getCollection("collectionMessages").find();

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });

    }
}