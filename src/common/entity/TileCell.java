package common.entity;

import common.boundary.TilePanel;

public class TileCell extends Cell {
	boolean selected;
	boolean marked;
	Tile tile;
	
	public TileCell(int column, int row, Tile tile, Boolean active) {
		super(column, row, active);
		this.tile = tile;
		this.selected = false;
		this.marked = false;
	}
	
	public boolean toggleActive(){
		System.out.println("Toggling active");
		if (this.active)
			this.active = false;
		else
			this.active = true;
		return this.active;
	}

	public Tile getTile() {
		return tile;
	}

	@Override
	public Cell.Type getType() {
		return Cell.Type.TILE_CELL;
	}
}
