package common.entity;


public class EliminationBoard extends Board {

	int movesLeft;
	int cellsLeftToMark;
	
	public EliminationBoard(Level level) {
		super(level);
		
		this.movesLeft = level.maxMoves;
		this.cellsLeftToMark = level.getNumActiveCells();
	}

	@Override
	public boolean isWon() {
		// mark all cells
		if (cellsLeftToMark == 0){
			return true;
		}
		return false;
	}

}
