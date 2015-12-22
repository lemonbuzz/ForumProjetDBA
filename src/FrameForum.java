import org.bson.Document;
import org.bson.types.ObjectId;

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
import java.awt.CardLayout;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
	
	//private Ecouteur ec;
	private JLabel lblDiscussion;
	private JLabel lblThread;
	private JLabel lblBackbtn;
	private JPanel panelPageMsg;
	private JPanel panelCardLayout;
	private JPanel panelPageThread;
	private JPanel panelMainMenu;
	private JLabel lblForumname;
	private JLabel lblAjouter;
	private JLabel lblAddthreadicon;
	private JScrollPane scrollPane;
	private JPanel panelThread;
	private NewThreadDialog dialog;

	public FrameForum() {
		setSize(960, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("THE BROS. FORUM");
		this.setIconImage((new ImageIcon("icons/forumIcon.png")).getImage());
		getContentPane().setLayout(null);

		
		panelCardLayout = new JPanel();
		panelCardLayout.setBounds(0, 0, this.getWidth()-16, 800);
		getContentPane().add(panelCardLayout);
		panelCardLayout.setLayout(new CardLayout(0, 0));
		
		panelPageThread = new JPanel();
		panelCardLayout.add(panelPageThread);
		panelPageThread.setLayout(null);
		
		panelMainMenu = new JPanel();
		panelMainMenu.setBounds(0, 0, 944, 100);
		panelMainMenu.setBackground(Color.DARK_GRAY);
		panelPageThread.add(panelMainMenu);
		panelMainMenu.setLayout(null);
		
		lblForumname = new JLabel("The Bros. Forum");
		lblForumname.setForeground(new Color(176, 244, 230));
		lblForumname.setFont(new Font("Nirmala UI", Font.BOLD, 24));
		lblForumname.setBounds(10, 11, 253, 57);
		panelMainMenu.add(lblForumname);
		
		lblAjouter = new JLabel("Ajouter");
		lblAjouter.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblAjouter.setForeground(new Color(255, 255, 255));
		lblAjouter.setBounds(642, 70, 46, 14);
		panelMainMenu.add(lblAjouter);
		
		lblAddthreadicon = new JLabel("add");
		lblAddthreadicon.setIcon(new ImageIcon("icons/addThreadIcon.png"));
		lblAddthreadicon.setBounds(636, 15, 50, 50);
		panelMainMenu.add(lblAddthreadicon);
		
		panelThread = new JPanel();
		panelThread.setBounds(0, 0, 944, 700);
		panelThread.setLayout(new BoxLayout(panelThread, BoxLayout.Y_AXIS));
		
		scrollPane = new JScrollPane(panelThread);
		scrollPane.setBounds(0, 100, 944, 661);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panelPageThread.add(scrollPane);

		//Page des messages pour une discussion
		panelPageMsg = new JPanel();
		panelPageMsg.setBounds(0, 0, this.getWidth()-16, 800);
		panelCardLayout.add(panelPageMsg);
		panelPageMsg.setLayout(null);
		
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, this.getWidth()-16, 100);
		panelMenu.setBackground(Color.DARK_GRAY);
		panelPageMsg.add(panelMenu);
		panelMenu.setLayout(null);
		
		lblForum = new JLabel("The Bros. Forum");
		lblForum.setFont(new Font("Nirmala UI", Font.BOLD, 24));
		lblForum.setForeground(new Color(176, 224, 230));
		lblForum.setBounds(22, 11, 241, 27);
		panelMenu.add(lblForum);
		
		lblLoginicon = new JLabel();
		lblLoginicon.setBounds(750, 30, 40, 40);
		lblLoginicon.setIcon(new ImageIcon("icons/loginIcon.png"));
		panelMenu.add(lblLoginicon);
		
		textField = new JTextField();
		textField.setBounds(800, 40, 106, 20);
		panelMenu.add(textField);
		textField.setColumns(10);
		
		lblDiscussion = new JLabel("Discussion :");
		lblDiscussion.setForeground(new Color(176, 224, 230));
		lblDiscussion.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		lblDiscussion.setBounds(84, 55, 140, 27);
		panelMenu.add(lblDiscussion);
		
		lblThread = new JLabel("thread");
		lblThread.setForeground(new Color(147, 112, 219));
		lblThread.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		lblThread.setBounds(234, 55, 460, 27);
		panelMenu.add(lblThread);
		
		lblBackbtn = new JLabel("backToThreads");
		lblBackbtn.setIcon(new ImageIcon("icons/backToThreadIcon.png"));
		lblBackbtn.setBounds(22, 49, 40, 40);
		panelMenu.add(lblBackbtn);
		
		panelMessage = new JPanel();
		panelMessage.setBounds(0, 0, this.getWidth()-16, 100);
		panelMessage.setLayout(new BoxLayout(panelMessage, BoxLayout.Y_AXIS));
		
		scrollPaneMessage = new JScrollPane(panelMessage);
		scrollPaneMessage.setBounds(0, 100, 944, 500);
		scrollPaneMessage.getVerticalScrollBar().setUnitIncrement(16);
		panelPageMsg.add(scrollPaneMessage);
		
		panelReply = new JPanel();
		panelReply.setBounds(0, 600, 944, 161);
		panelReply.setBackground(Color.DARK_GRAY);
		panelPageMsg.add(panelReply);
		panelReply.setLayout(null);
		
		txtpnTextReply = new JTextPane();
		txtpnTextReply.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpnTextReply.setBounds(10, 10, 780, 140);
		
		scrollPaneRepty = new JScrollPane(txtpnTextReply);
		scrollPaneRepty.setBounds(10, 10, 780, 140);
		panelReply.add(scrollPaneRepty);
		
		lblSendIcon = new JLabel();
		lblSendIcon.setIcon(new ImageIcon("icons/sendIcon.png"));
		lblSendIcon.setBounds(835, 50, 60, 60);
		panelReply.add(lblSendIcon);
		dialog = new NewThreadDialog(this);
	}

	public JPanel getPanelThread() {
		return panelThread;
	}

	public void startDialog() {

		dialog.setVisible(true);

	}

	public boolean isThreadCreated() {

		if (dialog.isUserSentThread() ) {

			return true;
		}
		else {
			return false;
		}

	}

	public void addDialogListeners(Ecouteur ec) {
		dialog.getLblNewLabel().addMouseListener(ec);
		dialog.getLblNewLabel_1().addMouseListener(ec);



	}

	public Discussion getCreatedDicussion() throws ParseException {



 		return new Discussion(dialog.getTextField().getText(),dialog.getTextArea().getText() );
	}

	public void setPanelThread(JPanel panelThread) {
		panelThread.setBounds(0, 0, 944, 700);
		panelThread.setLayout(new BoxLayout(panelThread, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(panelThread);
		this.panelThread = panelThread;
	}

	public void nextPanel(){
		CardLayout layout = (CardLayout)panelCardLayout.getLayout();
		layout.next(panelCardLayout);
	}
	
	public void addBtnBackToThread(Ecouteur ec){
		lblBackbtn.addMouseListener(ec);
	}

	public void addAddLabelListener(Ecouteur ec) {

		lblAddthreadicon.addMouseListener(ec);
	}

	
	public void addListenerToPanelMessage(Ecouteur ec){
		for(int i = 0; i < 10; i++){
			panelMessage.add(new MessagePanel("<html>Hey sa va aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab</html>", "drago", "2015-12-19", ec, i+1));
		}
		panelMessage.add(new MessagePanel("<html>Sed ut perspiciati unde omnis iste natus error sust explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure hiit voluptatem accusantium doloremque laudantium, ut I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, ut I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter cbecause it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil ut I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any rand pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any r ut I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any rtotam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est?</html>", "drago", "2015-12-19", ec, 11));
		panelMessage.add(new MessagePanel("<html>Sed ut perspiciati unde t voluptatem accusantium doloremque laudantium, ut I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of  omnis iste natus error sequi neel scrolling. Is there any way to adjust the speed of the scrolling, though? It is, in my opinion, ludicrously slow. No matter what size I make the window, theesciunt. Neque porro quisquam est?</html>", "drago", "2015-12-19", ec, 12));
		panelMessage.add(new MessagePanel("<html>Sed ut perspiciati unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, ut I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil ut I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any rand pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any r ut I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any rtotam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est?</html>", "drago", "2015-12-19", ec, 13));
	}

	public String getDate() throws ParseException { //renvoie la date en francais avec le mois abrégé

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM HH:mm");
		return sdf.format(cal.getTime());
	}

	public NewThreadDialog getDialog() {
		return dialog;
	}

	public void setDialog(NewThreadDialog dialog) {
		this.dialog = dialog;
	}
}
