package common.boundary;

import static org.junit.Assert.*;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import org.junit.Before;
import org.junit.Test;

import common.entity.Board;
import common.entity.Level;

public class BoardPanelTest {

	@Test
	public void testSimpleConstructor() {
		Board model = Board.makeBoard(new Level(12));
		BoardPanel view = new BoardPanel(model);
		
		displayView(view, 400, 400);
		
		// Make sure board got set right
		assertEquals(model, view.board);
		
		// Check that the right cells are in the right places
		// (only checked corners because the math is easier)
		CellPanel cellView = (CellPanel) view.getComponentAt(5, 5);
		assertEquals(view.cells[0], cellView);
		cellView = (CellPanel) view.getComponentAt(5, 395);
		assertEquals(view.cells[72], cellView);
		cellView = (CellPanel) view.getComponentAt(395, 5);
		assertEquals(view.cells[8], cellView);
		cellView = (CellPanel) view.getComponentAt(395, 395);
		assertEquals(view.cells[80], cellView);
		
		
	}
	
	public void displayView(JPanel panel, int w, int h) {
		// Java is *weird*
		JFrame f = new JFrame() {
			{
				GroupLayout groupLayout = new GroupLayout(getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, w, Short.MAX_VALUE)
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, h, Short.MAX_VALUE)
				);
				setMinimumSize(new Dimension(w, h+50));
				getContentPane().setLayout(groupLayout);

			}
		};
		f.setVisible(true);
	}

}
