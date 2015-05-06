package game.move;

import static org.junit.Assert.assertTrue;
import game.boundary.GameFrame;
import game.boundary.PlayGamePanel;
import game.entities.Game;

import java.util.ArrayList;

import org.junit.Test;

import common.TestUtil;
import common.boundary.CellPanel;
import common.entity.Board;
import common.entity.Cell;
import common.entity.Level;
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
		Cell oldCell = gf.getPlayView().getBoard().getCells().get(1).get(3);
		CellPanel[] cellpanels = gf.getPlayView().getBoardPanel().getCellPanel();
		
		cells.add(cellpanels[40]);
		cells.add(cellpanels[41]);
		((TileCell)gf.getPlayView().getBoard().getCells().get(1).get(3)).setSelected();
		SelectMove sm = new SelectMove(oldCell, gf.getPlayView().getBoard(), cells);
		sm.doMove(game);
		assertTrue(((TileCell)oldCell).isSelected());
	}

}
