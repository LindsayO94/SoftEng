package common.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



/**
 * @author August Beers, Lindsay O'Donnell
 */

public class BoardTest {

	@Test
	public void testMakePuzzleBoard() {
		Level l = new Level("Puzzle", 13);
		Board b = Board.makeBoard(l);
		
		assertTrue(b instanceof PuzzleBoard);
		assertEquals(l, b.level);
	}
	
	@Test
	public void testMakeLightningBoard() {
		Level l = new Level("Lightning", 13);
		Board b = Board.makeBoard(l);
		
		assertTrue(b instanceof LightningBoard);
		assertEquals(l, b.level);
	}
	
	@Test
	public void testMakeEliminationBoard() {
		Level l = new Level("Elimination", 13);
		Board b = Board.makeBoard(l);
		
		assertTrue(b instanceof EliminationBoard);
		assertEquals(l, b.level);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMakeBoardUnknownType() {
		Level l = new Level("EagleWing", 13);
		Board.makeBoard(l);
	}
	
	@Test
	public void testBoardFunctions(){
		Level l = new Level("Puzzle", 13);
		Board b = Board.makeBoard(l);
		
		Cell c = b.cells.get(0).get(0);
		
		boolean neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
		
		c = b.cells.get(0).get(8);
		neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
		
		c = b.cells.get(8).get(0);
		neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
		
		c = b.cells.get(8).get(8);
		neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
		
		c = b.cells.get(2).get(8);
		neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
		
		c = b.cells.get(8).get(5);
		neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
		
		c = b.cells.get(0).get(5);
		neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
		
		c = b.cells.get(3).get(0);
		neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
		
		c = b.cells.get(4).get(7);
		neighbor = c.hasSelectedNeighbor(b);
		assertFalse(neighbor);
	}
	
	@Test
	public void testMakeReleaseBoard() {
		Level l = new Level("Release", 13);
		l.toggleCell(new InactiveCell(8, 8));
		l.toggleCell(new InactiveCell(8, 8));
		Board b = Board.makeBoard(l);
		
		assertTrue(b instanceof ReleaseBoard);
		assertEquals(l, b.level);
		
		b.gravity(b);
		
		
		b.incrementScore(100);
		b.incrementScore(1000);
		assertEquals(b.score, 1100);
		
		b.setMovesRemaining(4);
		assertEquals(b.movesRemaining, 4);
		
		int moves = b.getMovesRemaining();
		assertEquals(moves, 4);
		
		b.setSwapsRemaining(4);
		assertEquals(b.swapsRemaining, 4);
		
		int swaps = b.getSwapsRemaining();
		assertEquals(swaps, 4);
		
		b.setRemovesRemaining(4);
		assertEquals(b.removesRemaining, 4);
		
		int removes = b.getRemovesRemaining();
		assertEquals(removes, 4);
		
		b.setShufflesRemaining(4);
		assertEquals(b.shufflesRemaining, 4);
		
		int shuffles = b.getShufflesRemaining();
		assertEquals(shuffles, 4);
		
		b.checkStars();
		
		assertTrue(b.star3Active);
		
		
	}

}
