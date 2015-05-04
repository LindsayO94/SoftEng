package common.entity;

import java.util.ArrayList;

public abstract class Board {
	ArrayList<ArrayList<Cell>> cells;
	public Level level;

	int movesRemaining;
	int score;
	int timeLeft;

	int swapsRemaining;
	int removesRemaining;
	int shufflesRemaining;

	public Board(Level level) {
		this.level = level;

		this.swapsRemaining = level.numSwap;
		this.removesRemaining = level.numRemove;
		this.shufflesRemaining = level.numShuffle;

		this.movesRemaining = level.maxMoves;
		this.timeLeft = level.maxTime;

		this.refresh();
	}

	public abstract boolean isWon();

	public void refresh() {

		cells = new ArrayList<ArrayList<Cell>>(9);
		for (int i = 0; i < level.startingConfig.length; i++) {
			cells.add(i, new ArrayList<Cell>(9));
			for (int j = 0; j < level.startingConfig[i].length; j++) {
				try {
					cells.get(i).add(j, createCell(i, j));
				} catch (IllegalArgumentException e) {
					throw e;
				}
			}
		}

		// Place sixes properly in Release
		if (level.type.equals("Release")) {
			for (int row = cells.size() - 1; row >= 0; row--) {
				ArrayList<Cell> cellsAllowedToHaveSixes = new ArrayList<Cell>();
				int totalSixesNeeded = 0;
				int currentSixesNeeded = 0;
				boolean bufferNeeded = false;
				boolean isAboveBasket = false;
				for (int col = cells.size() - 1; col >= 0; col--) {
					Cell cell = cells.get(col).get(row);
					if (cell.getType() == Cell.Type.BASKET_CELL) {
						currentSixesNeeded += 1;
						totalSixesNeeded += 1;
						bufferNeeded = true;
						isAboveBasket = true;
					} else if (cell.getType() == Cell.Type.TILE_CELL) {
						if (bufferNeeded) {
							bufferNeeded = false;
						} else if (isAboveBasket && currentSixesNeeded > 0) {
							// This six is accounted for
							currentSixesNeeded -= 1;
							cellsAllowedToHaveSixes.add(cell);
						} else if (isAboveBasket) {
							cellsAllowedToHaveSixes.add(cell);
						}
					}
				}

				if (currentSixesNeeded > 0) {
					throw new IllegalStateException(
							"This column needs more sixes than it has room for");
				}

				for (int x = 0; x < totalSixesNeeded; x++) {
					int i = level.getRandomInt(cellsAllowedToHaveSixes.size());
					Cell cellToMake6 = cellsAllowedToHaveSixes.remove(i);
					Tile tile = new Tile(6, level.getRandomMultiplier());
					TileCell newCell = new TileCell(cellToMake6.getColumn(),
							cellToMake6.getRow(), tile);

					cells.get(newCell.getColumn()).set(newCell.getRow(),
							newCell);
				}
			}
		}
	}

	public void refreshCell(Cell c) {
		cells.get(c.getColumn()).set(c.getRow(),
				createCell(c.getColumn(), c.getRow()));
	}

	public Cell createCell(int i, int j) {
		switch (level.startingConfig[i][j]) {
		case TILE_CELL:
			Tile tile;
			try {
				tile = level.getRandomTile();
			} catch (IllegalArgumentException e) {
				throw e;
			}
			return new TileCell(i, j, tile);

		case INACTIVE_CELL:
			return new InactiveCell(i, j);

		case BASKET_CELL:
			return new BasketCell(i, j);

		default:
			throw new RuntimeException("Unknown tile type");
		}
	}

	private Tile getNext(Cell focus) {
		int rf = focus.getRow();
		int cf = focus.getColumn();
		if (cf == 0) {
			return level.getRandomTile();
		} else {
			Cell nextCell = cells.get(cf - 1).get(rf);
			if (nextCell.getType() != Cell.Type.TILE_CELL || ((TileCell) nextCell).getTile() == null) {
				return getNext(nextCell);
			} else {
				Tile nextTile = ((TileCell) nextCell).getTile();
				((TileCell) nextCell).setTile(null);
				return nextTile;
			}
		}
	}

	public void gravity(Board board) {
		cells = board.getCells();
		for (int row = cells.size() - 1; row >= 0; row--) {
			for (int col = cells.get(row).size() - 1; col >= 0; col--) {
				Cell currentCell = cells.get(col).get(row);
				switch (currentCell.getType()) {
				case TILE_CELL:
					TileCell focus = (TileCell) currentCell;
					if (focus.getTile() == null) {
						Tile tile = getNext(focus);
						focus.setTile(tile);
					}
				default:
					break;

				}
			}
		}

	}

	public void selectCell(TileCell cell) {
		cell.setSelected();
		return;
	}

	public ArrayList<ArrayList<Cell>> getCells() {
		return cells;
	}

	public static Board makeBoard(Level level) {
		if (level.type.equals("Puzzle")) {
			return new PuzzleBoard(level);
		} else if (level.type.equals("Lightning")) {
			return new LightningBoard(level);
		} else if (level.type.equals("Elimination")) {
			return new EliminationBoard(level);
		} else if (level.type.equals("Release")) {
			return new ReleaseBoard(level);
		} else {
			throw new IllegalArgumentException("Unknown board type");
		}
		/*
		 * switch (level.type) { case "Puzzle": return new PuzzleBoard(level);
		 * 
		 * default: throw new IllegalArgumentException("Unknown board type"); }
		 */
	}

	// Score
	public int getScore() {
		return score;
	}

	public int incrementScore(int delta) {
		score = +delta;
		return score;
	}

	public Level getLevel() {
		return level;
	}

	// Time
	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	// Regular Moves Remaining
	public int getMovesRemaining() {
		return movesRemaining;
	}

	public void setMovesRemaining(int movesRemaining) {
		this.movesRemaining = movesRemaining;
	}

	// Special Moves Remaining
	public int getSwapsRemaining() {
		return swapsRemaining;
	}

	public void setSwapsRemaining(int swapsRemaining) {
		this.swapsRemaining = swapsRemaining;
	}

	public int getRemovesRemaining() {
		return removesRemaining;
	}

	public void setRemovesRemaining(int removesRemaining) {
		this.removesRemaining = removesRemaining;
	}

	public int getShufflesRemaining() {
		return shufflesRemaining;
	}

	public void setShufflesRemaining(int shufflesRemaining) {
		this.shufflesRemaining = shufflesRemaining;
	}

}
