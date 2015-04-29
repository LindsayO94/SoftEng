package common.entity;

public class TileCell extends Cell {
	boolean selected;
	boolean marked;
	Tile tile;
	
	public TileCell(int column, int row, Tile tile) {
		super(column, row);
		this.tile = tile;
		this.selected = false;
		this.marked = false;
	}

	public Tile getTile() {
		return tile;
	}

	@Override
	public Cell.Type getType() {
		return Cell.Type.TILE_CELL;
	}

	public boolean isSelected() {
		return selected;
	}

	public boolean isMarked() {
		return marked;
	}
}
