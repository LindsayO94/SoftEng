package levelBuilder.controller;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.boundary.LevelBuilderFrame;

public class NewLevelButtonController implements MouseListener {
	
	LevelBuilderFrame LbF;
	
	public NewLevelButtonController(LevelBuilderFrame frame) {
		this.LbF = frame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) LbF.getContentPane().getLayout();
		cardLayout.show(LbF.getContentPane(), "Editor");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
