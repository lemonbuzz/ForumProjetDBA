import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;

/**
 * Created by Alexandre on 2015-11-20.
 */
public class ForumView extends JFrame {
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JPanel panel;

    private Forum forum;


    private int tempVAR_NbMessages = 10;
    private JPanel panel_test;
    private JLabel labelTitreForum;
    private JLabel labelNbMsg;
    private JLabel lblDerniermessage;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JButton btnNewButton_4;
    private JButton btnNewButton_5;
    private JButton btnNewButton_6;
    private JButton btnNewButton_7;
    private JButton btnNewButton_8;
    private JButton btnNewButton_9;
    private JButton btnNewButton_10;
    private JButton btnNewButton_11;
    private JButton btnNewButton_12;
    private JButton btnNewButton_13;

    public ForumView(Forum forum) {
        this.forum = forum;

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
        scrollPane.setBounds(0, 101, 880, 335);
        mainPanel.add(scrollPane);

        panel = new JPanel();
        scrollPane.setViewportView(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        btnNewButton = new JButton("New button");
        panel.add(btnNewButton);

        btnNewButton_1 = new JButton("New button");
        panel.add(btnNewButton_1);

        btnNewButton_2 = new JButton("New button");
        panel.add(btnNewButton_2);

        btnNewButton_3 = new JButton("New button");
        panel.add(btnNewButton_3);

        btnNewButton_4 = new JButton("New button");
        panel.add(btnNewButton_4);

        btnNewButton_5 = new JButton("New button");
        panel.add(btnNewButton_5);

        btnNewButton_6 = new JButton("New button");
        panel.add(btnNewButton_6);

        btnNewButton_7 = new JButton("New button");
        panel.add(btnNewButton_7);

        btnNewButton_8 = new JButton("New button");
        panel.add(btnNewButton_8);

        btnNewButton_12 = new JButton("New button");
        panel.add(btnNewButton_12);

        btnNewButton_13 = new JButton("New button");
        panel.add(btnNewButton_13);

        panel_test = new JPanel();
        panel_test.setBounds(0, 0, 300, 600);
        panel_test.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        labelTitreForum = new JLabel("Titre de la Publication");
        panel_test.add(labelTitreForum);

        labelNbMsg = new JLabel("Nombre de message");
        labelNbMsg.setBackground(SystemColor.textHighlight);
        panel_test.add(labelNbMsg);

        lblDerniermessage = new JLabel("Supprimer");
        panel_test.add(lblDerniermessage);

        panel.add(panel_test);
        panel.add(panel_test);
        panel.add(panel_test);
        panel.add(panel_test);
        panel.add(panel_test);
        panel.add(panel_test);

        btnNewButton_9 = new JButton("New button");
        panel.add(btnNewButton_9);

        btnNewButton_10 = new JButton("New button");
        panel.add(btnNewButton_10);

        btnNewButton_11 = new JButton("New button");
        panel.add(btnNewButton_11);







    }

    private class PanelMessage extends JPanel {




    }

}
