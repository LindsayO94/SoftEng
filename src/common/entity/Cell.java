package common.entity;

public abstract class Cell {
<<<<<<< HEAD
	int column;
	int row;
	Boolean active;
	
	public Cell(int column, int row, Boolean active) {
=======
	public static enum Type {
		TILE_CELL
	}
	
	final int column;
	final int row;
	
	public Cell(int column, int row) {
		if (column < 0 || column >= 9 || row < 0 || row >= 9) {
			throw new IllegalArgumentException("Illegal row or column passed to cell constructor");
		}
		
>>>>>>> 850fa54edc1e794a25390c60dd58c1ecc72d693a
		this.column = column;
		this.row = row;
		this.active = active;
	}
	
	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	public abstract Type getType();

	/**
	 * Returns true if this cell neighbors the given cell (no diagonals),
	 * false otherwise.
	 * 
	 * @param other The other cell to compare this to
	 * @return Whether the cells are neighbors
	 */
	public boolean isNeighborCell(Cell other) {
		// This is an xor so that a cell can't be its own neighbor
		return this.getColumn() == other.getColumn() ^ this.getRow() == other.getRow();
	}
	
	public boolean toggleActive(){
		if (this.active)
			this.active = false;
		else
			this.active = true;
		return this.active;
	}
}
