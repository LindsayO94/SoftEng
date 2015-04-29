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
	
	//integers representing the number of each move type a player is given at the start of a level
	int numShuffle;
	int numSwap;
	int numRemove;
	
	
	
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
		
		// Temporary - For now, all starScores are 1
		for (int i = 0; i < starScore.length; i++) {
			starScore[i] = 1;
		}
		
		//Temporary - for now 1 of each move is allowed
		numShuffle = 1;
		numSwap = 1;
		numRemove = 1;
		
		
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

	public int getFrequency(int index) {
		return frequency[index];
	}

	public void setFrequency(int[] frequency) {
		this.frequency = frequency;
	}

	public int getMultiplierFrequency(int index) {
		return multiplierFrequency[index];
	}

	public void setMultiplierFrequency(int[] multiplierFrequency) {
		this.multiplierFrequency = multiplierFrequency;
	}

	public int getStarScore(int index) {
		return starScore[index];
	}

	public void setStarScore(int[] starScore) {
		this.starScore = starScore;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumShuffle() {
		return numShuffle;
	}

	public void setNumShuffle(int numShuffle) {
		this.numShuffle = numShuffle;
	}

	public int getNumSwap() {
		return numSwap;
	}

	public void setNumSwap(int numSwap) {
		this.numSwap = numSwap;
	}

	public int getNumRemove() {
		return numRemove;
	}

	public void setNumRemove(int numRemove) {
		this.numRemove = numRemove;
	}
}
