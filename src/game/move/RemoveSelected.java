package game.move;

import java.util.ArrayList;

import game.entities.Game;
import common.entity.Board;
import common.entity.Cell;
import common.entity.TileCell;

public class RemoveSelected extends gameMove{
	
	Board board;
	
	public RemoveSelected(Board board){
		this.board = board;
	}

	
	@Override
	public boolean doMove(Game game) {
		if(valid(game)==true)
		{
			
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