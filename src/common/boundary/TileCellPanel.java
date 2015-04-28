package common.boundary;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import common.entity.Cell;
import common.entity.TileCell;

public class TileCellPanel extends CellPanel {	
	
	public TileCellPanel(TileCell cell, TilePanel tileView) {
		super(cell, tileView);
		
		
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
	}
}
