package game.move;


import common.boundary.TileCellPanel;
import common.entity.Board;
import common.entity.Cell;
import common.entity.TileCell;
import game.entities.Game;
import game.move.gameMove;

public class SelectMove extends gameMove{
	
	Cell cell;
	Board board;
	
	public SelectMove(Cell cell, Board board){
		this.cell = cell;
		this.board = board;
	}

	
	@Override
	public boolean doMove(Game game) {
		if(valid(game)==true)
		{
			((TileCell) cell).setSelected();
			board.refreshCell(cell);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean undo(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid(Game game) {
		// TODO Auto-generated method stub
		return true;
	}



	

}

