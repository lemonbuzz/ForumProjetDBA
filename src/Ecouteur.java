import org.bson.Document;
import org.bson.types.ObjectId;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;

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

		private ObjectId currentDiscussion;
		private int currentIndex;

		public Ecouteur(FrameForum frameForum, Forum forum){
			this.frameForum = frameForum;
			this.forum = forum;
			frameForum.addAddLabelListener(this);
			frameForum.addDialogListeners(this);
			frameForum.addListenerTolblSendIcon(this);

			frameForum.addBtnBackToThread(this);
			refreshListeThreads();

		}
		
		public void	refreshListeThreads() { // cette méthode rafraichie le panel des discussions

			frameForum.setPanelThread(new JPanel());
			int i = 0;
			for (Discussion discussion : forum.getDicussions()) {
				frameForum.getPanelThread().add(new DiscussionPanel(discussion.getTitre(), discussion.getNbMessages(), discussion.getDateLastMessage(), i, discussion.get_id(), this));
				i++;
			}


		}

		public void refreshPanelMessages(int index) throws ParseException { // cette méthode rafraichie le panel des message par rapport à la discussion choisie

			frameForum.setPanelMessage(new JPanel());
			Discussion discussion =  forum.getDicussions().elementAt(index);


			for ( Document message : discussion.getVectMessages()) {

				String leMessage = String.valueOf(message.get("message"));
				String laDate = (String)message.get("date");
				ObjectId idMessage = (ObjectId)message.get("_id");
				frameForum.getPanelMessage().add( new MessagePanel("<html>"+leMessage+"</html>", "Guest", laDate, this, index, idMessage  ));
			}


		}

		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() instanceof JLabel){ // vérifier si c'est bien une instance de JLabel 
				JLabel lblBtn = ((JLabel) e.getSource());
				if(lblBtn.getText().equals("deleteMsg")) { // verifier si le label cliquer a bien le text deleteMsg
					System.out.println("Im gonna delete this message");
					MessagePanel panel = (MessagePanel)e.getComponent().getParent(); // instancier le panel MessagePanel en cherchant le parent component du label deleteMsg

					ObjectId idMessage;
					ObjectId idThread;
					forum.supprimerMessageFromThread( panel.getIdMessage(), currentDiscussion ); // supprimer un message d'une discussion 
					try {
						refreshPanelMessages(currentIndex); // rafraichir le panel des messages
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
				else if(lblBtn.getText().equals("deleteThread")){ // verifier si le label cliquer a bien le text deleteThread
					System.out.println("ima delete");
					DiscussionPanel discussion = (DiscussionPanel)lblBtn.getParent(); // instancier le panel DiscussionPanel en cherchant le parent component du label deleteThread
					System.out.println("ENFIN TABARNAQUE " + discussion.get_id());  
					forum.supprimerDiscution(discussion.get_id()); // supprimer une discussion
					refreshListeThreads(); // rafraichir le panel des discussions
				}
				else {
					if (lblBtn.getText().equals("sendMessage")) { // verifier si le label cliquer a bien le text sendMessage
						System.out.println("send message");
						try {
							System.out.println("TEXT TO ADD" + frameForum.getTxtpnTextReply().getText());
							forum.addMessage(frameForum.getTxtpnTextReply().getText(), currentDiscussion); // ajouter un nouveau message dans la discussion courrante
							refreshPanelMessages(currentIndex); // rafraichir le panel des messages
							frameForum.setTextReply(); // reinisialiser le text dans le textReply  
						} catch (ParseException e1) {
							e1.printStackTrace();
						}


					} else if (lblBtn.getText().equals("login"))
						System.out.println("Im gonna login message");
					
					else if (lblBtn.getText().equals("backToThreads")) { // verifier si le label cliquer a bien le text backToThreads
						this.frameForum.nextPanel(); // afficher le prochain panel dans le panelCardLayout
						refreshListeThreads(); // rafraichir le panel des discussions
						
					} else if (lblBtn.getText().equals("add")) { // verifier si le label cliquer a bien le text add
						System.out.println("IM GONNA ADD A THREAD");
						frameForum.startDialog(); // afficher le NewThreadDialog
						
					} else if (lblBtn.getText().equals("sendThread")) { // verifier si le label cliquer a bien le text sendThread
						System.out.println("YOOO");
						if (frameForum.isThreadCreated()) { // verifier si l'usage a bien ajouter la discussion
							try {
								forum.addDiscution(frameForum.getCreatedDicussion().getTitre(), frameForum.getCreatedDicussion().getUnMessage()); // ajouter une nouvelle discussion
								refreshListeThreads(); // rafraichir le panel des discussions
								frameForum.getDialog().clearChampsTextes(); // reinisialiser les champs du NewThreadDialog
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
			else if(e.getSource() instanceof MessagePanel){ // vérifier si la source provien d'un instance MessagePanel
				if(wasPanelClicked){ // vérifier si le un MessagePanel a été cliquer
					// si oui chager la coleur du fond du panel a blanc et le text a noir 
					lastSelectedmsgPanel.setBackground(Color.WHITE); 
					lastSelectedmsgPanel.changeForeGroundColor(Color.BLACK);
				}
				// si non chager la coleur du fond du panel a rebeccapurple  et le text a blanc 
				e.getComponent().setBackground(rebeccapurple);
				MessagePanel msg = (MessagePanel) e.getComponent();
				msg.changeForeGroundColor(Color.WHITE);
				lastSelectedmsgPanel = msg;
				wasPanelClicked = true;
			}
			else if(e.getSource() instanceof DiscussionPanel){ // vérifier si la source provien d'un instance DiscussionPanel
				System.out.println("ok on DiscussionPanel");

				DiscussionPanel panel = (DiscussionPanel)e.getComponent(); //  instancier le panel DiscussionPanel
				currentDiscussion = panel.get_id(); // chercher le ObjectId
				currentIndex = panel.getIndex(); // cercher l'index
						System.out.printf("YO" + String.valueOf(panel.get_id()));
				try {
					refreshPanelMessages(panel.getIndex()); // rafraichir le panel des messages par rapport à la discussion selectionner
					frameForum.setDescussionLabel(panel.getDiscussion()); // changer le label du title qui present la discussion choisie dans la page des messages
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				this.frameForum.nextPanel(); // aller vers la page des messages en changant au prochain panel dans panelCardlayout
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
				// quand la sourie hover sur un MessagePanel ou DiscussionPanel changer la coleur du fond du panel à  wistful
				e.getComponent().setBackground(wistful);
				try{
					MessagePanel msg = (MessagePanel) e.getComponent();
					msg.changeForeGroundColor(Color.WHITE);
					// si la sourie hover sur un panel selectionner ne pas chaner la color
					if(wasPanelClicked){
						if(lastSelectedmsgPanel.getIndex() == msg.getIndex()){
							lastSelectedmsgPanel.setBackground(rebeccapurple);
							lastSelectedmsgPanel.changeForeGroundColor(Color.WHITE);
							System.out.println("here");
						}
					}
				}catch (ClassCastException cce) {  
					((DiscussionPanel) e.getComponent()).changeForeGroundColor(Color.WHITE); // change la coleur du text à blanc si le panel est DiscussionPanel
				}
			}
			else if(e.getSource() instanceof JLabel){ 
				// si la sourie hover sur un label avec le text deleteMsg ou deleteThread chager la couleur du fond du panel a rouge alerte
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
			// pour le mouse exit le panel qui a été hover par la sourie reinisialise sa coleur du fond et la couleur du son text
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