package common.boundary;

import javax.swing.JPanel;

import common.entity.Board;
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
				
		int i = 0;
		for (ArrayList<Cell> row : board.getCells()) {
			for (Cell cell : row) {
				switch (cell.getType()) {
				case TILE_CELL:
					TilePanel tileView = new TilePanel( ((TileCell) cell).getTile() );
					cells[i] = new TileCellPanel(cell, tileView);
				}
				add(cells[i]);
				i += 1;
			}
		}
	}
	
	public CellPanel[] getCellPanel(){
		return cells;
	}
}
