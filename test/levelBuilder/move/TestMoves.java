package levelBuilder.move;


import common.entity.Board;
import common.entity.Cell;
import common.entity.InactiveCell;
import common.entity.Level;
import common.entity.Tile;
import common.entity.TileCell;

import javax.swing.text.GapContent;
import javax.swing.undo.UndoableEdit;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.entity.LevelBuilder;


/**
 * @author August Beers
 */
public class TestMoves{

	//"Puzzle", "Lightning", "Elimination", "Release" 
	LevelBuilder editor;
	LevelBuilderFrame frame;
	
	@Before
	public void setUp() {
		editor = new LevelBuilder();
		frame = new LevelBuilderFrame(editor) ;
		editor.setFrame(frame);
		editor.setLevel(new Level("Puzzle", 342));
		frame.setVisible(true);
		frame.showMainMenu();
		frame.showEditor(editor.getLevel());
	}
	
	@After
	public void tearDown() {
		frame.dispose();
		editor.dispose();
		
		
		frame = null;
		editor = null;
		
	}
	
	@Test
	public void testTimeLimitMove(){
		DummyUndoableEdit edit = new DummyUndoableEdit();
		TimeLimitMove move = new TimeLimitMove("6", 2, edit);
			
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getMaxTime(),6);
		
		TimeLimitMove move2 = new TimeLimitMove("", 2, edit);
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getMaxTime(),0);
		
		
		TimeLimitMove move3 = new TimeLimitMove("h", 2, edit);
		
		move3.doMove(editor);
		
		assertEquals(editor.getLevel().getMaxTime(),0);
		
		
	}
	
	@Test
	public void testTileFrequencyMove() {
		DummyUndoableEdit edit = new DummyUndoableEdit();
		TileFrequencyMove move = new TileFrequencyMove("6", 0, editor.getLevel().getFrequencyArray(), edit);
			
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getFrequency(0),6);
		
		TileFrequencyMove move2 = new TileFrequencyMove("", 0, editor.getLevel().getFrequencyArray(), edit);
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getFrequency(0),0);
		
		
		TileFrequencyMove move3 = new TileFrequencyMove("h", 0, editor.getLevel().getFrequencyArray(), edit);
		
		move3.doMove(editor);
		
		assertEquals(editor.getLevel().getFrequency(0),0);
	}
	
	@Test
	public void testSwapMove() {
		DummyUndoableEdit edit = new DummyUndoableEdit();
		SwapMove move = new SwapMove("6", 2, edit);
			
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getNumSwap(),6);
		
		SwapMove move2 = new SwapMove("", 2, edit);
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getNumSwap(),0);
		
		
		SwapMove move3 = new SwapMove("h", 2, edit);
		
		move3.doMove(editor);
		
		assertEquals(editor.getLevel().getNumSwap(),0);
	}
	
	@Test
	public void testShuffleMove() {
		DummyUndoableEdit edit = new DummyUndoableEdit();
		ShuffleMove move = new ShuffleMove("6", 2, edit);
			
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getNumShuffle(),6);
		
		ShuffleMove move2 = new ShuffleMove("", 2, edit);
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getNumShuffle(),0);
		
		
		ShuffleMove move3 = new ShuffleMove("h", 2, edit);
		
		move3.doMove(editor);
		
		assertEquals(editor.getLevel().getNumShuffle(),0);
	}
	
	@Test
	public void testRemoveMove() {
		DummyUndoableEdit edit = new DummyUndoableEdit();
		RemoveMove move = new RemoveMove("6", 2, edit);
			
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getNumRemove(),6);
		
		RemoveMove move2 = new RemoveMove("", 2, edit);
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getNumRemove(),0);
		
		
		RemoveMove move3 = new RemoveMove("h", 2, edit);
		
		move3.doMove(editor);
		
		assertEquals(editor.getLevel().getNumRemove(),0);
	}
	
	@Test
	public void testScoreMove() {
		DummyUndoableEdit edit = new DummyUndoableEdit();
		ScoreMove move = new ScoreMove("6", 0, editor.getLevel().getFrequencyArray(), edit);
			
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getStarScore(0),6);
		
		ScoreMove move2 = new ScoreMove("", 0, editor.getLevel().getFrequencyArray(), edit);
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getStarScore(0),0);
		
		
		ScoreMove move3 = new ScoreMove("h", 0, editor.getLevel().getFrequencyArray(), edit);
		
		move3.doMove(editor);
		
		assertEquals(editor.getLevel().getStarScore(0),0);
	}
	
	@Test
	public void testMultiplierFrequencyMove() {
		DummyUndoableEdit edit = new DummyUndoableEdit();
		MultiplierFrequencyMove move = new MultiplierFrequencyMove("6", 0, editor.getLevel().getFrequencyArray(), edit);
			
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getMultiplierFrequency(0),6);
		
		MultiplierFrequencyMove move2 = new MultiplierFrequencyMove("", 0, editor.getLevel().getFrequencyArray(), edit);
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getMultiplierFrequency(0),0);
		
		
		MultiplierFrequencyMove move3 = new MultiplierFrequencyMove("h", 0, editor.getLevel().getFrequencyArray(), edit);
		
		move3.doMove(editor);
		
		assertEquals(editor.getLevel().getMultiplierFrequency(0),0);
	}
	
	@Test
	public void testMaxMovesMove() {
		DummyUndoableEdit edit = new DummyUndoableEdit();
		MaxMovesMove move = new MaxMovesMove("6", 2, edit);
			
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getMaxMoves(),6);
		
		MaxMovesMove move2 = new MaxMovesMove("", 2, edit);
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getMaxMoves(),0);
		
		
		MaxMovesMove move3 = new MaxMovesMove("h", 2, edit);
		
		move3.doMove(editor);
		
		assertEquals(editor.getLevel().getMaxMoves(),0);
	}
	
	@Test
	public void testGameTypeMove(){
		
		GameTypeMove move = new GameTypeMove("Elimination", "Puzzle", frame.getEditor());
		
		move.doMove(editor);
		
		assertEquals(editor.getLevel().getType(),"Elimination" );
		
		assertFalse(frame.getEditor().getTimeLimitTextField().isEnabled());
		
		
		GameTypeMove move2 = new GameTypeMove("Lightning", "Puzzle", frame.getEditor());
		
		move2.doMove(editor);
		
		assertEquals(editor.getLevel().getType(),"Lightning" );
		
		assertTrue(frame.getEditor().getTimeLimitTextField().isEnabled());
		assertFalse(frame.getEditor().getMaxMovesTextField().isEnabled());
		
		GameTypeMove move3 = new GameTypeMove("Release", "Lightning", frame.getEditor());
		
//		move3.doMove(editor);
//		
//		assertEquals(editor.getLevel().getType(),"Release" );
//		
//		assertFalse(frame.getEditor().getTimeLimitTextField().isEnabled());
//		assertTrue(frame.getEditor().getMaxMovesTextField().isEnabled());
//		
//		
//		assertEquals(editor.getLevel().getType(),"Release" );
		
		GameTypeMove move4 = new GameTypeMove("Lightning", "Release", frame.getEditor());
		
		move4.doMove(editor);
		
	}

	@Test
	public void testChangeCellTypeMove(){
		ChangeCellTypeMove move = new ChangeCellTypeMove(editor.getBoard().getCells().get(0).get(0), editor.getBoard());
		
		move.doMove(editor);
		
		move.undo(editor);
		
	}

	
	
	

	
}
