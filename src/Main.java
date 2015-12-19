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
        ourForum.addDiscution("NIGGA", "GET FUCKED");
        ourForum.addMessage("cest cool", new ObjectId("56758d834c0fba1a9005ad21"));

        ForumMainMenu view = new ForumMainMenu(ourForum);

    }
}
