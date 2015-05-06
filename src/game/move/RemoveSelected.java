package game.move;

import java.util.ArrayList;

import game.entities.Game;
import common.entity.Board;
import common.entity.Cell;
import common.entity.Tile;
import common.entity.TileCell;

public class RemoveSelected extends gameMove {

	Board board;
	ArrayList<Cell> cells = new ArrayList<Cell>();
	int numCells;
	int multiplier;

	public RemoveSelected(Board board, ArrayList<Cell> cells) {
		this.board = board;
		this.cells = cells;
		numCells = 0;
		multiplier = 1;
	}

	@Override
	public boolean doMove(Game game) {
		if (valid(game)) {
			board.incrementScore(10*numCells*multiplier);
			board.checkStars();
			

			ArrayList<ArrayList<Cell>> temp = board.getCells();
			for (int i = 0; i < temp.size(); i++) {
				for (int j = 0; j < temp.get(i).size(); j++) {
					switch (temp.get(i).get(j).getType()) {
					case TILE_CELL:
						if (((TileCell) temp.get(i).get(j)).isSelected() == true) {
							((TileCell) temp.get(i).get(j)).unSelect();
							if (board.getLevel().getType().equals("Elimination")) {
								((TileCell) temp.get(i).get(j)).setMarked(true);
							}
							((TileCell) temp.get(i).get(j)).setTile(null);
						}
					case INACTIVE_CELL:
					case BASKET_CELL:
						break;
					}
				}
			}
			int moves = board.getMovesRemaining();
			board.setMovesRemaining(moves-1);
			board.gravity(board);
		} else {
			ArrayList<ArrayList<Cell>> temp = board.getCells();
			for (int i = 0; i < temp.size(); i++) {
				for (int j = 0; j < temp.get(i).size(); j++) {
					switch (temp.get(i).get(j).getType()) {
					case TILE_CELL:
						if (((TileCell) temp.get(i).get(j)).isSelected() == true) {
							((TileCell) temp.get(i).get(j)).unSelect();
						}
					case INACTIVE_CELL:
					case BASKET_CELL:
						break;
					}
				}
			}
		}
		
		board.checkWin();
		return true;
	}

	@Override
	public boolean undo(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid(Game game) {
		// TODO Auto-generated method stub
		int count = 0;
		ArrayList<ArrayList<Cell>> temp = board.getCells();
		for (int i = 0; i < temp.size(); i++) {
			for (int j = 0; j < temp.get(i).size(); j++) {
				switch (temp.get(i).get(j).getType()) {
				case TILE_CELL:
					if (((TileCell) temp.get(i).get(j)).isSelected() == true) {
						count += ((TileCell) temp.get(i).get(j)).getTile()
								.getValue();
						numCells++;
						multiplier *=  ((TileCell) temp.get(i).get(j)).getTile().getMultiplier();
					}
				case INACTIVE_CELL:
					break;
				}
			}
		}
		if (count == 6) {
			return true;
		} else {
			return false;
		}
	}

//	private Tile getNextTile(TileCell cell) {
//		int cf = cell.getColumn();
//		int rf = cell.getRow();
//		TileCell nextCell = (TileCell) board.getCells().get(rf - 1).get(cf);
//		Tile nextTile = nextCell.getTile();
//		return nextTile;
//	}
}