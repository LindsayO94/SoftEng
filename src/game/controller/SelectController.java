package game.controller;

import game.boundary.PlayGamePanel;
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


//basket cases need to accounted for. Just add to the switch statements
//also there is a point where assumed click on TileCell, change that to Cell and error check on click or select or whatever. 

public class SelectController implements MouseMotionListener, MouseListener{
	BoardPanel board;
	Game game;
	ArrayList<CellPanel> cells = new ArrayList<CellPanel>();
	ArrayList<Cell> cellsM = new ArrayList<Cell>();
	PlayGamePanel gamePanel;
	
	
	boolean mousePressed = false;
	
	public SelectController(BoardPanel board, Game game, PlayGamePanel gamePanel){
		this.board = board;
		this.game = game;
		this.gamePanel = gamePanel;
		
	}
	
	public void mousePressed(MouseEvent me) {
			
		}

	public void mouseDragged(MouseEvent me) {
			//move the array to the move class
			CellPanel cell = (CellPanel) board.getComponentAt(me.getPoint());
			if (cell == null) {
				System.out.println("Drag event occurred with no component");
				return;
			}
			
			cells.add(cell);
			cellsM.add(cell.getCellModel());
			SelectMove m = new SelectMove(cell.getCellModel(), board.getBoardModel(), cells);
			m.doMove(game);
			board.refresh();
			
			//((TileCellPanel) cell).refresh();
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
		RemoveSelected m = new RemoveSelected(board.getBoardModel(), cellsM);
		m.doMove(game);
		cells.clear();
		cellsM.clear();
		board.refresh();
		gamePanel.refresh();
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