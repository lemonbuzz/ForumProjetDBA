import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Alexandre on 2015-12-19.
 */
public class Discussion {

    String titre;
    ObjectId _id;
    ArrayList<Document> vectMessages;

    public Discussion(String titre, ObjectId _id, ArrayList<Document> vectMessages) {
        this.titre = titre;
        this._id = _id;
        this.vectMessages = vectMessages;
    }

    public int getNbMessages() {
        return vectMessages.size();
    }

    public String getDateLastMessage() {
        int index = vectMessages.size();
        return (String)vectMessages.get(index-1).get("date");
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArrayList<Document> getVectMessages() {
        return vectMessages;
    }

    public void setVectMessages(ArrayList<Document> vectMessages) {
        this.vectMessages = vectMessages;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
