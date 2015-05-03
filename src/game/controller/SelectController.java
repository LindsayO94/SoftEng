package game.controller;

import game.entities.Game;
import game.move.RemoveSelected;
import game.move.SelectMove;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

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
	ArrayList<CellPanel> cells = new ArrayList<CellPanel>();
	
	
	boolean mousePressed = false;
	
	public SelectController(BoardPanel board, Game game){
		this.board = board;
		this.game = game;
		
	}
	
	public void mousePressed(MouseEvent me) {
			
		}

	public void mouseDragged(MouseEvent me) {
			
			CellPanel cell = (CellPanel) board.getComponentAt(me.getPoint());
			cells.add(cell);
			SelectMove m = new SelectMove(cell.getCellModel(), board.getBoardModel());
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
	
		RemoveSelected m = new RemoveSelected(board.getBoardModel());
		m.doMove(game);
		//board.refresh();
		for (int i = 0; i<cells.size(); i++)
		{
			((TileCellPanel) cells.get(i)).refresh();
		}
		
	}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}