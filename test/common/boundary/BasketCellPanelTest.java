package common.boundary;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.border.LineBorder;

import org.junit.Test;

import common.entity.BasketCell;
import common.entity.Tile;


public class BasketCellPanelTest {

	@Test
	public void test() {
		BasketCell cell = new BasketCell(0, 0);
		BasketCellPanel cp = new BasketCellPanel(cell);
		
		// Black border
		assertEquals(new Color(0,0,0), ((LineBorder) cp.getBorder()).getLineColor());
		
		// Test abstract methods
		CellPanel absCp = cp; 
		
		assertEquals(cell, absCp.getCellModel());
		assertEquals(null, absCp.getTileView()); 
		
		Tile tile = new Tile(1, 1);
		cell.setTile(tile);
		
		assertTrue(cell.getTile() != null);
		assertTrue(cell.getTile().getValue() != 6);
	}

}