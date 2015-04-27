package levelBuilder.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.entity.LevelBuilder;

import common.boundary.CellPanel;
import common.boundary.TileCellPanel;
import common.boundary.TilePanel;
import common.entity.Move;

public class ChangeCellTypeController implements MouseListener{

	CellPanel cell;
	LevelBuilder editor;
	
	public ChangeCellTypeController(CellPanel cell, LevelBuilder editor){
		this.cell = cell;
		this.editor = editor;
		
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		Move m = new ChangeCellTypeMove(cell);
		m.doMove(editor);
		
		cell.repaint();
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
