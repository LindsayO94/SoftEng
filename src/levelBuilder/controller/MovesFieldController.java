package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.MaxMovesMove;

public class MovesFieldController implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	
	public MovesFieldController(LevelBuilder editor, JTextField field, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
		this.editPanel = editPanel;
	
	}
	
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
