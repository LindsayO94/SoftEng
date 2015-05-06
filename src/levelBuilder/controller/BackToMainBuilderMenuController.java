package levelBuilder.controller;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.boundary.LevelBuilderFrame;
/**
 * Controller for the back button on the level edit Panel
 * @author August
 *
 */
public class BackToMainBuilderMenuController implements MouseListener {
	
	LevelBuilderFrame LbF;
	
	/**
	 * BackToMainBuilderMenuController: Constructs a BackToMainBuilderMenuController object
	 * @param frame: The level builder frame this controller may update.
	 */
	public BackToMainBuilderMenuController(LevelBuilderFrame frame){
		this.LbF = frame;
		
	}

	/**
	 * mouseClicked: On mouse click of the back button show the Main Menu Panel
	 * @param e
	 */
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
