import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Alexandre on 2015-12-19.
 */
public class Main {

    public static void main ( String args []) throws Exception {

        Forum ourForum = new Forum();
        ourForum.addMessage("cest cool", new ObjectId("56758d834c0fba1a9005ad21"));

        Vector<Discussion> discussions = ourForum.getDicussions();


        System.out.println("BIENVENU AU FORUM DES BROS!!!!!!!!!!!");
        System.out.println("--------------------------------------");


        for ( Discussion myDicussions : discussions) {

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

        ForumMainMenu view = new ForumMainMenu(ourForum);

    }
}
