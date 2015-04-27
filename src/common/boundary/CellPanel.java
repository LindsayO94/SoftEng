package common.boundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import common.entity.Cell;
import common.entity.Tile;

public abstract class CellPanel extends JPanel {
	Cell cellModel;
	
	public CellPanel(Cell cell) {
		this.cellModel = cell;
	}

}
