package levelBuilder.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import common.boundary.BoardPanel;

/**
 * Controller Class which coordinates the undo capabilities of the EditPanel
 * @author August
 */
public class UndoButtonController implements MouseListener{

	EditPanel editPanel;
	LevelBuilder editor;
	
	/**
	 * Class Constructor
	 * @param editPanel: the LevelBuilderFrame's editPanel
	 * @param editor: the top level entity LevelBuilder
	 */
	public UndoButtonController(EditPanel editPanel, LevelBuilder editor){
		this.editPanel = editPanel;
		this.editor = editor;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * On mouse pressed undo the most recent edit on the undo stack and refresh the edit Panel
	 *  @param e: the mouse event in question
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		editor.undoMove();
		editPanel.refresh();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
