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
		LbF.showMainMenu();
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
