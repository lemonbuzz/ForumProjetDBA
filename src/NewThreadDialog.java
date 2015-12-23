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
    private JLabel lblSendMessage;
    private JTextArea textArea;
    private JLabel lblMessage;
    private JLabel lblTitreDeLa;
    private JTextField textField;
    private FrameForum frameForum;
    private boolean userSentThread = false;
    private JLabel lblCancel;


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

        lblSendMessage = new JLabel("sendThread");
        lblSendMessage.setIcon(new ImageIcon("icons/sendIcon.png"));
        lblSendMessage.setBounds(372, 169, 60, 60);
        getContentPane().add(lblSendMessage);

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

        lblCancel = new JLabel("New label");
        lblCancel.setIcon(new ImageIcon("icons/delete.png"));
        lblCancel.setBounds(420, 7, 60, 60);
        getContentPane().add(lblCancel);
        setBackground(Color.DARK_GRAY);


        lblSendMessage.addMouseListener(new MouseListener() {
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

        lblCancel.addMouseListener(new MouseListener() {
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

    public void clearChampsTextes() {
        textField.setText("");
        textArea.setText("");


    }

    public boolean isUserSentThread() {
        return userSentThread;
    }

    public void setUserSentThread(boolean userSentThread) {
        this.userSentThread = userSentThread;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JLabel getLblTitreDeLa() {
        return lblTitreDeLa;
    }

    public void setLblTitreDeLa(JLabel lblTitreDeLa) {
        this.lblTitreDeLa = lblTitreDeLa;
    }

    public JLabel getLblMessage() {
        return lblMessage;
    }

    public void setLblMessage(JLabel lblMessage) {
        this.lblMessage = lblMessage;
    }

    public JLabel getLblSendMessage() {
		return lblSendMessage;
	}

	public void setLblSendMessage(JLabel lblSendMessage) {
		this.lblSendMessage = lblSendMessage;
	}

	public JLabel getLblCancel() {
		return lblCancel;
	}

	public void setLblCancel(JLabel lblCancel) {
		this.lblCancel = lblCancel;
	}

	public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }


}
