package levelBuilder.entity;

import common.entity.Board;
import common.entity.Level;

public class LevelBuilder {
	private Level level;
	private Board board;
	
	public LevelBuilder() {
		setLevel(new Level());
		setBoard(Board.makeBoard(level));
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
