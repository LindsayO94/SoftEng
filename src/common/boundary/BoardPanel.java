package common.boundary;

import javax.swing.JPanel;


import common.entity.Board;
import common.entity.Cell;

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
				cells[i] = new CellPanel(cell);
				add(cells[i]);
				i += 1;
			}
		}
	}
}
