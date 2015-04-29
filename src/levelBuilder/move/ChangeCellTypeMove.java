package levelBuilder.move;

import levelBuilder.entity.LevelBuilder;
import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.entity.Board;
import common.entity.Cell;
import common.entity.Level;
import common.entity.Move;

public class ChangeCellTypeMove extends Move{
	
	Cell cell;
	Board board;
	
	public ChangeCellTypeMove(Cell cell, Board board){
		this.cell = cell;
		this.board = board;
	}

	@Override
	public boolean doMove(LevelBuilder editor) {
		if (!valid(editor)){ return false; }
		
		editor.getLevel().toggleCell(cell);
		
		board.refreshCell(cell);
		
		return true;
	}

	@Override
	public boolean undo(LevelBuilder editor) {
		
		editor.getLevel().toggleCell(cell);
		board.refreshCell(cell);
		return true;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		// TODO Auto-generated method stub
		return true;
	}

}
