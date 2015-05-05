package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.ScoreMove;

/**
 * Controller which listens for changes to the Star Score Fields in the Edit Panel
 * @author August
 *
 */
public class StarScoreFieldController implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	int index;
	
	/**
	 * Class Constructor
	 * @param editor: A copy of the level builder top level entity class 
	 * @param field: the JTextField in Question
	 * @param index: an index indicating which Star Score Field this controller is assigned to
	 * @param editPanel: the Panel which hosts the Moves Field
	 */
	public StarScoreFieldController(LevelBuilder editor, JTextField field,int index, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
		this.index = index;
		this.editPanel = editPanel;
	
	}
	
	/**
	 * undoableEditHappened: Method which listens for undoable edits to the JTextField document. When an event occurs the
	 * appropriate move is created and is pushed onto the undo stack in the level Editor.
	 * @param e: the UndoableEditEvent that occured
	 */
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		UndoableEdit undo = e.getEdit();
		ScoreMove move = new ScoreMove(field.getText(), index, editor.getLevel().getStarScoreArray(), undo);
		if(move.doMove(editor)){
			editor.pushMove(move);
		}	
		editPanel.refresh();
	} 

}
