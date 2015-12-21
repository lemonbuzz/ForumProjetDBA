
import org.bson.types.ObjectId;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

/**
 * Created by Alexandre on 2015-11-20.
 */
public class ForumMainMenu extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JPanel panel;

    private Forum forum;

    private Vector<Discussion> vectDiscussion;


    private Ecouteur ec;
    private JLabel lblNewLabel;
    private JLabel labelAddDiscussion;

    public ForumMainMenu(Forum forum) {
        this.forum = forum;
        ec = new Ecouteur();

        setTitle("CVM - FORUM");
        setBounds(100, 100, 896, 475);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setVisible(true);
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(192, 57, 43));

        this.setContentPane(mainPanel);
        mainPanel.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        scrollPane.setBounds(0, 101, 880, 335);
        mainPanel.add(scrollPane);

        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        lblNewLabel = new JLabel("Bro Forum");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 57));
        lblNewLabel.setBounds(10, 11, 342, 53);
        mainPanel.add(lblNewLabel);

        labelAddDiscussion = new JLabel("New label");
        labelAddDiscussion.setBounds(787, 21, 65, 65);
        labelAddDiscussion.setIcon(new ImageIcon("add.png"));
        mainPanel.add(labelAddDiscussion);

        vectDiscussion = forum.getDicussions();

        //Test
        for ( Discussion discussions : vectDiscussion  ) {
            ObjectId _id = discussions.get_id();
            String titre = discussions.getTitre();
            int size = discussions.getVectMessages().size();

            String dateDernierMessage = (String)discussions.getVectMessages().get(size - 1).get("date");

            panel.add(new PanelMessage(titre, String.valueOf(size), dateDernierMessage, _id ));
        }

    }

    private class PanelMessage extends JPanel {

        private JLabel labelTitreForum;
        private JLabel labelNbMsg;
        private JLabel lblDerniermessage;
        private JLabel labelSupprimer;
        private ObjectId idDiscussion;

        String nbMsg;


        public PanelMessage(String titrePublication, String nbMsg, String dateDerniermessage, ObjectId idDiscussion) {
            this.idDiscussion = idDiscussion;
            this.nbMsg = nbMsg;

            GridLayout myGridLayOut = new GridLayout(1,3);
            this.setLayout( myGridLayOut );

            this.addMouseListener(ec);

            this.labelTitreForum = new JLabel(titrePublication);
            this.labelNbMsg = new JLabel(nbMsg);


            this.labelSupprimer = new JLabel();
            this.labelSupprimer.setIcon(new ImageIcon("trash.png"));
            this.labelSupprimer.addMouseListener(ec);

            this.lblDerniermessage = new JLabel("Dernier message: " + dateDerniermessage);


            this.add(labelTitreForum);
            this.add(labelNbMsg);
            this.add(lblDerniermessage);
            this.add(labelSupprimer);

        }

        public JLabel getLabelSupprimer() {
            return labelSupprimer;
        }

        public void setLabelSupprimer(JLabel labelSupprimer) {
            this.labelSupprimer = labelSupprimer;
        }

        public ObjectId getID() {
            return this.idDiscussion;
        }
    }

    public void refreshList() {
        vectDiscussion = forum.getDicussions();

        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        //Test
        for ( Discussion discussions : vectDiscussion  ) {
            ObjectId _id = discussions.get_id();
            String titre = discussions.getTitre();
            int size = discussions.getVectMessages().size();

            String dateDernierMessage = (String)discussions.getVectMessages().get(size - 1).get("date");

            panel.add(new PanelMessage(titre, String.valueOf(size), dateDernierMessage, _id ));
        }
    }

    private class Ecouteur implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {

            me.getComponent().setBackground(null);

        }

        @Override
        public void mouseEntered(MouseEvent me) {

            me.getComponent().setBackground(new Color(52, 152, 219));

        }

        @Override
        public void mouseExited(MouseEvent me) {

            me.getComponent().setBackground(null);

        }

        @Override
        public void mousePressed(MouseEvent me) {

            me.getComponent().setBackground(new Color(52,73,94));

        }

        @Override
        public void mouseReleased(MouseEvent me) {
            me.getComponent().setBackground(null);
        }
    }
}
//console gui, only for reals
/*Vector<Discussion> discussions = ourForum.getDicussions();


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
        }*/
