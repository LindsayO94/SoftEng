package common.boundary;

import game.controller.CellSelectController;
import game.controller.SelectController;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import common.entity.Cell;
import common.entity.Tile;

public abstract class CellPanel extends JPanel {
	Cell cellModel;
	BoardPanel board;
	TilePanel tileView;
	
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
		this.addMouseListener(new CellSelectController(this));
	}
	
	
	public CellPanel(Cell cell) {
		this.cellModel = cell;
	}
	
	public Cell getCellModel(){
		return cellModel;
	}
	
	public TilePanel getTileView(){
		return tileView;
	}

}
