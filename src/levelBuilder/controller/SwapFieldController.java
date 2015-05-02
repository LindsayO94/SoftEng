package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.ShuffleMove;
import levelBuilder.move.SwapMove;

public class SwapFieldController implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	
	public SwapFieldController(LevelBuilder editor, JTextField field, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
		this.editPanel = editPanel;
	
	}
	
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		UndoableEdit undo = e.getEdit();
		SwapMove move = new SwapMove(field.getText(), editor.getLevel().getNumSwap(), undo);
		if(move.doMove(editor)){
			editor.pushMove(move);
		}	
	} 

}
