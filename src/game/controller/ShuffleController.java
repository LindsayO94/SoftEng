
package game.controller;
import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import common.entity.Board;
import common.entity.Cell;
import common.entity.Level;
import common.entity.PuzzleBoard;
import common.entity.Tile;
import common.entity.Cell.Type;
import common.entity.TileCell;

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
			ArrayList<Tile> allTiles = new ArrayList<Tile>();
			
			ArrayList<ArrayList<Cell>> cells = gf.getPlayView().getBoard().getCells();
			for (int row = cells.size() - 1; row >= 0; row--) {
				for (int col = cells.get(row).size() - 1; col >= 0; col--) {
					Cell currentCell = cells.get(col).get(row);
					if (currentCell.getType() == Type.TILE_CELL) {
						Tile t = ((TileCell) currentCell).getTile();
						if (t.getValue() != 6) {
							allTiles.add(t);
							((TileCell) currentCell).setTile(null);
						}
					}
				}
			}
			
			Collections.shuffle(allTiles);
			
			for (int row = cells.size() - 1; row >= 0; row--) {
				for (int col = cells.get(row).size() - 1; col >= 0; col--) {
					Cell currentCell = cells.get(col).get(row);
					if (currentCell.getType() == Type.TILE_CELL) {
						Tile t = ((TileCell) currentCell).getTile();
						if (t == null) {
							((TileCell) currentCell).setTile(allTiles.remove(0));
						}
					}
				}
			}
			
			int currentShufflesRemaining = gf.getPlayView().getBoard().getShufflesRemaining();
			gf.getPlayView().getBoard().setShufflesRemaining(currentShufflesRemaining - 1);
			
			//refresh the playView so that the values for the moves update visually
			gf.getPlayView().refresh();
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
