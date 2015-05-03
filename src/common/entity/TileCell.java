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
	
	public void setTile(Tile nTile){
		this.tile = nTile;
	}
	
	public void setSelected()
	{
		this.selected = true;
	}
	
	public void unSelect()
	{
		this.selected = false;
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

	public void setMarked(boolean b) {
		this.marked = b;
	}

	public void setSelected(boolean b) {
		this.selected = b;
	}
}
