package common.entity;

import java.util.ArrayList;

public abstract class Board {
	ArrayList<ArrayList<Cell>> cells;
	Level level;
	int score;
	
	public Board(Level level) {
		this.level = level;
		
		cells = new ArrayList<ArrayList<Cell>>(9);
		for (int i = 0; i < level.startingConfig.length; i++) {
			cells.add(i, new ArrayList<Cell>(9));
			for (int j = 0; j < level.startingConfig[i].length; j++) {
				switch (level.startingConfig[i][j]) {
				case TILE_CELL:
					Tile tile = level.getRandomTile();
					cells.get(i).add(j, new TileCell(i, j, tile));
					break;
				default:
					throw new RuntimeException("Unknown tile type");
				}
			}
		}
	}
	
	public abstract boolean isWon();
	
	public void refresh() {
		// TODO: Implementation
	}
	
	public void gravity() {
		// TODO: Implementation
	}

	public ArrayList<ArrayList<Cell>> getCells() {
		return cells;
	}

	public static Board makeBoard(Level level) {
		switch (level.type) {
		case "Puzzle":
			return new PuzzleBoard(level);
			
		default:
			throw new IllegalArgumentException("Unknown board type");
		}
	}
}
