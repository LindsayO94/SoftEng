package game.controller;

import game.entities.Game;
import game.move.SelectMove;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.move.ChangeCellTypeMove;
import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.boundary.TileCellPanel;
import common.boundary.TilePanel;
import common.entity.Cell;




public class SelectController implements MouseListener{
	BoardPanel board;
	Game game;
	boolean mousePressed = false;
	
	public SelectController(BoardPanel board, Game game){
		this.board = board;
		this.game = game;
		
	}
	
	public void mousePressed(MouseEvent me) {
			System.out.println("Cell pressed");
			//mousePressed = true;
			CellPanel cell = (CellPanel) board.getComponentAt(me.getPoint());
			SelectMove m = new SelectMove(cell.getCellModel(), board.getBoardModel());
			m.doMove(game);
			board.refresh();
			((TileCellPanel) cell).refresh();
		}

	public void mouseDragged(MouseEvent me) {
			
		
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

	public void mouseReleased(MouseEvent arg0) {
	
		
		
	}
	
	public boolean isPressed()
	{
		return mousePressed;
	}

}