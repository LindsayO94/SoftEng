package common.entity;



public class BasketCell extends Cell {
	Tile tile;
	
	public BasketCell(int column, int row) {
		super(column, row);
		this.tile = null; 
	}

	public Tile getTile() {
		return tile;
	}

	@Override
	public Cell.Type getType() {
		return Cell.Type.BASKET_CELL;
	}
	
	public boolean filled(){
		//if there is no tile yet put into the basket, its tile will be null
		return (this.tile == null);
	}
}
