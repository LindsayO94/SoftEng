package common.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LightningBoardTest {
	Level levelWithOnlyTiles;

	@Before
	public void setUp() throws Exception {
		// TODO: Currently levels default to only tiles, but eventually
		// that will be changed
		levelWithOnlyTiles = new Level(23);
	}

	@Test
	public void testSimpleConstructor() {
		LightningBoard b = new LightningBoard(levelWithOnlyTiles);
		
		
		
		// Check that the level reference was set properly
		assertEquals(levelWithOnlyTiles, b.level);
		
		assertFalse(b.isCompleted());
		
		// Check that a level doesn't start out as won
		assertFalse(b.isWon());
		
		// Check a few cells to make sure they were created properly
		Cell cellAt00 = b.cells.get(0).get(0);
		Cell cellAt13 = b.cells.get(1).get(3);
		Cell cellAt87 = b.cells.get(8).get(7);
		
		// Make sure coordinates are right
		assertEquals(0, cellAt00.column);
		assertEquals(0, cellAt00.row);
		assertEquals(1, cellAt13.column);
		assertEquals(3, cellAt13.row);
		assertEquals(8, cellAt87.column);
		assertEquals(7, cellAt87.row);
		
		// Make sure types are right
		assertEquals(Cell.Type.TILE_CELL, cellAt00.getType());
		assertEquals(Cell.Type.TILE_CELL, cellAt13.getType());
		assertEquals(Cell.Type.TILE_CELL, cellAt87.getType());
	}
	
	@Test
	public void testGetters() {
		LightningBoard b = new LightningBoard(levelWithOnlyTiles);
		
		assertEquals(b.cells, b.getCells());
	}

}
