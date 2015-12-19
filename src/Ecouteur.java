import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ecouteur implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			e.getComponent().setBackground(new Color(102, 51, 153));
			MessagePanel mgs = (MessagePanel) e.getComponent();
			mgs.changeForeGroundColor(Color.WHITE);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			e.getComponent().setBackground(Color.WHITE);
			MessagePanel mgs = (MessagePanel) e.getComponent();
			mgs.changeForeGroundColor(Color.BLACK);
			
		}
		
	}