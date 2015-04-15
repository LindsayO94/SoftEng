package common.entity;

public abstract class Board {
	Cell currentConfig[];
	Level level;
	int score;
	
	public Board(Level level) {
		this.level = level;
		// Make sure to clone the starting array so modifications to currentConfig
		// don't modify level.startingConfig
		// TODO: Do we have to do anything to change from the cells in level, which
		// won't ever have tiles, to the cells in the board?
		this.currentConfig = level.startingConfig.clone();
	}
	
	public abstract boolean isWon();
	
	public void refresh() {
		// TODO: Implementation
	}
	
	public void gravity() {
		// TODO: Implementation
	}

	public Cell getCell(int i) {
		return currentConfig[i];
	}
}
