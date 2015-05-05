package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.MaxMovesMove;

/**
 * MovesFieldController: Controller which listens for changes in the Moves Text Field on the edit panel
 * @author August
 *
 */
public class MovesFieldController implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	
	/**
	 * Class Constructor
	 * @param editor: A copy of the level builder top level entity class 
	 * @param field: the JTextField in Question
	 * @param editPanel: the Panel which hosts the Moves Field
	 */
	public MovesFieldController(LevelBuilder editor, JTextField field, EditPanel editPanel){
		 
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
		MaxMovesMove move = new MaxMovesMove(field.getText(), editor.getLevel().getMaxMoves(), undo);
		if(move.doMove(editor)){
			editor.pushMove(move);
		}	
		editPanel.refresh();
	}  

}
