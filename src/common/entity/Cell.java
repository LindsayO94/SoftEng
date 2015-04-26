package common.entity;

public abstract class Cell {
	int column;
	int row;
	
	public Cell(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	/**
	 * Returns true if this cell neighbors the given cell (no diagonals),
	 * false otherwise.
	 * 
	 * @param other The other cell to compare this to
	 * @return Whether the cells are neighbors
	 */
	public boolean isNeighborCell(Cell other) {
		return this.getColumn() == other.getColumn() || this.getRow() == other.getRow();
	}
}
