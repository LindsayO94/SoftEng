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
<<<<<<< HEAD
	
	public boolean toggleActive(){
		System.out.println("Toggling active");
		if (this.active)
			this.active = false;
		else
			this.active = true;
		tile.toggleActive();
		return this.active;
=======

	public Tile getTile() {
		return tile;
	}

	@Override
	public Cell.Type getType() {
		return Cell.Type.TILE_CELL;
>>>>>>> 850fa54edc1e794a25390c60dd58c1ecc72d693a
	}
}
