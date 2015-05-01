package common.entity;

import java.util.ArrayList;

public abstract class Board {
	ArrayList<ArrayList<Cell>> cells;
	public Level level;
	int score;
	
	public Board(Level level) {
		this.level = level;
		
		this.refresh();
	}
	
	public abstract boolean isWon();
	
	public void refresh() {
		cells = new ArrayList<ArrayList<Cell>>(9);
		for (int i = 0; i < level.startingConfig.length; i++) {
			cells.add(i, new ArrayList<Cell>(9));
			for (int j = 0; j < level.startingConfig[i].length; j++) {
				cells.get(i).add(j, createCell(i, j));
			}
		}
	}
	
	public void refreshCell(Cell c) {
		cells.get(c.getColumn()).set(c.getRow(), createCell(c.getColumn(), c.getRow()));
	}
	
	public Cell createCell(int i, int j) {
		switch (level.startingConfig[i][j]) {
		case TILE_CELL:
			Tile tile = level.getRandomTile();
			return new TileCell(i, j, tile);
			
		case INACTIVE_CELL:
			return new InactiveCell(i, j);
			
		default:
			throw new RuntimeException("Unknown tile type");
		}
	}
	
	public void gravity() {
		// TODO: Implementation
	}

	public ArrayList<ArrayList<Cell>> getCells() {
		return cells;
	}

	public static Board makeBoard(Level level) {
		if (level.type.equals("Puzzle")){
			return new PuzzleBoard(level);
		}
		else{
			throw new IllegalArgumentException("Unknown board type");
		}
		/*switch (level.type) {
		case "Puzzle":
			return new PuzzleBoard(level);
			
		default:
			throw new IllegalArgumentException("Unknown board type");
		}*/
	}
	
	public int getScore(){
		return score;
	}
	
	public int incrementScore(int delta){
		score =+ delta;
		return score;
	}
	
	public Level getLevel(){
		return level;
	}
}
