package common.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	@Test
	public void testMakePuzzleBoard() {
		Level l = new Level("Puzzle", 13);
		Board b = Board.makeBoard(l);
		
		assertTrue(b instanceof PuzzleBoard);
		assertEquals(l, b.level);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMakeBoardUnknownType() {
		Level l = new Level("EagleWing", 13);
		Board.makeBoard(l);
	}

}
