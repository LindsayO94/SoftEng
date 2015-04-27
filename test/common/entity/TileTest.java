package common.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileTest {

	@Test
	public void testSimpleConstructor() {
		Tile t = new Tile(1, 2);
		
		assertEquals(1, t.getValue());
		assertEquals(2, t.getMultiplier());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValueBelowRange() {
		new Tile(0, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValueAboveRange() {
		new Tile(7, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMultiplierBelowRange() {
		new Tile(1, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMultiplierAboveRange() {
		new Tile(1, 4);
	}

}
