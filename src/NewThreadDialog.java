import java.awt.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;


public class NewThreadDialog extends JDialog {
    private JLabel lblNewLabel;
    private JTextArea textArea;
    private JLabel lblMessage;
    private JLabel lblTitreDeLa;
    private JTextField textField;
    private FrameForum frameForum;
    private boolean userSentThread = false;
    private JLabel lblNewLabel_1;


    /**
     * Create the dialog.
     */
    public NewThreadDialog(FrameForum frameForum) {
        this.frameForum = frameForum;
        //this.setResizable(false);
        this.setUndecorated(true);
        setTitle("Nouvelle discussion");
        setBounds(0, 0, 490, 343);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);

        lblNewLabel = new JLabel("send");
        lblNewLabel.setIcon(new ImageIcon("icons/sendIcon.png"));
        lblNewLabel.setBounds(372, 169, 60, 60);
        getContentPane().add(lblNewLabel);

        textArea = new JTextArea();
        textArea.setBounds(21, 169, 341, 148);
        getContentPane().add(textArea);

        lblMessage = new JLabel("Message");
        lblMessage.setForeground(Color.WHITE);
        lblMessage.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
        lblMessage.setBounds(21, 117, 139, 41);
        getContentPane().add(lblMessage);

        lblTitreDeLa = new JLabel("Titre de la discussion");
        lblTitreDeLa.setForeground(Color.WHITE);
        lblTitreDeLa.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
        lblTitreDeLa.setBounds(20, 11, 328, 41);
        getContentPane().add(lblTitreDeLa);

        textField = new JTextField();
        textField.setBounds(21, 63, 298, 33);
        getContentPane().add(textField);
        textField.setColumns(10);

        lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Alexandre\\IdeaProjects\\ForumProjetDBA\\icons\\delete.png"));
        lblNewLabel_1.setBounds(420, 7, 60, 60);
        getContentPane().add(lblNewLabel_1);
        setBackground(Color.DARK_GRAY);


        lblNewLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                    userSentThread = true;
                    NewThreadDialog.this.setVisible(false);


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        lblNewLabel_1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userSentThread = false;
                NewThreadDialog.this.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public boolean isUserSentThread() {
        return userSentThread;
    }

    public void setUserSentThread(boolean userSentThread) {
        this.userSentThread = userSentThread;
    }
}
