package common.boundary;

import javax.swing.JPanel;

import common.entity.Board;
<<<<<<< .merge_file_a90884
import common.entity.Tile;
import common.entity.TileCell;

import java.awt.GridLayout;
import java.util.Random;

import levelBuilder.controller.ChangeCellTypeController;
=======
import common.entity.Cell;
import common.entity.TileCell;

import java.awt.GridLayout;
import java.util.ArrayList;
>>>>>>> .merge_file_a92660

public class BoardPanel extends JPanel {
	// Entities
	Board board;
	CellPanel[] cells = new CellPanel[81]; 
	
	public BoardPanel(Board board) {
		this.board = board;
		
		setLayout(new GridLayout(9, 9, 0, 0));
<<<<<<< .merge_file_a90884
		int row = 0, column = 0;
		Random r = new Random();
		for (int i = 0; i < cells.length; i++) {
			Tile t = new Tile(r.nextInt(6)+1, 1);
			TilePanel tp = new TilePanel(t);
			TileCell c = new TileCell(row, column, t, true);
			cells[i] = new CellPanel(c, tp);
			cells[i].addMouseListener(new ChangeCellTypeController(cells[i]));
			add(cells[i]);
			
=======
				
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
>>>>>>> .merge_file_a92660
		}
	}
}
