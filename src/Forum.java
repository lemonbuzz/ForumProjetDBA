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

import java.net.UnknownHostException;


public class Forum {

    DBCollection collectionDiscussions;
    MongoClient mongoClient;
    DB forumDataBase;

    public Forum() throws Exception {

        mongoClient = new MongoClient();

        forumDataBase = mongoClient.getDB("forumDataBase");

        collectionDiscussions = forumDataBase.getCollection("forumCollection");


    }

    public void addDiscution(String nomDuSujet,String message) {

        BasicDBObject discussion = new BasicDBObject();
        discussion.append("nomDuSujet",nomDuSujet);
        discussion.append("message",message);


        this.collectionDiscussions.insert(discussion);
    }

    public void addMessage(){




    }

    /*FONCTION TEMPORAIRE MAIN*/

    public static void main ( String [] args) throws Exception {

        Forum ourForum = new Forum();

        ourForum.addDiscution("Bonjour", "LES POUBELLES CALISS, SORT LES!");



    }

}
