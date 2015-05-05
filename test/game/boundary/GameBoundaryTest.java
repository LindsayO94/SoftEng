package game.boundary;

import static org.junit.Assert.*;

import java.util.ArrayList;

import game.entities.Game;

import org.junit.Test;

import common.entity.Board;
import common.entity.Level;
import common.entity.PuzzleBoard;

public class GameBoundaryTest {

	@Test
	public void testPlayGamePanel(){
		ArrayList<Level> levels = new ArrayList<Level>();
		levels.add(new Level("Puzzle", 0));
		Game game = new Game(levels);
		PlayGamePanel view = new PlayGamePanel(game);
		Board board = new PuzzleBoard(levels.get(0));
		view.board = board;
		view.refresh();
		assertTrue(view.board != null);
	}
}
