package levelBuilder.controller;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import common.entity.Level;

import levelBuilder.boundary.LevelBuilderFrame;

/**
 * Controller for the new level button on the MainMenu panel
 * @author August
 *
 */
public class NewLevelButtonController implements MouseListener {
	
	LevelBuilderFrame LbF;
	
	/**
	 * Class constructor
	 * @param frame: the LevelBuilderFrame to which the MainMenu belongs
	 */
	public NewLevelButtonController(LevelBuilderFrame frame) {
		this.LbF = frame;
	}

	/**
	 * On mouse click constructs a new level and displays the edit panel in the LevelBulderFRrame
	 * @param e mouse event in question
	 */
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
