
package game.controller;
import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import common.entity.Board;
import common.entity.Level;
import common.entity.PuzzleBoard;

/**
 * SwapController.java
 * 
 * Controller used to execute a shuffle move when the shuffle button is pressed
 * 
 * Author: Arty
 **/

public class ShuffleController implements MouseListener{
	GameFrame gf;
	
	public ShuffleController(GameFrame gf){
		this.gf = gf;
	}

	public void mouseClicked(MouseEvent e) {
		
		if (gf.getPlayView().getShuffleButton().isEnabled() == true){
			//TODO Shuffle the non-6 values
			
			
			int currentShufflesRemaining = gf.getPlayView().getBoard().getShufflesRemaining();
			gf.getPlayView().getBoard().setShufflesRemaining(currentShufflesRemaining - 1);
			
			//refresh the playView so that the values for the moves update visually
			gf.getPlayView().refresh();
			
			//ABOVE IS TEMPORARY FOR TESTING
		}
		
		return;
		
		
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
