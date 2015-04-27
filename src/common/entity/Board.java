package common.entity;

import java.util.ArrayList;


import common.entity.Level.CellType;

public abstract class Board {
	ArrayList<ArrayList<Cell>> currentConfig;
	Level level;
	int score;
	
	public Board(Level level) {
		this.level = level;
		
		currentConfig = new ArrayList<ArrayList<Cell>>(9);
		for (int i = 0; i < level.startingConfig.length; i++) {
			currentConfig.add(i, new ArrayList<Cell>(9));
			for (int j = 0; j < level.startingConfig[i].length; j++) {
				switch (level.startingConfig[i][j]) {
				case TILE_CELL:
					currentConfig.get(i).add(j, new TileCell(i, j, level.getRandomTile()));
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
		return currentConfig;
	}
}
