package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.ScoreMove;

public class StarScoreFieldController implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	int index;
	public StarScoreFieldController(LevelBuilder editor, JTextField field,int index, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
		this.index = index;
		this.editPanel = editPanel;
	
	}
	
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		UndoableEdit undo = e.getEdit();
		ScoreMove move = new ScoreMove(field.getText(), index, editor.getLevel().getStarScoreArray(), undo);
		if(move.doMove(editor)){
			editor.pushMove(move);
		}	
	} 

}
