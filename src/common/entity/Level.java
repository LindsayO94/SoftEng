package common.entity;

public class Level {
	// State -- only Game can change these fields
	boolean locked;
	boolean isWon;
	int highScore;
	
	// Configuration -- only LevelBuilder can change these fields
	String type;
	
	Cell startingConfig[] = new Cell[81];
	
	int frequency[] = new int[6];
	int multiplierFrequency[] = new int[3];
	
	boolean shuffleAllowed;
	boolean swapAllowed;
	boolean removeAllowed;
	
	int maxMoves;
	int maxTime;
	
	int starScore[] = new int[3];
}
