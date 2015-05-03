package game.move;


import java.util.ArrayList;
import java.util.List;

import common.boundary.TileCellPanel;
import common.entity.Board;
import common.entity.Cell;
import common.entity.TileCell;
import game.entities.Game;
import game.move.gameMove;

public class SelectMove extends gameMove{
	
	Cell cell;
	Board board;
	
	ArrayList<Cell> selectedCells = new ArrayList<Cell>();
	
	public SelectMove(Cell cell, Board board){
		this.cell = cell;
		this.board = board;
		
	}

	
	@Override
	public boolean doMove(Game game) {
		if(valid(game)==true)
		{
		
			if(selectedCells.isEmpty() == true)
			{
			((TileCell) cell).setSelected();
			selectedCells.add(cell);
			return true;
			}
			
			else
			{
				if (cell.hasSelectedNeighbor(board) == true)
				{
					((TileCell) cell).setSelected();
					selectedCells.add(cell);
					return true;
				}
			}
			//board.refreshCell(cell);
			
			return false;
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

