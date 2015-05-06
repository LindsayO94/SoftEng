package common.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFileChooser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import common.LevelSaver;
import common.entity.Cell.Type;

public class Level {
	public static final String[] allowedTypes = { "Puzzle", "Lightning", "Elimination", "Release" }; 

	// Transient means it won't be in the JSON
	transient Random rand;
	
	int levelNumber;
	
	// State -- only Game can change these fields
	boolean locked;
	boolean isWon;
	int highScore;
	
	// Configuration -- only LevelBuilder can change these fields
	String type;
	
	Cell.Type startingConfig[][] = new Cell.Type[9][9];
	
	int frequency[] = new int[6];
	int multiplierFrequency[] = new int[3];
	
	//integers representing the number of each move type a player is given at the start of a level
	int numSwap;
	int numRemove;
	int numShuffle;

	
	//All levels but lightning use maxMoves
	int maxMoves;

	//attributes required for weird levels!
	int maxTime; 		//Lightning
	int numBaskets; 	//Release
	int numActiveCells; //Elimination
	
	//array for star achieving thresholds
	int starScore[] = new int[3];

	public Level(String type, long seed) {
		if (!Arrays.asList(Level.allowedTypes).contains(type)) {
			throw new IllegalArgumentException("Illegal level type");
		}
		
		this.levelNumber = -1;
		
		this.type = type;
		
		this.rand = new Random(seed);
	
		// Default to all active
		this.numActiveCells = 81;
		
		// Default to a decent distribution
		frequency[0] = 10;
		frequency[1] = 10;
		frequency[2] = 10;
		frequency[3] = 10;
		frequency[4] = 10;
		frequency[5] = 5;
		
		
		if (type.equals("Release")) {
			frequency[5] = 0;
		}
		
		// Default to a decent distribution
		multiplierFrequency[0] = 10;
		multiplierFrequency[1] = 5;
		multiplierFrequency[2] = 1;
		
		// Default to all cells are tile cells
		for (int i = 0; i < startingConfig.length; i++) {
			for (int j = 0; j < startingConfig[i].length; j++) {
				startingConfig[i][j] = Cell.Type.TILE_CELL;  
			}
		}
		
		// Default to a decent distribution
		starScore[0] = 100;
		starScore[1] = 500;
		starScore[2] = 1000;
		
		// Default to 3 of each move is allowed
		numShuffle = 3;
		numSwap = 3;
		numRemove = 3;
		
		// Default to 20 moves
		maxMoves = 20;
		// Default to 2 minutes
		maxTime = 120;
	}

	public Level(long seed) {
		this("Puzzle", seed);
		locked = false;
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
		if (total==0){
			throw new IllegalArgumentException("At least one weight must be non-zero");
		}
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
		try{
			return new Tile(getWeightedRandomIndex(frequency) + 1, getWeightedRandomIndex(multiplierFrequency) + 1);
		}catch (IllegalArgumentException e){
			throw e;
		}
		
	}

	/**
	 * 
	 * @author Lindsay
	 *
	 */
	
	public void toggleCell(Cell cell) {
		if (this.type.equals("Release")) {
			switch (startingConfig[cell.column][cell.row]) {
			
			case TILE_CELL:
				startingConfig[cell.column][cell.row] = Type.INACTIVE_CELL;
				break;
				
			case INACTIVE_CELL:
				startingConfig[cell.column][cell.row] = Type.BASKET_CELL;
				break;
				
			case BASKET_CELL:
				startingConfig[cell.column][cell.row] = Type.TILE_CELL;
				break;
				
			default:
				throw new IllegalStateException("Tile for a Release board had a type other than TILE, BASKET, or INACTIVE");
			
			}
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
	
	public int[] getFrequencyArray() {
		return frequency;
	}

	public void setFrequency(int[] frequency) {
		this.frequency = frequency;
	}

	public int getMultiplierFrequency(int index) {
		return multiplierFrequency[index];
	}
	
	public int[] getMultiplierFrequencyArray() {
		return multiplierFrequency;
	}

	public void setMultiplierFrequency(int[] multiplierFrequency) {
		this.multiplierFrequency = multiplierFrequency;
	}

	public int getStarScore(int index) {
		return starScore[index];
	}
	
	public int[] getStarScoreArray(){
		return starScore;
	}

	public void setStarScore(int[] starScore) {
		this.starScore = starScore;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (levelNumber != -1) {
			throw new UnsupportedOperationException("Level type may not be changed after the level is first saved");
		}
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

	public int getStar1Score() {
		return starScore[0];
	}

	public void setStar1Score(int star1Score) {
		this.starScore[0] = star1Score;
	}

	public int getStar2Score() {
		return starScore[1];
	}

	public void setStar2Score(int star2Score) {
		this.starScore[1] = star2Score;
	}

	public int getStar3Score() {
		return starScore[2];
	}

	public void setStar3Score(int star3Score) {
		this.starScore[2] = star3Score;
	}

	public void setRand(Random rand) {
		// Only allowed once, right after creation
		if (this.rand != null) {
			throw new UnsupportedOperationException("Not allowed to reassign the "
					+ "random number generator after level creation");
		}
		this.rand = rand;
	}

	public int getNumber() {
		return levelNumber;
	}

	public String filename() {
		return this.type + "_" + this.levelNumber + ".json";
	}

	public void setNumber(int num) {
		this.levelNumber = num;
	}
	
	public int getMaxMoves() {
		return maxMoves;
	}

	public void setMaxMoves(int maxMoves) {
		this.maxMoves = maxMoves;
	}
	
	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	
	public int getNumBaskets(){
		return numBaskets;
	}
	
	public void setNumBaskets(int numBaskets){
		this.numBaskets = numBaskets;
	}

	public int getNumActiveCells() {
		return numActiveCells;
	}

	public void setNumActiveCells(int numActiveCells) {
		this.numActiveCells = numActiveCells;
	}

	public int getRandomMultiplier() {
		return getWeightedRandomIndex(multiplierFrequency) + 1;
	}

	public int getRandomInt(int max) {
		return rand.nextInt(max);
	}
	
	public boolean getLocked(){
		return locked;
	}
	
	public void setLocked(boolean locked){
		this.locked = locked;
	}

	public boolean getIsWon(){
		return isWon;
	}
	
	public void setIsWon(boolean b) {
		this.isWon = b;
	}

	public String getNextLevelFilename() {
		return this.type + "_" + (this.levelNumber+1) + ".json";
	}
}
