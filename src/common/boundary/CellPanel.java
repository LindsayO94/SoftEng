package common.boundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import common.entity.Cell;

public abstract class CellPanel extends JPanel {
	final Cell cellModel;
	final TilePanel tileView;
	
	public CellPanel(Cell cell, TilePanel tileView) {
		this.cellModel = cell;
		
		this.tileView = tileView;
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
	
	
	public CellPanel(Cell cell) {
		this.cellModel = cell;
		this.tileView = null;
	}
	
	public Cell getCellModel(){
		return cellModel;
	}
	
	public TilePanel getTileView(){
		return tileView;
	}

}
