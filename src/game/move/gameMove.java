package game.move;


import game.entities.Game;
import common.entity.Cell;


public abstract class gameMove {
	protected gameMove() { }
	
	public abstract boolean doMove (Game game);
	
	public abstract boolean undo(Game game);
	
	public abstract boolean valid (Game game);
}
