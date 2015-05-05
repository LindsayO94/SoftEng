package levelBuilder.boundary;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Event;
import java.awt.Panel;
import java.awt.event.MouseEvent;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

import org.junit.After;
import org.junit.Before;
import org.w3c.dom.Node;

import junit.framework.TestCase;
import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.ScoreMove;
import common.entity.Level;

public class TestControllers extends TestCase {

	//"Puzzle", "Lightning", "Elimination", "Release" 
	LevelBuilder editor;
	LevelBuilderFrame frame;
	
	@Before
	public void setUp() {
		editor = new LevelBuilder();
		frame = new LevelBuilderFrame(editor) ;
		editor.setFrame(frame);
		editor.setLevel(new Level("Puzzle", 342));
		frame.showEditor(editor.getLevel());
		
	}

	@After
	public void tearDown() {
		frame.dispose();
		editor.dispose();
		frame.setVisible(false);
		
		frame = null;
		editor = null;
		
	}
	
	
	public void testSwapFieldController(){

		frame.getEditor().swapField.setText("5");
		
		assertEquals(editor.getLevel().getNumSwap(), 5);

		
	}
	
	public void testTimeLimitFieldController(){

		frame.getEditor().timeLimitTextField.setText("5");
		
		assertEquals(editor.getLevel().getMaxTime(), 5);

		
	}
	
	public void testTileFieldController(){

		frame.getEditor().probabilitieField_1.setText("5");
		frame.getEditor().probabilitieField_2.setText("26");
		frame.getEditor().probabilitieField_3.setText("300");
		frame.getEditor().probabilitieField_4.setText("500");
		frame.getEditor().probabilitieField_5.setText("600");
		frame.getEditor().probabilitieField_6.setText("200");
		
		
		assertEquals(editor.getLevel().getFrequency(0), 5);
		assertEquals(editor.getLevel().getFrequency(1), 26);
		assertEquals(editor.getLevel().getFrequency(2), 300);
		assertEquals(editor.getLevel().getFrequency(3), 500);
		assertEquals(editor.getLevel().getFrequency(4), 600);
		assertEquals(editor.getLevel().getFrequency(5), 200);

		
	}
	
	public void testStarScoreController(){

		frame.getEditor().scoreField_1.setText("5");
		frame.getEditor().scoreField_2.setText("26");
		frame.getEditor().scoreField_3.setText("300");

		
		
		assertEquals(editor.getLevel().getStar1Score(), 5);
		assertEquals(editor.getLevel().getStar2Score(), 26);
		assertEquals(editor.getLevel().getStar3Score(), 300);


		
	}
	
	public void testShuffleFieldController(){

		frame.getEditor().shuffleField.setText("5");
		
		assertEquals(editor.getLevel().getNumShuffle(), 5);

		
	}
	
	public void testRemoveFieldController(){

		frame.getEditor().removeField.setText("5");
		
		assertEquals(editor.getLevel().getNumRemove(), 5);

		
	}
	
	public void testMultiplierFieldController(){

		frame.getEditor().multiplierField_1.setText("5");
		frame.getEditor().multiplierField_2.setText("26");
		frame.getEditor().multiplierField_3.setText("300");

		
		
		assertEquals(editor.getLevel().getMultiplierFrequency(0), 5);
		assertEquals(editor.getLevel().getMultiplierFrequency(1), 26);
		assertEquals(editor.getLevel().getMultiplierFrequency(2), 300);


		
	}
	
	
	public void testMovesFieldController(){

		frame.getEditor().maxMovesField.setText("5");
		
		assertEquals(editor.getLevel().getMaxMoves(), 5);

		
	}
	
	

}