package levelBuilder.controller;

import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.Move;
import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.entity.Cell;
import common.entity.Level;

public class ChangeCellTypeMove extends Move{
	
	CellPanel cell;
	BoardPanel board;
	
	public ChangeCellTypeMove(CellPanel cell, BoardPanel board){
		this.cell = cell;
		this.board = board;
	}

	@Override
	public boolean doMove(LevelBuilder editor) {
		if (!valid(editor)){ return false; }
		
		editor.getLevel().toggleCell(cell.getCellModel());
		
		board.getBoardModel().refreshCell(cell.getCellModel());
		board.refresh();
		
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
