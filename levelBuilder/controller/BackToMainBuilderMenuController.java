package levelBuilder.controller;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.boundary.LevelBuilderFrame;

public class BackToMainBuilderMenuController implements MouseListener {
	
	LevelBuilderFrame LbF;
	
	public BackToMainBuilderMenuController(LevelBuilderFrame frame){
		this.LbF = frame;
		
	}

	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) LbF.getContentPane().getLayout();
		cardLayout.show(LbF.getContentPane(), "Main Menu");
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
