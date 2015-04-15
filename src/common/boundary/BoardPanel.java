package common.boundary;

import javax.swing.JPanel;

import common.entity.Board;

import java.awt.GridLayout;

public class BoardPanel extends JPanel {
	// Entities
	Board board;
	CellPanel[] cells = new CellPanel[81]; 
	
	public BoardPanel(Board board) {
		this.board = board;
		
		// HERE THERE BE WINDOW BUILDER
		setLayout(new GridLayout(9, 9, 0, 0));
		
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new CellPanel(null);
			add(cells[i]);
		}
	}

}
