package levelBuilder.controller;

import levelBuilder.entity.LevelBuilder;
import common.boundary.CellPanel;
import common.entity.Cell;
import common.entity.Move;

public class ChangeCellTypeMove extends Move{
	
	CellPanel cell;
	
	public ChangeCellTypeMove(CellPanel cell){
		this.cell = cell;
	}

	@Override
	public boolean doMove(LevelBuilder editor) {
		if (!valid(editor)){ return false; }
		cell.getCellModel().toggleActive();
		cell.getTileView().toggleNumber();
		return true;
	}

	@Override
	public boolean undo(LevelBuilder editor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		// TODO Auto-generated method stub
		return true;
	}

}
