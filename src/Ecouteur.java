import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Ecouteur implements MouseListener{
	
		private boolean wasPanelClicked = false;
		private MessagePanel lastSelectedmsgPanel;
		private DiscussionPanel lastSelectedThreadPanel;
		private FrameForum frameForum;
		
		private Color rebeccapurple = new Color(41, 128, 185);
		private Color wistful = new Color(102, 51, 153);
		private Color alizarin = new Color(231, 76, 60);

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() instanceof JLabel){
				JLabel lblBtn = ((JLabel) e.getSource());
				if(lblBtn.getText().equals("deleteMsg"))
					System.out.println("Im gonna delete this message");
				else if(lblBtn.getText().equals("deleteThread")){
					System.out.println("Im gonna delete this thread");
				}
				else if(lblBtn.equals("send"))
					System.out.println("Im gonna send message");
				else if(lblBtn.equals("login"))
					System.out.println("Im gonna login message");
				
			}
			else if(e.getSource() instanceof MessagePanel){
				if(wasPanelClicked){
					lastSelectedmsgPanel.setBackground(Color.WHITE);
					lastSelectedmsgPanel.changeForeGroundColor(Color.BLACK);
				}
				e.getComponent().setBackground(rebeccapurple);
				MessagePanel msg = (MessagePanel) e.getComponent();
				msg.changeForeGroundColor(Color.WHITE);
				lastSelectedmsgPanel = msg;
				wasPanelClicked = true;
			}
			else if(e.getSource() instanceof DiscussionPanel){
				System.out.println("ok on DiscussionPanel");
				//System.out.println(frameForum.getPanelCardLayout());
				//((CardLayout) frameForum.getPanelCardLayout().getLayout()).next(frameForum.getPanelCardLayout());
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
			if(e.getSource() instanceof MessagePanel || e.getSource() instanceof DiscussionPanel){
				e.getComponent().setBackground(wistful);
				try{
					MessagePanel msg = (MessagePanel) e.getComponent();
					msg.changeForeGroundColor(Color.WHITE);
					if(wasPanelClicked){
						if(lastSelectedmsgPanel.getIndex() == msg.getIndex()){
							lastSelectedmsgPanel.setBackground(rebeccapurple);
							lastSelectedmsgPanel.changeForeGroundColor(Color.WHITE);
							System.out.println("here");
						}
					}
				}catch (ClassCastException cce) {
					((DiscussionPanel) e.getComponent()).changeForeGroundColor(Color.WHITE);
					//TODO if wasPanelClicked
				}
			}
			
			if(e.getSource() instanceof JLabel){
				e.getComponent().getParent().setBackground(alizarin);
				if(e.getComponent().getParent() instanceof MessagePanel){
					((MessagePanel) e.getComponent().getParent()).changeForeGroundColor(Color.WHITE);
				}
				else if(e.getComponent().getParent() instanceof DiscussionPanel){
					((DiscussionPanel) e.getComponent().getParent()).changeForeGroundColor(Color.WHITE);
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() instanceof MessagePanel || e.getSource() instanceof DiscussionPanel){
				e.getComponent().setBackground(Color.WHITE);
				try{
					((MessagePanel) e.getComponent()).changeForeGroundColor(Color.BLACK);
					if(wasPanelClicked){
						lastSelectedmsgPanel.setBackground(rebeccapurple);
						lastSelectedmsgPanel.changeForeGroundColor(Color.WHITE);
					}
				}catch (ClassCastException cce) {
					((DiscussionPanel) e.getComponent()).changeForeGroundColor(Color.BLACK);
					//TODO if wasPanelClicked
				}
				
			}
			if(e.getSource() instanceof JLabel){
				e.getComponent().getParent().setBackground(Color.WHITE);
				if(e.getComponent().getParent() instanceof MessagePanel){
					((MessagePanel) e.getComponent().getParent()).changeForeGroundColor(Color.BLACK);
				}
				else if(e.getComponent().getParent() instanceof DiscussionPanel){
					((DiscussionPanel) e.getComponent().getParent()).changeForeGroundColor(Color.BLACK);
				}
			}
		}
	}