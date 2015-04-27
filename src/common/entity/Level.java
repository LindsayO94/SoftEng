package common.entity;

import game.boundary.PuzzleBoard;

public class Level {
	public static enum CellType {
		TILE_CELL
	}
	
	// State -- only Game can change these fields
	boolean locked;
	boolean isWon;
	int highScore;
	
	// Configuration -- only LevelBuilder can change these fields
	String type;
	
	CellType startingConfig[][] = new CellType[9][9];
	
	int frequency[] = new int[6];
	int multiplierFrequency[] = new int[3];
	
	boolean shuffleAllowed;
	boolean swapAllowed;
	boolean removeAllowed;
	
	int maxMoves;
	int maxTime;
	
	int starScore[] = new int[3];
	
	public Level(int highScore, String type) {
		this.setHighScore(highScore);
		this.type = type;
		
		// Temporary - For now, all cells are tile cells
		for (int i = 0; i < startingConfig.length; i++) {
			for (int j = 0; j < startingConfig[i].length; j++) {
				startingConfig[i][j] = CellType.TILE_CELL;
			}
		}
	}

	public Level() {
		this(0, "Puzzle");
	}

	public int getHighScore() {
		return highScore;
	}
	
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public Tile getRandomTile() {
		// TODO Auto-generated method stub
		return new Tile(1, 1);
	}

	public Board makeBoard() {
		switch (type) {
		case "Puzzle":
			return new PuzzleBoard(this);
			
		default:
			throw new RuntimeException("Unknown board type");
		}
	}
}
