package common.entity;

import common.boundary.TilePanel;

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
}
