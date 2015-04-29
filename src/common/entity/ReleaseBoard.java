package common.entity;


public class ReleaseBoard extends Board {

	int movesLeft;
	
	public ReleaseBoard(Level level) {
		super(level);
		
		this.movesLeft = level.maxMoves;
	}

	@Override
	public boolean isWon() {
		//When all the 6s are in baskets
		return false;
	}

}
