package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.ShuffleMove;

/**
 * Controller which listens for changes in the Shuffle Text Field
 * @author August
 *
 */
public class ShuffleFieldController implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	
	/**
	 * Class Constructor
	 * @param editor: A copy of the level builder top level entity class 
	 * @param field: the JTextField in Question
	 * @param editPanel: the Panel which hosts the Moves Field
	 */
	public ShuffleFieldController(LevelBuilder editor, JTextField field, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
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
		ShuffleMove move = new ShuffleMove(field.getText(), editor.getLevel().getNumShuffle(), undo);
		if(move.doMove(editor)){
			editor.pushMove(move);
		}
		editPanel.refresh();
	} 

}
