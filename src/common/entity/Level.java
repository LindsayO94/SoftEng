package common.entity;

import java.util.Arrays;
import java.util.Random;

import javax.naming.directory.InvalidAttributeValueException;

import common.entity.Cell.Type;

public class Level {
	public static final String[] allowedTypes = { "Puzzle", "Lightning", "Elimination", "Release" };
	Random rand;
	
	// State -- only Game can change these fields
	boolean locked;
	boolean isWon;
	int highScore;
	
	// Configuration -- only LevelBuilder can change these fields
	String type;
	
	Cell.Type startingConfig[][] = new Cell.Type[9][9];
	
	int frequency[] = new int[6];
	int multiplierFrequency[] = new int[3];
	
	boolean shuffleAllowed;
	boolean swapAllowed;
	boolean removeAllowed;
	
	int maxMoves;
	int maxTime;
	
	int starScore[] = new int[3];
	
	public Level(String type, long seed) {
		if (!Arrays.asList(Level.allowedTypes).contains(type)) {
			throw new IllegalArgumentException("Illegal level type");
		}
		
		this.type = type;
		
		this.rand = new Random(seed);
		
		// Temporary - For now, all frequencies are 1
		for (int i = 0; i < frequency.length; i++) {
			frequency[i] = 1;
		}
		
		// Temporary - For now, all multiplierFrequency are 1
		for (int i = 0; i < multiplierFrequency.length; i++) {
			multiplierFrequency[i] = 1;
		}
		
		
		// Temporary - For now, all cells are tile cells
		for (int i = 0; i < startingConfig.length; i++) {
			for (int j = 0; j < startingConfig[i].length; j++) {
				startingConfig[i][j] = Cell.Type.TILE_CELL;
			}
		}
	}

	public Level(long seed) {
		this("Puzzle", seed);
	}

	public int getHighScore() {
		return highScore;
	}
	
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	int getWeightedRandomIndex(int arr[]) {
		if (arr.length == 0) {
			throw new IllegalArgumentException("getWeightedRandomIndex cannot accept an empty array");
		}
		
		int total = 0;
		for (int freq : arr) total += freq;
		int num = rand.nextInt(total);
		
		for (int i = 0; i < arr.length; i++) {
			if (num < arr[i]) {
				return i;
			} else {
				num -= arr[i];
			}
		}
		
		throw new RuntimeException("Logic error when calculating random value");
	}

	public Tile getRandomTile() {
		return new Tile(getWeightedRandomIndex(frequency) + 1, getWeightedRandomIndex(multiplierFrequency) + 1);
	}

	public void toggleCell(Cell cell) {
		if (this.type.equals("Release")) {
			throw new UnsupportedOperationException("We haven't implemented toggling release boards yet");
		} else {
			switch (startingConfig[cell.column][cell.row]) {
			
			case TILE_CELL:
				startingConfig[cell.column][cell.row] = Type.INACTIVE_CELL;
				break;
				
			case INACTIVE_CELL:
				startingConfig[cell.column][cell.row] = Type.TILE_CELL;
				break;
				
			default:
				throw new IllegalStateException("Tile for a non-Release board had a type other than TILE or INACTIVE");
			
			}
		}
	}
}
