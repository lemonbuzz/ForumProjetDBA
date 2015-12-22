import org.bson.types.ObjectId;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class DiscussionPanel extends JPanel {
	
	private String discussion;
	private int nbMessage;
	private String lastDate;
	private int index;
	private Ecouteur ec;
	private JLabel lblSujetdescussion;
	private JLabel lblNbmsg;
	private JLabel lblLastdate;
	private JLabel lblDeleteicon;
	private JLabel lblNumbreMessage;
	private JLabel lblDateDernierMessage;
	private ObjectId _id;


	/**
	 * Create the panel.
	 */
	public DiscussionPanel(String discussion, int nbMessage, String lastDate, int index, ObjectId _id, Ecouteur ec) {
		setBackground(new Color(255, 255, 255));
		this.discussion = discussion;
		this.nbMessage = nbMessage;
		this.lastDate = lastDate;
		this._id = _id;
		this.index = index;
		this.ec = ec;
		this.setPreferredSize(new Dimension(923, 80));
		setLayout(null);
		
		Font font =  new Font("Arial", Font.BOLD, 12);
		
		lblSujetdescussion = new JLabel(discussion);
		lblSujetdescussion.setBounds(0, 0, 360, 80);
		lblSujetdescussion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSujetdescussion.setFont(new Font("Arial", Font.BOLD, 15));
		add(lblSujetdescussion);
		
		lblNumbreMessage = new JLabel();
		lblNumbreMessage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumbreMessage.setBounds(370, 22, 35, 35);
		lblNumbreMessage.setFont(font);
		lblNumbreMessage.setIcon(new ImageIcon("icons/ndMessages.png"));
		add(lblNumbreMessage);
		
		lblNbmsg = new JLabel(String.valueOf(nbMessage));
		lblNbmsg.setBounds(421, 0, 84, 80);
		lblNbmsg.setFont(font);
		add(lblNbmsg);
		
		lblDateDernierMessage = new JLabel("Dernière modification");
		lblDateDernierMessage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateDernierMessage.setBounds(515, 0, 127, 80);
		lblDateDernierMessage.setFont(font);
		add(lblDateDernierMessage);
		
		lblLastdate = new JLabel(lastDate);
		lblLastdate.setBounds(649, 0, 109, 80);
		lblLastdate.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastdate.setFont(font);
		add(lblLastdate);
		
		lblDeleteicon = new JLabel();
		lblDeleteicon.setBounds(811, 16, 50, 50);
		lblDeleteicon.setText("deleteThread");
		lblDeleteicon.setIcon(new ImageIcon("icons/garbageIcon2.png"));
		add(lblDeleteicon);
		
		this.addMouseListener(ec);
		lblDeleteicon.addMouseListener(ec);
	}
	
	public void changeForeGroundColor(Color color){
		lblSujetdescussion.setForeground(color);
		lblNbmsg.setForeground(color);
		lblDateDernierMessage.setForeground(color);
		lblLastdate.setForeground(color);
	}

	public String getDiscussion() {
		return discussion;
	}

	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}

	public int getNbMessage() {
		return nbMessage;
	}

	public void setNbMessage(int nbMessage) {
		this.nbMessage = nbMessage;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Ecouteur getEc() {
		return ec;
	}

	public void setEc(Ecouteur ec) {
		this.ec = ec;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
}
