package levelBuilder.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import common.boundary.BoardPanel;

public class UndoButtonController implements MouseListener{

	EditPanel editPanel;
	LevelBuilder editor;
	
	public UndoButtonController(EditPanel editPanel, LevelBuilder editor){
		this.editPanel = editPanel;
		this.editor = editor;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

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
