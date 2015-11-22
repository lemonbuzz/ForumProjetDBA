import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout.Alignment;

/**
 * Created by Alexandre on 2015-11-20.
 */
public class ForumView extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JPanel panel;

    private Forum forum;

    private Ecouteur ec;

    public ForumView(Forum forum) {
        this.forum = forum;
        ec = new Ecouteur();

        setTitle("CVM - FORUM");
        setBounds(100, 100, 896, 475);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setVisible(true);
        mainPanel = new JPanel();
        mainPanel.setBackground(SystemColor.textHighlight);

        this.setContentPane(mainPanel);
        mainPanel.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        scrollPane.setBounds(0, 101, 880, 335);
        mainPanel.add(scrollPane);

        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));


        for ( int i = 0; i < 50; i++)
            panel.add ( new PanelMessage() );





    }



    private class PanelMessage extends JPanel {

        private JLabel labelTitreForum;
        private JLabel labelNbMsg;
        private JLabel lblDerniermessage;


        public PanelMessage() {


            this.setBounds(0, 0, 300, 600);
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

            this.addMouseListener(ec);

            labelTitreForum = new JLabel("Titre de la Publication");
            this.add(labelTitreForum);

            labelNbMsg = new JLabel("Nombre de message");
            labelNbMsg.setBackground(SystemColor.textHighlight);
            this.add(labelNbMsg);

            lblDerniermessage = new JLabel("Supprimer");
            this.add(lblDerniermessage);

        }




    }

    private class Ecouteur implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent me) {

            me.getComponent().setBackground(Color.RED);


        }

        @Override
        public void mouseExited(MouseEvent me) {

            me.getComponent().setBackground(null);

        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }



    }

}
