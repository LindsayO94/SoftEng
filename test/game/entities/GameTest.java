package game.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import common.LevelSaver;
import common.TestLevels;
import common.entity.Level;

public class GameTest {

	@Test
	public void test() {
		Level[] levels = { 
				LevelSaver.levelFromJsonString(TestLevels.puzzleNoInactive, 0),
				LevelSaver.levelFromJsonString(TestLevels.puzzleHalfInactive, 0)
		};
		ArrayList<Level> list = new ArrayList<Level>(Arrays.asList(levels));
		Game g = new Game(list);
		
		int i = 0;
		for (Level l : g) {
			assertTrue(i < levels.length);
			assertEquals(levels[i], l);
			i += 1;
		}
		assertEquals(levels.length, i);
	}

}
