
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
 * Controller used to toggle whether or not a swap move is to be used the next time the user interacts with the board
 * 
 * Author: Arty
 **/

public class SwapController implements MouseListener{
	GameFrame gf;
	
	public SwapController(GameFrame gf){
		this.gf = gf;
	}

	public void mouseClicked(MouseEvent e) {
		//If it's already selected we want to de-select it
		if (gf.getPlayView().getSwapButton().isSelected() == true && gf.getPlayView().getSwapButton().isEnabled() == true){
			
			gf.getPlayView().getRemoveButton().setEnabled(false);
			gf.getPlayView().getShuffleButton().setEnabled(false);
			return;
		}
		
		//At this point we know it's not selected, so we JUST need to check for whether it's enabled.
		//We also know that this means the user wants to use this special move
		if (gf.getPlayView().getSwapButton().isEnabled() == true){
			
			//We only want to re-enable the other buttons if they are supposed to be re-enabled! So we only do it if they don't have 0 moves remaining.
			if (gf.getPlayView().getBoard().getRemovesRemaining() != 0){
				gf.getPlayView().getRemoveButton().setEnabled(true);
			}
			
			if (gf.getPlayView().getBoard().getShufflesRemaining() != 0){
				gf.getPlayView().getShuffleButton().setEnabled(true);
			}
			
			//The special move itself is done in the select cell move, which will check to see whether any of the special moves are selected.
			//If none are selected, then a normal move will be done when you click/interact with the board.
			//So this controller essentially toggles whether or not you are using a special move but doesn't actually do the move here
			
			//TODO BELOW IS TEMPORARY FOR TESTING - WILL OCCUR IN MOVE, NOT HERE - REMOVE ONCE MOVE IS IMPLEMENTED 
			int currentSwapsRemaining = gf.getPlayView().getBoard().getSwapsRemaining();
			gf.getPlayView().getBoard().setSwapsRemaining(currentSwapsRemaining - 1);
			
			//refresh the playView so that the values for the moves update visually
			gf.getPlayView().refresh();
			
			//ABOVE IS TEMPORARY FOR TESTING
		}
		
		gf.getPlayView().getBoard().checkWin();
		gf.getPlayView().getBoard().moveMade(gf.getPlayView());
		
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
