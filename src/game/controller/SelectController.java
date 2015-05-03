package game.controller;

import game.entities.Game;
import game.move.RemoveSelected;
import game.move.SelectMove;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import levelBuilder.move.ChangeCellTypeMove;
import levelBuilder.move.RemoveMove;
import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.boundary.TileCellPanel;
import common.boundary.TilePanel;
import common.entity.Cell;




public class SelectController implements MouseMotionListener, MouseListener{
	BoardPanel board;
	Game game;
	int num;
	boolean mousePressed = false;
	
	public SelectController(BoardPanel board, Game game){
		this.board = board;
		this.game = game;
		
	}
	
	public void mousePressed(MouseEvent me) {
			
		}

	public void mouseDragged(MouseEvent me) {
			num = 0;
			CellPanel cell = (CellPanel) board.getComponentAt(me.getPoint());
			SelectMove m = new SelectMove(cell.getCellModel(), board.getBoardModel(), num);
			m.doMove(game);
			board.refresh();
			((TileCellPanel) cell).refresh();
		}
		

	public void mouseEntered(MouseEvent me) {
		
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent me) {
		
		num = 1;
		System.out.println(num);
		CellPanel cell = (CellPanel) board.getComponentAt(me.getPoint());
		SelectMove m = new SelectMove(cell.getCellModel(), board.getBoardModel(), num);
		m.doMove(game);
		board.refresh();
		((TileCellPanel) cell).refresh();
		
	}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}