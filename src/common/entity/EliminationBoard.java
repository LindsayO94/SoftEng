package common.entity;


public class EliminationBoard extends Board {

	int movesLeft;
	
	public EliminationBoard(Level level) {
		super(level);
		
		this.movesLeft = level.maxMoves;
	}

	@Override
	public boolean isWon() {
		// mark all cells
		return false;
	}

}
