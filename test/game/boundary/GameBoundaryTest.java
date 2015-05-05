package game.boundary;

import static org.junit.Assert.*;

import java.util.ArrayList;

import game.entities.Game;

import org.junit.Test;

import common.LevelSaver;
import common.entity.Board;
import common.entity.Level;
import common.entity.PuzzleBoard;

public class GameBoundaryTest {

	@Test
	public void testPlayGamePanel(){
		ArrayList<Level> levels = new ArrayList<Level>();
		levels.add(new Level("Puzzle", 0));
		Game game = new Game(levels);
		GameFrame gf = new GameFrame(game);
		gf.setBoard(Board.makeBoard( new Level("Puzzle", 0) ));
		PlayGamePanel view = gf.playGame;
		assertTrue(view.board != null);
	}
}
