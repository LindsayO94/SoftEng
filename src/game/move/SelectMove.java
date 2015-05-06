package game.move;

import java.util.ArrayList;
//import java.util.List;

import common.boundary.CellPanel;
//import common.boundary.TileCellPanel;
import common.entity.Board;
import common.entity.Cell;
import common.entity.TileCell;
import game.entities.Game;
import game.move.gameMove;

public class SelectMove extends gameMove {

	Cell cell;
	Board board;

	ArrayList<CellPanel> cells = new ArrayList<CellPanel>();

	public SelectMove(Cell cell, Board board, ArrayList<CellPanel> cells) {
		this.cell = cell;
		this.board = board;
		this.cells = cells;

	}

	@Override
	public boolean doMove(Game game) {
		if (valid(game) == true) { 
			if (hasSelected(board) == false) {

				switch (cell.getType()) {
				case TILE_CELL:
					((TileCell) cell).setSelected();
					return true;
				case INACTIVE_CELL:
					throw new IllegalArgumentException(
							"You may not select an inactive cell");
				case BASKET_CELL:
					throw new IllegalArgumentException(
							"You may not select a basket cell");
				}

			} else {
				switch (cell.getType()) {
				case TILE_CELL:
					if (cell.hasSelectedNeighbor(board) == true) {
						((TileCell) cell).setSelected();
						return true;
					} else {
						throw new IllegalArgumentException("Invalid Selection");
					}
				case INACTIVE_CELL:
					throw new IllegalArgumentException(
							"You may not select an inactive cell");
				case BASKET_CELL:
					throw new IllegalArgumentException(
							"You may not select a basket cell");

				}
			}
			// board.refreshCell(cell);

			return false;
		}
		return false;

	}

	@Override
	public boolean undo(Game game) {
		return false;
	}

	@Override
	public boolean valid(Game game) {
		if (hasSelected(board) == false) {
			switch (cell.getType()) {
			case TILE_CELL:
				return ((TileCell) cell).getTile().getValue() != 6;
			case INACTIVE_CELL:
			case BASKET_CELL:
				return false;
			}
		} else {
			switch (cell.getType()) {
			case TILE_CELL:
				return ((TileCell) cell).getTile().getValue() != 6 && cell.hasSelectedNeighbor(board);
			case INACTIVE_CELL:
			case BASKET_CELL:
				return false;

			}
		}
		
		return false;
	}

	public boolean hasSelected(Board board) {
		ArrayList<ArrayList<Cell>> temp = board.getCells();

		for (int i = 0; i < temp.size(); i++) {
			for (int j = 0; j < temp.get(i).size(); j++) {
				switch (temp.get(i).get(j).getType()) {
				case TILE_CELL:
					if (((TileCell) temp.get(i).get(j)).isSelected() == true) {
						return true;
					}
				case INACTIVE_CELL:
					break;
				case BASKET_CELL:
					break;

				}
			}
		}
		return false;
	}

}
