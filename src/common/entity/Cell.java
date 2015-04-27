package common.entity;

import common.entity.Level.CellType;

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
	
	public abstract String getCellType();

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

	public static Cell newCellOfType(CellType cellType) {
		// TODO Auto-generated method stub
		return null;
	}
}
