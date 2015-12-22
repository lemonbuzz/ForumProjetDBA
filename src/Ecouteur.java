import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.*;

public class Ecouteur implements MouseListener{
	
		private boolean wasPanelClicked = false;
		private MessagePanel lastSelectedmsgPanel;
		private DiscussionPanel lastSelectedThreadPanel;
		private FrameForum frameForum;
		private Forum forum;
		
		private Color rebeccapurple = new Color(41, 128, 185);
		private Color wistful = new Color(102, 51, 153);
		private Color alizarin = new Color(231, 76, 60);
		
		public Ecouteur(FrameForum frameForum, Forum forum){
			this.frameForum = frameForum;
			this.forum = forum;
			frameForum.addListenerToPanelMessage(this);
			frameForum.addAddLabelListener(this);
			frameForum.addDialogListeners(this);

			frameForum.addBtnBackToThread(this);
			refreshListeThreads();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() instanceof JLabel){
				JLabel lblBtn = ((JLabel) e.getSource());
				if(lblBtn.getText().equals("deleteMsg"))
					System.out.println("Im gonna delete this message");
				else if(lblBtn.getText().equals("deleteThread")){
					System.out.println("YO");
					DiscussionPanel discussion = (DiscussionPanel)lblBtn.getParent();
					forum.supprimerDiscution(discussion.get_id());
					refreshListeThreads();
				}
				else if(lblBtn.getText().equals("send")) {
				}
				else if(lblBtn.getText().equals("login"))
					System.out.println("Im gonna login message");
				else if(lblBtn.getText().equals("backToThreads")){
					this.frameForum.nextPanel();
				}
				else if (lblBtn.getText().equals("add")) {
					System.out.println("IM GONNA ADD A THREAD");
					frameForum.startDialog();
				}
				else if (lblBtn.getText().equals("sendThread")) {
					System.out.println("YOOO");
					if(frameForum.isThreadCreated()) {
						try {
							forum.addDiscution(frameForum.getCreatedDicussion().getTitre(), frameForum.getCreatedDicussion().getUnMessage());
							refreshListeThreads();
							frameForum.getDialog().clearChampsTextes();
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				}


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
				this.frameForum.nextPanel();
			}
		}

	public void refreshListeThreads() {

		frameForum.setPanelThread(new JPanel());

		for( Discussion discussion : forum.getDicussions() ) {

			frameForum.getPanelThread().add(new DiscussionPanel(discussion.getTitre(), discussion.getNbMessages(), discussion.getDateLastMessage(), discussion.get_id(), this));
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
				}
			}
			else if(e.getSource() instanceof JLabel){
				if(((JLabel)e.getSource()).getText().equals("deleteMsg") || ((JLabel)e.getSource()).getText().equals("deleteThread")){
					e.getComponent().getParent().setBackground(alizarin);
					if(e.getComponent().getParent() instanceof MessagePanel){
						((MessagePanel) e.getComponent().getParent()).changeForeGroundColor(Color.WHITE);
					}
					else if(e.getComponent().getParent() instanceof DiscussionPanel){
						((DiscussionPanel) e.getComponent().getParent()).changeForeGroundColor(Color.WHITE);
					}
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
				}
			}
			else if(e.getSource() instanceof JLabel){
				if(((JLabel)e.getSource()).getText().equals("deleteMsg") || ((JLabel)e.getSource()).getText().equals("deleteThread")){
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
	}