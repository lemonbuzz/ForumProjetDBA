import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class MessagePanel extends JPanel {
	
	private JLabel lblMessage;
	private JLabel lblByUser;
	private JLabel lblUser;
	private JLabel lblPosteDate;
	private JLabel lblTheDate;
	private JLabel lblImagegarbage;
	private Ecouteur ec;
	private int index;
	
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private String massage;
	private String user;
	private String date;
	private JLabel lbluserIcon;

	/**
	 * Create the panel.
	 */
	public MessagePanel(String massage, String user, String date, Ecouteur ec, int index) {
		setBorder(new LineBorder(new Color(176, 196, 222)));
		setBackground(Color.WHITE);
		this.massage = massage;
		this.user = user;
		this.date = date;
		this.ec = ec;
		this.index = index;
		
		Font font =  new Font("Arial", Font.BOLD, 12);
		setLayout(null);
		
		lblMessage = new JLabel(massage);
		lblMessage.setVerticalAlignment(SwingConstants.TOP);
		lblMessage.setFont(new Font("Arial", Font.PLAIN, 12));
		int ypanel = 80;
		int ymessage = 14;
		if(massage.length() > 93){
			for(int i = massage.length(); i>=80; i-=80){
				ypanel+=12;
				ymessage+=14;
			}
			this.setPreferredSize(new Dimension(923, ypanel));
			lblMessage.setBounds(24, 16, 548, ymessage);
		}
		else{
			this.setPreferredSize(new Dimension(923, 80));
			lblMessage.setBounds(24, 30, 548, 14);
		}
		add(lblMessage);
		
		lblByUser = new JLabel("By ");
		lblByUser.setFont(font);
		lblByUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblByUser.setBounds(600, 16, 55, 14);
		add(lblByUser);
		
		lbluserIcon = new JLabel();
		lbluserIcon.setIcon(new ImageIcon("icons/userIcon.png"));
		lbluserIcon.setBounds(665, 14, 20, 20);
		add(lbluserIcon);
		
		lblUser = new JLabel(user);
		lblUser.setFont(font);
		lblUser.setBounds(697, 16, 123, 14);
		add(lblUser);
		
		lblPosteDate = new JLabel("Poste date ");
		lblPosteDate.setFont(font);
		lblPosteDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPosteDate.setBounds(567, 40, 87, 14);
		add(lblPosteDate);
		
		lblTheDate = new JLabel(date);
		lblTheDate.setFont(font);
		lblTheDate.setBounds(665, 40, 165, 15);
		add(lblTheDate);
		
		lblImagegarbage = new JLabel();
		lblImagegarbage.setText("deleteMsg");
		lblImagegarbage.setIcon(new ImageIcon("icons/garbageIcon2.png"));
		lblImagegarbage.setBounds(840, 14, 50, 50);
		add(lblImagegarbage);
		
		this.addMouseListener(ec);
		lblImagegarbage.addMouseListener(ec);
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
