package common.entity;


public class EliminationBoard extends Board {
	int cellsLeftToMark; //this is decremented upon marking a cell
	
	public EliminationBoard(Level level) {
		super(level);
		
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

	@Override
	public boolean isCompleted() {
		return this.getMovesRemaining() <= 0;
	}

}
