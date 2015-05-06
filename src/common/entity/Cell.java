package common.entity;

public abstract class Cell {
	public static enum Type {
		TILE_CELL, INACTIVE_CELL, BASKET_CELL
	}

	final int column;
	final int row;

	public Cell(int column, int row) {
		if (column < 0 || column >= 9 || row < 0 || row >= 9) {
			throw new IllegalArgumentException(
					"Illegal row or column passed to cell constructor");
		}

		this.column = column;
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	public abstract Type getType()
	;

	/**
	 * Returns true if this cell neighbors the given cell (no diagonals), false
	 * otherwise.
	 * 
	 * @param other
	 *            The other cell to compare this to
	 * @return Whether the cells are neighbors
	 */
	public boolean isNeighborCell(Cell other) {
		// This is an xor so that a cell can't be its own neighbor
		// TODO $$$$$$$$$ isn't this just checking to see if they are in the
		// same row or column, not that they are within one cell of one another?
		// -Arty
		return this.getColumn() == other.getColumn()
				^ this.getRow() == other.getRow();
	}

	public boolean hasSelectedNeighbor(Board board) {
		int col = this.getColumn();
		int row = this.getRow();
		
		if (row == 0 && col == 0) {
			Cell top = board.getCells().get(col).get(row + 1);
			Cell right = board.getCells().get(col + 1).get(row);

			switch (top.getType()) {
			case TILE_CELL:
				if (((TileCell) top).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			switch (right.getType()) {
			case TILE_CELL:
				if (((TileCell) right).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			return false;
		}

		if (row == 0 && col == 8) {
			Cell left = board.getCells().get(col - 1).get(row);
			Cell top = board.getCells().get(col).get(row + 1);

			switch (top.getType()) {
			case TILE_CELL:
				if (((TileCell) top).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			switch (left.getType()) {
			case TILE_CELL:
				if (((TileCell) left).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			return false;
		}

		if (row == 8 && col == 0) {
			Cell bot = board.getCells().get(col).get(row - 1);
			Cell right = board.getCells().get(col + 1).get(row);

			switch (bot.getType()) {
			case TILE_CELL:
				if (((TileCell) bot).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (right.getType()) {
			case TILE_CELL:
				if (((TileCell) right).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			return false;
		}

		if (row == 8 && col == 8) {
			Cell bot = board.getCells().get(col).get(row - 1);
			Cell left = board.getCells().get(col - 1).get(row);

			switch (bot.getType()) {
			case TILE_CELL:
				if (((TileCell) bot).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (left.getType()) {
			case TILE_CELL:
				if (((TileCell) left).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			return false;
		}


		if (col == 0) {
			Cell top = board.getCells().get(col).get(row + 1);
			Cell bot = board.getCells().get(col).get(row - 1);
			Cell right = board.getCells().get(col + 1).get(row);

			switch (top.getType()) {
			case TILE_CELL:
				if (((TileCell) top).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (bot.getType()) {
			case TILE_CELL:
				if (((TileCell) bot).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (right.getType()) {
			case TILE_CELL:
				if (((TileCell) right).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			return false;

		}

		if (row == 0) {
			Cell top = board.getCells().get(col).get(row + 1);
			Cell left = board.getCells().get(col - 1).get(row);
			Cell right = board.getCells().get(col + 1).get(row);

			switch (top.getType()) {
			case TILE_CELL:
				if (((TileCell) top).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (left.getType()) {
			case TILE_CELL:
				if (((TileCell) left).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (right.getType()) {
			case TILE_CELL:
				if (((TileCell) right).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			return false;
		}

		if (col == 8) {
			Cell top = board.getCells().get(col).get(row + 1);
			Cell bot = board.getCells().get(col).get(row - 1);
			Cell left = board.getCells().get(col - 1).get(row);

			switch (top.getType()) {
			case TILE_CELL:
				if (((TileCell) top).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (bot.getType()) {
			case TILE_CELL:
				if (((TileCell) bot).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (left.getType()) {
			case TILE_CELL:
				if (((TileCell) left).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			return false;
		}

		if (row == 8) {
			Cell bot = board.getCells().get(col).get(row - 1);
			Cell left = board.getCells().get(col - 1).get(row);
			Cell right = board.getCells().get(col + 1).get(row);

			switch (bot.getType()) {
			case TILE_CELL:
				if (((TileCell) bot).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (left.getType()) {
			case TILE_CELL:
				if (((TileCell) left).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (right.getType()) {
			case TILE_CELL:
				if (((TileCell) right).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			return false;
		}

		if (col != 0 && row != 0) {
			Cell bot = board.getCells().get(col).get(row - 1);
			Cell left = board.getCells().get(col - 1).get(row);
			Cell top = board.getCells().get(col).get(row + 1);
			Cell right = board.getCells().get(col + 1).get(row);

			switch (bot.getType()) {
			case TILE_CELL:
				if (((TileCell) bot).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}

			switch (left.getType()) {
			case TILE_CELL:
				if (((TileCell) left).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			switch (top.getType()) {
			case TILE_CELL:
				if (((TileCell) top).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			switch (right.getType()) {
			case TILE_CELL:
				if (((TileCell) right).isSelected() == true) {
					return true;
				}
			case INACTIVE_CELL:
				break;
			}
			return false;
		}
		return false;
	}
}
