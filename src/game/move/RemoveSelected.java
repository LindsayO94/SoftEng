package game.move;

import java.util.ArrayList;

import game.entities.Game;
import common.entity.Board;
import common.entity.Cell;
import common.entity.TileCell;

public class RemoveSelected extends gameMove{
	
	Board board;
	ArrayList<Cell> cells = new ArrayList<Cell>();
	
	public RemoveSelected(Board board, ArrayList<Cell> cells){
		this.board = board;
		this.cells = cells;
	}

	
	@Override
	public boolean doMove(Game game) {
		if(valid(game)==true)
		{
			ArrayList<ArrayList<Cell>> temp = board.getCells();
			for (int i = 0; i < temp.size(); i++ )
			{
				for (int j = 0; j < temp.get(i).size(); j++)
				{
					switch (temp.get(i).get(j).getType())
					{
					case TILE_CELL:
						((TileCell) temp.get(i).get(j)).unSelect();
						//((TileCell) temp.get(i).get(j)).setTile(null);
						//board.gravity();
						
					case INACTIVE_CELL:
						break;
					}
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean undo(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid(Game game) {
		// TODO Auto-generated method stub
		return true;
	}
}