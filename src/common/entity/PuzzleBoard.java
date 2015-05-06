package common.entity;


public class PuzzleBoard extends Board {
	
	public PuzzleBoard(Level level) {
		super(level);
	}

	@Override
	public boolean isWon() {
		// Reach certain score before exhausting number of allowed moves
		//if the high score is higher than the lowest star score value, then the level is won
		if (level.getStar1Score() < this.getScore()){
			return true;
		}
		return false;
	}

	@Override
	public boolean isCompleted() {
		return this.getMovesRemaining() <= 0;
	}

}
