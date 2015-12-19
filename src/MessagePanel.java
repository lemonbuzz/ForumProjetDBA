import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JTextPane;

public class MessagePanel extends JPanel {
	
	private JLabel lblMessage;
	private JLabel lblByUser;
	private JLabel lblUser;
	private JLabel lblPosteDate;
	private JLabel lblTheDate;
	private JLabel lblImagegarbage;
	private Ecouteur ec;
	
	
	private String massage;
	private String user;
	private String date;
	private JLabel lbluserIcon;

	/**
	 * Create the panel.
	 */
	public MessagePanel(String massage, String user, String date, Ecouteur ec) {
		setBackground(Color.WHITE);
		this.massage = massage;
		this.user = user;
		this.date = date;
		
		this.setPreferredSize(new Dimension(923, 80));
		setLayout(null);
		
		lblMessage = new JLabel(massage);
		lblMessage.setBounds(24, 11, 548, 58);
		add(lblMessage);
		
		lblByUser = new JLabel("By ");
		lblByUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblByUser.setBounds(600, 10, 55, 14);
		add(lblByUser);
		
		lbluserIcon = new JLabel();
		lbluserIcon.setIcon(new ImageIcon("icons/userIcon.png"));
		lbluserIcon.setBounds(669, 11, 20, 20);
		add(lbluserIcon);
		
		lblUser = new JLabel(user);
		lblUser.setBounds(706, 11, 123, 14);
		add(lblUser);
		
		lblPosteDate = new JLabel("Poste date ");
		lblPosteDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPosteDate.setBounds(567, 40, 87, 14);
		add(lblPosteDate);
		
		lblTheDate = new JLabel(date);
		lblTheDate.setBounds(665, 40, 165, 15);
		add(lblTheDate);
		
		lblImagegarbage = new JLabel();
		lblImagegarbage.setForeground(Color.WHITE);
		lblImagegarbage.setIcon(new ImageIcon("icons/garbageIcon.png"));
		lblImagegarbage.setBounds(840, 10, 50, 50);
		add(lblImagegarbage);
		
		this.ec = ec;
		this.addMouseListener(ec);
	}
	
	public void changeForeGroundColor(Color color){
		lblMessage.setForeground(color);
		lblByUser.setForeground(color);
		lblUser.setForeground(color);
		lblPosteDate.setForeground(color);
		lblTheDate.setForeground(color);
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
