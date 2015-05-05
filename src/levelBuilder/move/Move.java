package levelBuilder.move;

import levelBuilder.entity.LevelBuilder;

/**
 * Abstract class representing a generic move in the LevelBuilder
 * @author Lindsay
 *
 */
public abstract class Move {
	protected Move() { }
	
	/**
	 * Method which contains move logic
	 * @param editor
	 * @return
	 */
	public abstract boolean doMove (LevelBuilder editor);
	
	/**
	 * Method which contains logic to undo a move
	 * @param editor
	 * @return
	 */
	public abstract boolean undo(LevelBuilder editor);
	
	
	/**
	 * Method which contains logic to determine if a move is valid
	 * @param editor
	 * @return
	 */
	public abstract boolean valid (LevelBuilder editor);
}
