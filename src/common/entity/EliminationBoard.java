package common.entity;


public class EliminationBoard extends Board {

	int movesLeft; //decremented upon executing a move
	int cellsLeftToMark; //this is decremented upon marking a cell
	
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
