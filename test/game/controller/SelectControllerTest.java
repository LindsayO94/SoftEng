package game.controller;

import static org.junit.Assert.*;
import game.boundary.GameFrame;
import game.entities.Game;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;

import org.junit.Test;

import common.LevelSaver;
import common.TestLevels;
import common.TestUtil;
import common.entity.Board;
import common.entity.Cell;
import common.entity.Level;
import common.entity.Cell.Type;
import common.entity.TileCell;

public class SelectControllerTest {

	@Test
	public void test() throws AWTException {
		ArrayList<Level> levels = new ArrayList<Level>();
		levels.add(LevelSaver.levelFromJsonString(TestLevels.puzzleNoInactive, 0));
		Game game = new Game(levels);
		GameFrame gf = new GameFrame(game);
		gf.setBoard(Board.makeBoard( levels.get(0) ));
		
		gf.setVisible(true);
				
		Robot r = new Robot();
		r.setAutoDelay(200);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		r.mouseMove(100, 300);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		r.mouseMove(80, 140);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		r.setAutoDelay(200);
		r.mouseMove(400, 250);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseMove(470, 250);
		
		// Check number of selected cells
		int ctr = 0;
		for (ArrayList<Cell> r1 : gf.getPlayView().getBoard().getCells()) {
			for (Cell c : r1) {
				if (c.getType() == Type.TILE_CELL && ((TileCell)c).isSelected()) {
					ctr ++; 
				}
			}
		}
		
		assertEquals(1, ctr);

		r.mouseRelease(InputEvent.BUTTON1_MASK);
		
		// Check number of selected cells
		ctr = 0;
		for (ArrayList<Cell> r1 : gf.getPlayView().getBoard().getCells()) {
			for (Cell c : r1) {
				if (c.getType() == Type.TILE_CELL && ((TileCell)c).isSelected()) {
					ctr ++; 
				}
			}
		}
		
		assertEquals(0, ctr);
	}

}
