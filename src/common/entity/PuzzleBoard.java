package common.entity;


public class PuzzleBoard extends Board {
	
	boolean isEndlessMode;

	public PuzzleBoard(Level level) {
		super(level);
		isEndlessMode = false;
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
	
	@Override
	public boolean shouldShowCompletedMessage() {
		return isCompleted() && !isEndlessMode;
	}
	
	public void setEndlessMode(boolean b) {
		this.isEndlessMode = b;
	}

}
