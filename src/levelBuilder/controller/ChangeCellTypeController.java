package levelBuilder.controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.ChangeCellTypeMove;
import levelBuilder.move.Move;
import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.boundary.TileCellPanel;
import common.boundary.TilePanel;
import common.entity.Cell;

public class ChangeCellTypeController implements MouseListener{
	BoardPanel board;
	LevelBuilder editor;
	
	public ChangeCellTypeController(BoardPanel board, LevelBuilder editor){
		this.board = board;
		this.editor = editor;
		
	}
	
	public void mousePressed(MouseEvent me) {
		CellPanel cell = (CellPanel) board.getComponentAt(me.getPoint());
		Move m = new ChangeCellTypeMove(cell.getCellModel(), board.getBoardModel());
		if(m.doMove(editor)){
			editor.pushMove(m);
		};
		
		board.refresh();
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
