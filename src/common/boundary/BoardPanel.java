package common.boundary;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class BoardPanel extends JPanel {
	CellPanel[] cells = new CellPanel[81]; 
	
	public BoardPanel() {
		setLayout(new GridLayout(9, 9, 0, 0));
		
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new CellPanel();
			add(cells[i]);
		}
	}

}
