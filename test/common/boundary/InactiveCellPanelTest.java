package common.boundary;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.border.LineBorder;

import org.junit.Test;

import common.entity.InactiveCell;

public class InactiveCellPanelTest {

	@Test
	public void test() {
		InactiveCell cell = new InactiveCell(0, 0);
		InactiveCellPanel cp = new InactiveCellPanel(cell);
		
		// Black border
		assertEquals(new Color(0,0,0), ((LineBorder) cp.getBorder()).getLineColor());
		
		// Test abstract methods
		CellPanel absCp = cp;
		
		assertEquals(cell, absCp.getCellModel());
		assertEquals(null, absCp.getTileView());
	}

}
