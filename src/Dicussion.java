import org.bson.types.ObjectId;

import java.util.Vector;

/**
 * Created by Alexandre on 2015-12-19.
 */
public class Dicussion {

    String titre;
    String messageInitial;
    ObjectId _id;
    Vector<String> vectMessages;

    public Dicussion(String titre, ObjectId _id, Vector<String> vectMessages) {
        this.titre = titre;
        this._id = _id;
        this.vectMessages = vectMessages;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessageInitial() {
        return messageInitial;
    }

    public void setMessageInitial(String messageInitial) {
        this.messageInitial = messageInitial;
    }
}
