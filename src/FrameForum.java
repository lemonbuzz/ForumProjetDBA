import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class FrameForum extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JLabel lblForum;
	private JScrollPane scrollPaneMessage;
	private JPanel panelMessage;
	private JPanel panelReply;
	private JTextPane txtpnTextReply;
	private JLabel lblSendIcon;
	private JScrollPane scrollPaneRepty;
	private JLabel lblLoginicon;
	private JTextField textField;
	
	private Ecouteur ec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameForum frame = new FrameForum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameForum() {
		setSize(960, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CVM - FORUM");
		getContentPane().setLayout(null);
		
		ec = new Ecouteur();
		
		panelMenu = new JPanel();
		panelMenu.setBackground(Color.DARK_GRAY);
		panelMenu.setBounds(0, 0, this.getWidth()-16, 100);
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		lblForum = new JLabel("The Bros. Forum");
		lblForum.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblForum.setForeground(Color.CYAN);
		lblForum.setBounds(22, 11, 203, 27);
		panelMenu.add(lblForum);
		
		lblLoginicon = new JLabel();
		lblLoginicon.setBounds(750, 30, 40, 40);
		lblLoginicon.setIcon(new ImageIcon("icons/loginIcon.png"));
		panelMenu.add(lblLoginicon);
		
		textField = new JTextField();
		textField.setBounds(800, 40, 106, 20);
		panelMenu.add(textField);
		textField.setColumns(10);
		
		panelMessage = new JPanel();
		panelMessage.setBounds(0, 0, this.getWidth()-16, 100);
		panelMessage.setLayout(new BoxLayout(panelMessage, BoxLayout.Y_AXIS));
		
		scrollPaneMessage = new JScrollPane(panelMessage);
		scrollPaneMessage.setBounds(0, 100, this.getWidth()-16, 500);
		
		getContentPane().add(scrollPaneMessage);
		
		panelReply = new JPanel();
		panelReply.setBackground(Color.DARK_GRAY);
		panelReply.setBounds(0, 600, this.getWidth()-16, 165);
		getContentPane().add(panelReply);
		panelReply.setLayout(null);
		
		txtpnTextReply = new JTextPane();
		txtpnTextReply.setBounds(10, 10, 780, 140);
		
		scrollPaneRepty = new JScrollPane(txtpnTextReply);
		scrollPaneRepty.setBounds(10, 10, 780, 140);
		panelReply.add(scrollPaneRepty);
		
		lblSendIcon = new JLabel();
		lblSendIcon.setIcon(new ImageIcon("icons/sendIcon.png"));
		lblSendIcon.setBounds(835, 50, 60, 60);
		panelReply.add(lblSendIcon);
		
		for(int i = 0; i < 30; i++){
			panelMessage.add(new MessagePanel("Hey sa va", "drago", "2015-12-19", ec));
		}
	}
}
