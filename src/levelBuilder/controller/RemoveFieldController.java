package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.RemoveMove;
import levelBuilder.move.SwapMove;

public class RemoveFieldController implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	
	public RemoveFieldController(LevelBuilder editor, JTextField field, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
		this.editPanel = editPanel;
	
	}
	
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		UndoableEdit undo = e.getEdit();
		RemoveMove move = new RemoveMove(field.getText(), editor.getLevel().getNumSwap(), undo);
		if(move.doMove(editor)){
			editor.pushMove(move);
		}	
		editPanel.refresh();
	} 

}
