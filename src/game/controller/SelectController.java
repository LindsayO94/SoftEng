package game.controller;

import game.boundary.PlayGamePanel;
import game.entities.Game;
import game.move.RemoveSelected;
import game.move.SelectMove;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import levelBuilder.move.ChangeCellTypeMove;
import levelBuilder.move.RemoveMove;
import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.boundary.TileCellPanel;
import common.boundary.TilePanel;
import common.entity.Cell;
import common.entity.Tile;
import common.entity.TileCell;


//basket cases need to accounted for. Just add to the switch statements
//also there is a point where assumed click on TileCell, change that to Cell and error check on click or select or whatever. 

public class SelectController implements MouseMotionListener, MouseListener{
	BoardPanel boardPanel;
	Game game;
	ArrayList<CellPanel> cells = new ArrayList<CellPanel>();
	ArrayList<TileCell> cellsM = new ArrayList<TileCell>();
	PlayGamePanel gamePanel;
	
	//TODO what is this?
	//boolean mousePressed = false;
	
	public SelectController(BoardPanel boardPanel, Game game, PlayGamePanel gamePanel){
		this.boardPanel = boardPanel;
		this.game = game;
		this.gamePanel = gamePanel;
		
	}
	
	public void mousePressed(MouseEvent me) {
		
			CellPanel cellPanel = (CellPanel) boardPanel.getComponentAt(me.getPoint());
			Cell cell = cellPanel.getCellModel();
			
			//TODO Eclipse is telling me this is dead code. Is it?
			if (cellPanel == null) {
				System.out.println("mouse pressed event occurred with no component");
				return;
			}
			
			/*
			 *  SWAP CODE START
			 * 	SWAP CODE START
			 *  SWAP CODE START
			 */
			
			//if swap is selected, then this will be a swap move instead of doing nothing.
			if (gamePanel.getSwapButton().isSelected()){
				
				System.out.println("-mouse Pressed on board while swap button is selected");
				
				//but we need to make sure what we're going to fiddle with is a tile cell
				//System.out.println(cell.getType());
	
				
				if (cell.getType().equals(Cell.Type.TILE_CELL)){
					
					System.out.println("--and it's a tile cell");
					
					//since it's a tile cell, let's force java to believe that
					TileCell tileCell = (TileCell) cell;
					
					//if the tile is selected, it can only mean that the tile was the first tile in the swap selection, so we'll just reset
					if (tileCell.isSelected()){
						System.out.println("---But it was the same one as the first selection! Deselecting and clearing arrays");
						tileCell.setSelected(false);
						cells.clear();
						cellsM.clear();
						boardPanel.refresh();
						return;
					}
					
					//if there is a tile selected already
					if (!cells.isEmpty()){
						
						//swap this cell's and the already-selected cell's tiles
						
						//get the tiles to be swapped
						Tile tile1 = tileCell.getTile();
						Tile tile2 = cellsM.get(0).getTile();
						
						//swap the tiles
						tileCell.setTile(tile2);
						cellsM.get(0).setTile(tile1);
						
						//deselect the first cell
						cellsM.get(0).setSelected(false);
						
						//clear the cell arrays so that future moves work as intended
						cells.clear();
						cellsM.clear();
						
						//let's see the magic happen
						boardPanel.refresh();
						
						//Move completed, so let's deselect the button and deduct a regular move and a swap move
						gamePanel.getSwapButton().setSelected(false);
						
						int currentMovesRemaining = boardPanel.getBoardModel().getMovesRemaining();
						boardPanel.getBoardModel().setMovesRemaining(currentMovesRemaining - 1);
						
						int currentSwapsRemaining = boardPanel.getBoardModel().getSwapsRemaining();
						boardPanel.getBoardModel().setSwapsRemaining(currentSwapsRemaining - 1);
						
						return;
					}
					
					//if there is no tile selected
					if (cells.isEmpty()){
						
						System.out.println("---cell list is empty");
	
						
						//add cell and cell model to array
						tileCell.setSelected(true);
						cells.add(cellPanel);
						cellsM.add(tileCell);
						boardPanel.refresh();
						
						System.out.println("---selected cell, added cell to arrays and refreshed board. Waiting for new cell to be selected");
						
						return;
					}
				}
			}
	
			/*
			 *  REMOVE CODE START
			 * 	REMOVE CODE START
			 *  REMOVE CODE START
			 */
			
			//if swap is selected, then this will be a remove move instead of doing nothing.
			if (gamePanel.getRemoveButton().isSelected()){
				
				//make sure it's a tile cell before removing it. That'd be bad. Yikes.
				if (cell.getType().equals(Cell.Type.TILE_CELL)){
					((TileCell)cell).setTile(null);
					boardPanel.getBoardModel().gravity(boardPanel.getBoardModel());
					boardPanel.refresh();
					
					System.out.println("SMASH BROTHERS");
					
					//Move completed, so let's deselect the button and deduct a regular move and a remove move
					gamePanel.getRemoveButton().setSelected(false);
					
					int currentMovesRemaining = boardPanel.getBoardModel().getMovesRemaining();
					boardPanel.getBoardModel().setMovesRemaining(currentMovesRemaining - 1);
					
					int currentRemovesRemaining = boardPanel.getBoardModel().getRemovesRemaining();
					boardPanel.getBoardModel().setRemovesRemaining(currentRemovesRemaining - 1);
					
					return;
					
				}
			}
		
		}

	public void mouseDragged(MouseEvent me) {
		
			//We don't want mouseDragged to do anything if the person is trying to do a special move
			if (gamePanel.getSwapButton().isSelected() || gamePanel.getRemoveButton().isSelected() ){
				return;
			}
		
			//move the array to the move class
			CellPanel cell = (CellPanel) boardPanel.getComponentAt(me.getPoint());
			if (cell == null) {
				System.out.println("Drag event occurred with no component");
				return;
			}
			
			cells.add(cell);
			cellsM.add((TileCell)cell.getCellModel());
			SelectMove m = new SelectMove(cell.getCellModel(), boardPanel.getBoardModel(), cells);
			m.doMove(game);
			boardPanel.refresh();
			
			//((TileCellPanel) cell).refresh();
		}
		

	public void mouseEntered(MouseEvent me) {
		
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent me) {
		
		//We don't want mouseReleased to do anything if the person is trying to do a special move
		if (gamePanel.getSwapButton().isSelected() || gamePanel.getRemoveButton().isSelected() ){
			return;
		}
		
		//gravity not working b/c tiles are null when trying to refresh 
		RemoveSelected m = new RemoveSelected(boardPanel.getBoardModel(), cellsM, gamePanel);
		m.doMove(game);
		cells.clear();
		cellsM.clear();
		boardPanel.refresh();
		gamePanel.refresh();
		
		//for each cell in the selection
		for (int i = 0; i<cells.size(); i++){
				((TileCellPanel) cells.get(i)).refresh();
		}
		
	}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}