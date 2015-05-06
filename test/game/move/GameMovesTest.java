package game.move;

import static org.junit.Assert.*;
import game.boundary.GameFrame;
import game.boundary.PlayGamePanel;
import game.entities.Game;

import java.util.ArrayList;

import org.junit.Test;

import common.TestUtil;
import common.boundary.CellPanel;
import common.entity.BasketCell;
import common.entity.Board;
import common.entity.Cell;
import common.entity.InactiveCell;
import common.entity.Level;
import common.entity.Tile;
import common.entity.TileCell;

/**
 * 
 * @author Lindsay
 *
 */

public class GameMovesTest {
	
	@Test
	public void testRemoveSelected(){
		ArrayList<Level> levels = new ArrayList<Level>(); 
		levels.add(new Level("Puzzle", 0));
		Game game = new Game(levels);
		GameFrame gf = new GameFrame(game);
		
		
		gf.setBoard(Board.makeBoard( new Level("Puzzle", 0) ));
		
		TestUtil.displayView(gf.getPlayView(), 600,800);
		ArrayList<TileCell> cells = new ArrayList<TileCell>();
		Cell oldCell = gf.getPlayView().getBoard().getCells().get(3).get(3);
		cells.add((TileCell)gf.getPlayView().getBoard().getCells().get(1).get(2));
		cells.add((TileCell)gf.getPlayView().getBoard().getCells().get(1).get(3));
		
		((TileCell)gf.getPlayView().getBoard().getCells().get(1).get(2)).setSelected();
		((TileCell)gf.getPlayView().getBoard().getCells().get(1).get(2)).setSelected();
		RemoveSelected rm = new RemoveSelected(gf.getPlayView().getBoard(), cells, gf.getPlayView());
		rm.doMove(game);
		assertTrue(oldCell != gf.getPlayView().getBoard().getCells().get(2).get(1));
	}
	
	@Test
	public void testSelectMove(){
		ArrayList<Level> levels = new ArrayList<Level>();
		levels.add(new Level("Puzzle", 0));
		Game game = new Game(levels);
		GameFrame gf = new GameFrame(game); 
		
		
		gf.setBoard(Board.makeBoard( new Level("Puzzle", 0) ));
		
		TestUtil.displayView(gf.getPlayView(), 600,800);
		ArrayList<CellPanel> cells = new ArrayList<CellPanel>();
		Tile tile = new Tile(6, 1);
		Cell oldCell = gf.getPlayView().getBoard().getCells().get(1).get(3);
		Cell nextCell = gf.getPlayView().getBoard().getCells().get(2).get(3);
		Cell someCell = gf.getPlayView().getBoard().getCells().get(8).get(8);
		TileCell sixCell = (TileCell) gf.getPlayView().getBoard().getCells().get(4).get(4);
		InactiveCell iCell = new InactiveCell(6, 6);
		BasketCell bCell = new BasketCell(5, 5);
		sixCell.setTile(tile);
		CellPanel[] cellpanels = gf.getPlayView().getBoardPanel().getCellPanel();
		
		cells.add(cellpanels[40]);
		cells.add(cellpanels[41]);
		((TileCell)gf.getPlayView().getBoard().getCells().get(1).get(3)).setSelected();
		SelectMove sm = new SelectMove(oldCell, gf.getPlayView().getBoard(), cells);
		SelectMove sm2 = new SelectMove(nextCell, gf.getPlayView().getBoard(), cells);
		SelectMove sm3 = new SelectMove(someCell, gf.getPlayView().getBoard(), cells);
		SelectMove sm4 = new SelectMove(sixCell, gf.getPlayView().getBoard(), cells);
		SelectMove sm5 = new SelectMove(iCell, gf.getPlayView().getBoard(), cells);
		SelectMove sm6 = new SelectMove(bCell, gf.getPlayView().getBoard(), cells);
		
		
		sm.doMove(game);
		sm2.doMove(game);
		sm3.doMove(game);
		assertFalse(sm4.doMove(game));
		assertFalse(sm5.doMove(game));
		assertFalse(sm6.doMove(game));
		assertTrue(((TileCell)oldCell).isSelected());
		assertTrue(((TileCell) nextCell).isSelected());
		assertFalse(((TileCell) someCell).isSelected());
	}

}
