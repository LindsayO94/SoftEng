package common.entity;


public class ReleaseBoard extends Board {

	int movesLeft; //decremented upon executing a move
	int basketsLeft; //decremented upon filling a basket
	
	public ReleaseBoard(Level level) {
		super(level);
		
		this.movesLeft = level.maxMoves;
		this.basketsLeft = level.numBaskets;
	}

	@Override
	public boolean isWon() {
		//When all the 6s are in baskets
		if (basketsLeft == 0){
			return true;
		}
		return false;
	}

}
