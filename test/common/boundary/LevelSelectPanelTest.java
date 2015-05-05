package common.boundary;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import javax.swing.JButton;

import org.junit.Test;

import common.TestUtil;

public class LevelSelectPanelTest {
	
	@Test
	public void testSimpleConstructor() {
		LevelSelectPanel view = new LevelSelectPanel(true);
		
		TestUtil.displayView(view, 600, 800);
		
		HashMap<String, JButton> buttons = view.getLevelButtons();
		
		assertEquals(buttons.get("Puzzle 1"), view.levelButtons.get("Puzzle 1"));

	}
}
