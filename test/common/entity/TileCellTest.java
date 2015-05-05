package common.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileCellTest {

	@Test
	public void testSimpleConstructor() {
		Tile t = new Tile(6, 3);
		TileCell cell = new TileCell(1, 2, t);
		
		assertEquals(1, cell.getColumn());
		assertEquals(2, cell.getRow());
		assertEquals(t, cell.getTile());
		assertEquals(Cell.Type.TILE_CELL, cell.getType());	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testColumnBelowBound() {
		new TileCell(-1, 1, new Tile(1, 1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testColumnAboveBound() {
		new TileCell(10, 1, new Tile(1, 1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRowBelowBound() {
		new TileCell(1, -1, new Tile(1, 1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRowAboveBound() {
		new TileCell(1, 10, new Tile(1, 1));
	}
	
	@Test
	public void testNeighbors() {
		Tile t = new Tile(1,1);
		
		TileCell center = new TileCell(3, 3, t);
		TileCell above = new TileCell(3, 2, t);
		TileCell below = new TileCell(3, 4, t);
		TileCell right = new TileCell(2, 3, t);
		TileCell left  = new TileCell(4, 3, t);
		TileCell diagonal = new TileCell(4, 4, t);
		TileCell farAway = new TileCell(0, 0, t);
		
		// A cell is not its own neighbor
		assertFalse(center.isNeighborCell(center));
		
		// Test the actual neighbors
		assertTrue(center.isNeighborCell(above));
		assertTrue(center.isNeighborCell(below));
		assertTrue(center.isNeighborCell(right));
		assertTrue(center.isNeighborCell(left));
		
		// Test things that shouldn't be neighbors
		assertFalse(center.isNeighborCell(diagonal));
		assertFalse(center.isNeighborCell(farAway));
		
		

	}

}
