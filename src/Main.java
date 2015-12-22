import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Alexandre on 2015-12-19.
 */
public class Main {

    public static void main ( String args []) throws Exception {


        Forum forumModel = new Forum();

        forumModel.addDiscution("YOOOO", "CAA PUE");


        FrameForum forumView = new FrameForum();
        forumView.setVisible(true);
        Ecouteur ec = new Ecouteur(forumView, forumModel);

    }
}
