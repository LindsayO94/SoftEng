package levelBuilder.controller;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import common.entity.Level;

import levelBuilder.boundary.LevelBuilderFrame;

public class NewLevelButtonController implements MouseListener {
	
	LevelBuilderFrame LbF;
	
	public NewLevelButtonController(LevelBuilderFrame frame) {
		this.LbF = frame;
	}

	public void mouseClicked(MouseEvent e) {
		LbF.showEditor(new Level(0));
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
