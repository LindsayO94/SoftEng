package common.entity;


public class PuzzleBoard extends Board {

	int movesLeft;
	
	public PuzzleBoard(Level level) {
		super(level);
		
		this.movesLeft = level.maxMoves;
	}

	@Override
	public boolean isWon() {
		// Reach certain score before exhausting number of allowed moves
		//if the high score is higher than the lowest star score value, then the level is won
		if (level.starScore[0] < level.highScore){
			return true;
		}
		return false;
	}

}
