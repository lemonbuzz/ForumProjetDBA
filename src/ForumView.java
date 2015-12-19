import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        mainPanel.setBackground(new Color(127, 140, 141));

        this.setContentPane(mainPanel);
        mainPanel.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        scrollPane.setBounds(0, 101, 880, 335);
        mainPanel.add(scrollPane);

        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        //Test
        for ( int i = 0; i < 50; i++)
            panel.add ( new PanelMessage("Titre thread", "2", "18 nov") );

    }



    private class PanelMessage extends JPanel {

        private JLabel labelTitreForum;
        private JLabel labelNbMsg;
        private JLabel lblDerniermessage;
        private JLabel labelSupprimer;


        public PanelMessage(String titrePublication, String nbMsg, String dateDerniermessage) {

            GridLayout myGridLayOut = new GridLayout(1,3);

            this.setLayout( myGridLayOut );

            this.addMouseListener(ec);

            this.labelTitreForum = new JLabel(titrePublication);
            this.labelNbMsg = new JLabel(titrePublication);


            this.labelSupprimer = new JLabel();
            this.labelSupprimer.setIcon(new ImageIcon("trash.png"));

            this.lblDerniermessage = new JLabel("Dernier message: " + dateDerniermessage);


            this.add(labelTitreForum);
            this.add(labelNbMsg);
            this.add(lblDerniermessage);
            this.add(labelSupprimer);

        }

    }

    private class Ecouteur implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent me) {

            me.getComponent().setBackground(new Color(41, 128, 185));


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
            me.getComponent().setBackground(new Color(41, 128, 185));

        }


    }

}
