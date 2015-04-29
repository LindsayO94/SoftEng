package levelBuilder.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.entity.LevelBuilder;

import common.boundary.BoardPanel;

public class UndoController implements MouseListener{

	BoardPanel board;
	LevelBuilder editor;
	
	public UndoController(BoardPanel board, LevelBuilder editor){
		this.board = board;
		this.editor = editor;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		editor.undoMove();
		
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
