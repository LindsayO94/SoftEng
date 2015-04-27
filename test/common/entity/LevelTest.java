package common.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LevelTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSimpleConstructor() {
		Level l = new Level(5);
		
		// Make sure rand was set
		assertNotNull(l.rand);
		
		// Default level type is puzzle
		assertEquals("Puzzle", l.type);
		
		// Default to not won
		assertFalse(l.isWon);
		
		// Default to high score of 0
		assertEquals(0, l.highScore);
		
		// Test that the sum of the frequencies isn't 0
		int total = 0;
		for (int freq : l.frequency) total += freq;
		assertTrue(total > 0);
		
		// Test that the sum of the multiplier frequencies isn't 0
		total = 0;
		for (int freq : l.multiplierFrequency) total += freq;
		assertTrue(total > 0);
	}
	
	@Test
	public void testPuzzleConstructor() {
		Level l = new Level("Puzzle", 5);
		
		// Make sure rand was set
		assertNotNull(l.rand);
		
		// Check type is puzzle
		assertEquals("Puzzle", l.type);
		
		// Default to not won
		assertFalse(l.isWon);
		
		// Check high score
		assertEquals(0, l.highScore);
		
		// Test that the sum of the frequencies isn't 0
		int total = 0;
		for (int freq : l.frequency) total += freq;
		assertTrue(total > 0);
		
		// Test that the sum of the multiplier frequencies isn't 0
		total = 0;
		for (int freq : l.multiplierFrequency) total += freq;
		assertTrue(total > 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidLevelType() {
		new Level("Nestor", 5);
	}
	
	@Test
	public void testHighScore() {
		Level l = new Level(5);
		
		l.setHighScore(10234);
		assertEquals(10234, l.getHighScore());
	}
	
	@Test
	public void testGetWeightedRandomIndex() {
		Level l = new Level(0);
		int[] testArr = { 1, 4, 5, 3, 2 };
		
		assertEquals(0, l.getWeightedRandomIndex(testArr));
		assertEquals(4, l.getWeightedRandomIndex(testArr));
		assertEquals(1, l.getWeightedRandomIndex(testArr));
		assertEquals(1, l.getWeightedRandomIndex(testArr));
		assertEquals(2, l.getWeightedRandomIndex(testArr));
		assertEquals(2, l.getWeightedRandomIndex(testArr));
	}
	
	@Test
	public void testGetWeightedRandomIndexLimitedReturn() {
		Level l = new Level(0);
		int[] testArr = { 0, 0, 0, 1, 0 };
		
		// Check that the function "always" returns 3
		for (int i = 0; i < 25; i++) {
			assertEquals(3, l.getWeightedRandomIndex(testArr));
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetWeightedRandomIndexEmptyArray() {
		Level l = new Level(0);
		int[] testArr = {};
		l.getWeightedRandomIndex(testArr);
	}
	
	@Test
	public void testGetRandomTile() {
		Level l = new Level(0);
		
		Tile t = l.getRandomTile();
		assertTrue(t.getValue() > 0);
		assertTrue(t.getValue() <= 6);
		assertTrue(t.getMultiplier() > 0);
		assertTrue(t.getMultiplier() <= 3);
	}

}
