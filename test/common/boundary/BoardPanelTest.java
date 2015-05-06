package common.boundary;

import static org.junit.Assert.*;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import org.junit.Before;
import org.junit.Test;

import common.LevelSaver;
import common.TestLevels;
import common.TestUtil;
import common.entity.Board;
import common.entity.InactiveCell;
import common.entity.Level;

public class BoardPanelTest {

	@Test
	public void testSimpleConstructor() {
		Board model = TestLevels.getBoard(TestLevels.puzzleNoInactive);
		BoardPanel view = new BoardPanel(model);
		
		TestUtil.displayView(view, 400, 400);
		
		// Make sure board got set right
		assertEquals(model, view.board);
		assertEquals(model, view.getBoardModel());
		
		// Check that the right cells are in the right places
		// (only checked corners because the math is easier)
		CellPanel cellView = (CellPanel) view.getComponentAt(5, 5);
		assertEquals(view.cells[0], cellView);
		cellView = (CellPanel) view.getComponentAt(5, 395);
		assertEquals(view.cells[72], cellView);
		cellView = (CellPanel) view.getComponentAt(380, 10);
		assertEquals(view.cells[8], cellView);
		cellView = (CellPanel) view.getComponentAt(375, 375);
		
		// Test getters
		assertArrayEquals(view.cells, view.getCellPanel());
		assertEquals(0, view.getNumBaskets());
	}
	
	@Test
	public void testInactiveCells() {
		Board model = TestLevels.getBoard(TestLevels.puzzleHalfInactive);
		BoardPanel view = new BoardPanel(model);
		
		TestUtil.displayView(view, 400, 400);
		
		// Make sure board got set right
		assertEquals(model, view.board);
		
		// Check inactive cells vs tile cells
		InactiveCellPanel inactiveView = (InactiveCellPanel) view.getComponentAt(5, 5);
		assertEquals(view.cells[0], inactiveView);
		CellPanel cellView = (CellPanel) view.getComponentAt(5, 395);
		assertEquals(view.cells[72], cellView);
		cellView = (CellPanel) view.getComponentAt(380, 10);
		assertEquals(view.cells[8], cellView);
		assertEquals(0, view.getNumBaskets());
	}
}
