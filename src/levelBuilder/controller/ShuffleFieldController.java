package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.ShuffleMove;

public class ShuffleFieldController implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	
	public ShuffleFieldController(LevelBuilder editor, JTextField field, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
		this.editPanel = editPanel;
	
	}
	
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		UndoableEdit undo = e.getEdit();
		ShuffleMove move = new ShuffleMove(field.getText(), editor.getLevel().getNumShuffle(), undo);
		if(move.doMove(editor)){
			editor.pushMove(move);
		}	
	} 

}
