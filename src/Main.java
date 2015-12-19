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

        ourForum.addDiscution("Alerte", "Le grinch a vole les cadeau de noel");



        ForumMainMenu view = new ForumMainMenu(ourForum);

    }
}
