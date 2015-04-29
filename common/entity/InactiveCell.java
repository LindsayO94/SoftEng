package common.entity;

public class InactiveCell extends Cell {

	public InactiveCell(int column, int row) {
		super(column, row);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type getType() {
		return Cell.Type.INACTIVE_CELL;
	}

	

}
