package common.boundary;

import game.controller.CellSelectController;

import javax.swing.JPanel;

import common.entity.BasketCell;
import common.entity.Board;
import common.entity.InactiveCell;
import common.entity.Tile;
import common.entity.TileCell;

import java.awt.GridLayout;
import java.util.Random;

import levelBuilder.controller.ChangeCellTypeController;
import levelBuilder.entity.LevelBuilder;
import common.entity.Cell;
import common.entity.TileCell;

import java.awt.GridLayout;
import java.util.ArrayList;

public class BoardPanel extends JPanel {
	// Entities
	public Board board;
	public CellPanel[] cells = new CellPanel[81]; 
	
	public BoardPanel(Board board) {
		this.board = board;
		
		setLayout(new GridLayout(9, 9, 0, 0));
		
		refresh();
	}
	
	public void refresh() {
		if (board == null) throw new IllegalArgumentException("Board cannot be null");
		
		removeAll();
		int i = 0;
		for (ArrayList<Cell> row : board.getCells()) {
			for (Cell cell : row) { 
				switch (cell.getType()) {
				case TILE_CELL:
					TilePanel tileView = new TilePanel( ((TileCell) cell).getTile() );
					cells[i] = new TileCellPanel((TileCell) cell, tileView);
					break;
					
				case INACTIVE_CELL:
					cells[i] = new InactiveCellPanel((InactiveCell) cell);
					break;
					
				case BASKET_CELL:
					cells[i] = new BasketCellPanel((BasketCell) cell);
					break;
				}
				add(cells[i]);
				i += 1;
			}
		}
		
		validate(); // Recomputes layout
		repaint();
	}
	
	
	
	public CellPanel[] getCellPanel(){
		return cells;
	}
	
	public void setBoard(Board b) {
		this.board = b;
	}
	
	public Board getBoardModel() {
		return board;
	}
	
	public int getNumBaskets() {
		int i = 0;
		for (ArrayList<Cell> row : board.getCells()) {
			for (Cell cell : row) { 
				switch (cell.getType()) {
				case BASKET_CELL:
					i++;
					break;
				default:
					break;
				}
			}
		}
		return i;
	}
}
