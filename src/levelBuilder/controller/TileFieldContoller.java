package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.MultiplierFrequencyMove;
import levelBuilder.move.TileFrequencyMove;

/**
 * Controller Class which listens for changes to the Tile Frequency fields on the EditPanel
 * @author August
 */
public class TileFieldContoller implements UndoableEditListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	int index;
	
	/**
	 * Class Constructor
	 * @param editor: A copy of the level builder top level entity class 
	 * @param field: the JTextField in Question
	 * @param index: an index indicating which Tile Frequency Field this controller is assigned to
	 * @param editPanel: the Panel which hosts the Moves Field
	 */
	public TileFieldContoller(LevelBuilder editor, JTextField field,int index, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
		this.index = index;
		this.editPanel = editPanel;
	
	}
	
	/**
	 * undoableEditHappened: Method which listens for undoable edits to the JTextField document. When an event occurs the
	 * appropriate move is created and is pushed onto the undo stack in the level Editor.
	 * @param e: the UndoableEditEvent that occurred
	 */
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		UndoableEdit undo = e.getEdit();
		TileFrequencyMove move = new TileFrequencyMove(field.getText(), index, editor.getLevel().getFrequencyArray(), undo);
		if(move.doMove(editor)){
			editor.pushMove(move);
			
		}	
		editPanel.refresh();
	}

}
