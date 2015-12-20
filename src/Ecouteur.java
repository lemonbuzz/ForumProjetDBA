import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Ecouteur implements MouseListener{
	
		private boolean wasPanelMessageClicked = false;
		private MessagePanel lastSelectedmsgPanel;
		private Color rebeccapurple = new Color(41, 128, 185);
		private Color wistful = new Color(102, 51, 153);
		private Color alizarin = new Color(231, 76, 60);

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() instanceof JLabel){
				JLabel lblBtn = ((JLabel) e.getSource());
				if(lblBtn.getText().equals("deleteMsg"))
					System.out.println("Im gonna delete this message");
				else if(lblBtn.equals("send"))
					System.out.println("Im gonna send message");
				else if(lblBtn.equals("login"))
					System.out.println("Im gonna login message");
				
			}
			if(e.getSource() instanceof MessagePanel){
				if(wasPanelMessageClicked){
					lastSelectedmsgPanel.setBackground(Color.WHITE);
					lastSelectedmsgPanel.changeForeGroundColor(Color.BLACK);
				}
				e.getComponent().setBackground(rebeccapurple);
				MessagePanel msg = (MessagePanel) e.getComponent();
				msg.changeForeGroundColor(Color.WHITE);
				lastSelectedmsgPanel = msg;
				wasPanelMessageClicked = true;
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() instanceof MessagePanel){
				e.getComponent().setBackground(wistful);
				MessagePanel msg = (MessagePanel) e.getComponent();
				msg.changeForeGroundColor(Color.WHITE);
				if(wasPanelMessageClicked){
					if(lastSelectedmsgPanel.getIndex() == msg.getIndex()){
						lastSelectedmsgPanel.setBackground(rebeccapurple);
						lastSelectedmsgPanel.changeForeGroundColor(Color.WHITE);
						System.out.println("here");
					}
				}
			}
			
			if(e.getSource() instanceof JLabel){
				e.getComponent().getParent().setBackground(alizarin);
				MessagePanel msg = (MessagePanel) e.getComponent().getParent();
				msg.changeForeGroundColor(Color.WHITE);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() instanceof MessagePanel){
				e.getComponent().setBackground(Color.WHITE);
				MessagePanel msg = (MessagePanel) e.getComponent();
				msg.changeForeGroundColor(Color.BLACK);
				if(wasPanelMessageClicked){
					lastSelectedmsgPanel.setBackground(rebeccapurple);
					lastSelectedmsgPanel.changeForeGroundColor(Color.WHITE);
				}
			}
			if(e.getSource() instanceof JLabel){
				e.getComponent().getParent().setBackground(Color.WHITE);
				MessagePanel msg = (MessagePanel) e.getComponent().getParent();
				msg.changeForeGroundColor(Color.BLACK);
			}
		}
	}