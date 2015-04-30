package common.entity;

import java.util.ArrayList;

public abstract class Board {
	ArrayList<ArrayList<Cell>> cells;
	public Level level;
	int score;
	
	public Board(Level level) {
		this.level = level;
		
		this.refresh();
	}
	
	public abstract boolean isWon();
	
	public void refresh() {
		cells = new ArrayList<ArrayList<Cell>>(9);
		for (int i = 0; i < level.startingConfig.length; i++) {
			cells.add(i, new ArrayList<Cell>(9));
			for (int j = 0; j < level.startingConfig[i].length; j++) {
				cells.get(i).add(j, createCell(i, j));
			}
		}
	}
	
	public void refreshCell(Cell c) {
		cells.get(c.getColumn()).set(c.getRow(), createCell(c.getColumn(), c.getRow()));
	}
	
	public Cell createCell(int i, int j) {
		switch (level.startingConfig[i][j]) {
		case TILE_CELL:
			Tile tile = level.getRandomTile();
			return new TileCell(i, j, tile);
			
		case INACTIVE_CELL:
			return new InactiveCell(i, j);
			
		default:
			throw new RuntimeException("Unknown tile type");
		}
	}
	
	private Tile getNext(TileCell focus)
	{
		
		int rf = focus.getRow();
		int cf = focus.getColumn();
		TileCell nextCell = (TileCell)cells.get(rf-1).get(cf);
		Tile nextTile = nextCell.getTile();
		return nextTile;
	}
	
	public void gravity() {
		for (int i=cells.size(); i>0; i--) {
			for (int j=cells.get(i).size(); j>0; j--)
			{
				Cell temp = cells.get(i).get(j);
				switch(temp.getType())
				{
				case TILE_CELL:
					TileCell focus = (TileCell) temp;
					if (focus.getTile() == null)
					{
						Tile tile = getNext(focus);
						for(int k=focus.getRow()-1; k>=0; k--)
						{
							if (tile == null && k ==0)
							{
								Tile tempTile = level.getRandomTile();
								focus.setTile(tempTile);
							}
							if (tile != null)
							{
								focus.setTile(tile);
								break;
							}
							else
							{
								tile = getNext((TileCell)cells.get(k).get(j));
							}
						}
					}
				default:
					break;
					
				}
			}	
		}
			
	}

	public void selectCell(TileCell cell)
	{
		cell.setSelected();
		return;
	}
	
	public ArrayList<ArrayList<Cell>> getCells() {
		return cells;
	}

	public static Board makeBoard(Level level) {
		switch (level.type) {
		case "Puzzle":
			return new PuzzleBoard(level);
			
		default:
			throw new IllegalArgumentException("Unknown board type");
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public int incrementScore(int delta){
		score =+ delta;
		return score;
	}
	
	public Level getLevel(){
		return level;
	}
}
