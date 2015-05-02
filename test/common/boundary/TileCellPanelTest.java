package common.boundary;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.border.LineBorder;

import org.junit.Test;

import common.entity.Tile;
import common.entity.TileCell;

public class TileCellPanelTest {

	@Test
	public void test() {
		Tile tile = new Tile(1, 1);
		TileCell cell = new TileCell(0, 0, tile );
		TilePanel tileView = new TilePanel(tile);
		TileCellPanel cp = new TileCellPanel(cell, tileView);
		
		assertEquals(cell, cp.cell);
		
		// Test default is black
		assertFalse(cell.isSelected());
		assertFalse(cell.isMarked());
		assertEquals(new Color(0,0,0), ((LineBorder) cp.getBorder()).getLineColor());
		
		cell.setSelected();
		cp.refresh();
		
		// Test selected is teal
		assertTrue(cell.isSelected());
		assertFalse(cell.isMarked());
		assertEquals(new Color(0,255,255), ((LineBorder) cp.getBorder()).getLineColor());
		
		cell.setMarked(true);
		cp.refresh();
		
		// Test marked+selected is teal
		assertTrue(cell.isSelected());
		assertTrue(cell.isMarked());
		assertEquals(new Color(0,255,255), ((LineBorder) cp.getBorder()).getLineColor());
		
		cell.setSelected(false);
		cp.refresh();
		
		// Test marked is white
		assertFalse(cell.isSelected());
		assertTrue(cell.isMarked());
		assertEquals(new Color(255,255,255), ((LineBorder) cp.getBorder()).getLineColor());
		
		cell.setMarked(false);
		cp.refresh();
		
		// Test going back to black
		assertFalse(cell.isSelected());
		assertFalse(cell.isMarked());
		assertEquals(new Color(0,0,0), ((LineBorder) cp.getBorder()).getLineColor());
		
		// Test abstract methods
		CellPanel absCp = cp;
		
		assertEquals(cell, absCp.getCellModel());
		assertEquals(tileView, absCp.getTileView());
	}

}
