package common.boundary;

import javax.swing.JPanel;

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
	Board board;
	CellPanel[] cells = new CellPanel[81]; 
	
	public BoardPanel(Board board) {
		this.board = board;
		
		setLayout(new GridLayout(9, 9, 0, 0));
				
		refresh();
	}
	
	public void refresh() {
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
	
	public Board getBoardModel() {
		return board;
	}
}
