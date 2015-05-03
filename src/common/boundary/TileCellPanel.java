package common.boundary;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import common.entity.Cell;
import common.entity.TileCell;

public class TileCellPanel extends CellPanel {
	TileCell cell;

	public TileCellPanel(TileCell cell, TilePanel tileView) {
		super(cell, tileView);
		this.cell = cell;
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tileView, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tileView, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		
		refresh();
	}
	
	public void refresh() {
		if (cell.isSelected()) {
			setBorder(new LineBorder(new Color(0, 255, 255), 2));
		} else if (cell.isMarked()) {
			setBorder(new LineBorder(new Color(255, 255, 255), 2));
		} else {
			setBorder(new LineBorder(new Color(0, 0, 0), 1));
		}
	}
}
