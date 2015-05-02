package levelBuilder.entity;


import java.util.Random;

import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.move.Move;
import levelBuilder.move.MultiplierFrequencyMove;
import common.entity.Board;
import common.entity.Level;

public class LevelBuilder {
	private Level level;
	private Board board;
	
	private Random seedGenerator = new Random();
	
	private LevelBuilderFrame frame;
	/** Stack of recent Moves */
	protected java.util.Stack<Move> moves = new java.util.Stack<Move>();
	
	public Board getBoard() {
		return board;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		this.board = Board.makeBoard(level);
	}
	
	public LevelBuilderFrame getFrame(){
		return frame;
	}
	
	public void setFrame(LevelBuilderFrame frame){
		this.frame = frame;
	}
	
	public long getSeed() {
		return seedGenerator.nextLong();
	}
	
	/**
	 * Returns most recent move and removes it from list of Moves.
	 * <p>
	 * If there are no moves present in this game, null is returned.
	 * <p>
	 * This method must be protected since only <code>undoMove()</code> should
	 * have access.
	 * <p>
	 * 
	 * @return the most recent Move made in this solitaire game.
	 */
	protected Move popMove() {
		// Return null if the stack of moves is empty.
		if (moves.isEmpty())
			return null;

		// pop most recent.
		return (Move) moves.pop();
	}

	/**
	 * Pushes given move onto our stack of existing moves.
	 * 
	 * @return boolean
	 * @param m
	 *            A Move object representing the most recent Move made in the
	 *     			the level editor.
	 */
	public boolean pushMove(Move m) {
		moves.push(m);
		return true;
	}

	/**
	 * six is wild stores all moves and enables them to be undone. Once a
	 * request to undo is received, this takes care of it.
	 * 
	 * @return boolean true means the move was successfully undone; false
	 *         otherwise.
	 */
	public boolean undoMove() {
		Move m = popMove();
		// unable to undo
		if (m == null) {
			// signal our disapproval.
			java.awt.Toolkit.getDefaultToolkit().beep();
			return false;
		}

		// Undo and refresh all widgets.
		boolean status = m.undo(this);
	
		if (status) {
			frame.getEditor().refresh();
		} else {
			// if we can't undo the move, we push it back onto the stack
			pushMove(m);
		}

		// return results.
		return status;
	}
	
	
}
