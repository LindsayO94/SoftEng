package levelBuilder.move;


import static org.junit.Assert.*;
import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.entity.LevelBuilder;

import org.junit.Test;

import common.entity.Level;
import common.entity.Board;

public class TestToggleMove {
	
	LevelBuilder editor;
	LevelBuilderFrame frame;
	
	@Test
	public void testToggleCell(){
		editor = new LevelBuilder();
		frame = new LevelBuilderFrame(editor) ;
		editor.setFrame(frame);
		editor.setLevel(new Level("Puzzle", 342));
		frame.setVisible(true);
		frame.showMainMenu();
		frame.showEditor(editor.getLevel());
		editor.getLevel().toggleCell(editor.getBoard().getCells().get(0).get(0));
	}

}
