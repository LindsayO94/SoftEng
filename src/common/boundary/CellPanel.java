package common.boundary;

import java.util.Random;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import common.entity.Cell;
import common.entity.Tile;

public class CellPanel extends JPanel {
	Cell cellModel;
	
	TilePanel tileView;
	
	public CellPanel(Cell cell, TilePanel tileView) {
		this.cellModel = cell;
		
		
		
		// TODO: This can't be null forever -- where should the 
		// tile come from?
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
	
	public Cell getCellModel(){
		return cellModel;
	}
	
	public TilePanel getTileView(){
		return tileView;
	}

}
