package common.boundary;

import javax.swing.JPanel;

import common.entity.Board;
import common.entity.Tile;
import common.entity.TileCell;

import java.awt.GridLayout;
import java.util.Random;

import levelBuilder.controller.ChangeCellTypeController;

public class BoardPanel extends JPanel {
	// Entities
	Board board;
	CellPanel[] cells = new CellPanel[81]; 
	
	public BoardPanel(Board board) {
		this.board = board;
		
		// HERE THERE BE WINDOW BUILDER
		setLayout(new GridLayout(9, 9, 0, 0));
		int row = 0, column = 0;
		Random r = new Random();
		for (int i = 0; i < cells.length; i++) {
			Tile t = new Tile(r.nextInt(6)+1, 1);
			TilePanel tp = new TilePanel(t);
			TileCell c = new TileCell(row, column, t, true);
			cells[i] = new CellPanel(c, tp);
			cells[i].addMouseListener(new ChangeCellTypeController(cells[i]));
			add(cells[i]);
			
		}
	}

}
