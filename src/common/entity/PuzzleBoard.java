package common.entity;


public class PuzzleBoard extends Board {

	int movesLeft; //decremented upon executing a move
	
	public PuzzleBoard(Level level) {
		super(level);
		
		this.movesLeft = level.getMaxMoves();
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

}
