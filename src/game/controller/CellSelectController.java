package game.controller;

import game.entities.Game;
import game.move.CellSelectMove;
import game.move.SelectMove;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import levelBuilder.move.ChangeCellTypeMove;
import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.boundary.TileCellPanel;
import common.boundary.TilePanel;
import common.entity.Cell;
import common.entity.TileCell;




public class CellSelectController implements MouseListener, MouseMotionListener{
	CellPanel cellP;
	BoardPanel board;
	Game game;
	SelectController pressed;
	public boolean mousePressed = false;

	
	public CellSelectController(CellPanel cellP){
		this.cellP = cellP;
		
	}
	
	public void mousePressed(MouseEvent me) {
		
		mousePressed = true;
		System.out.println("mouse pressed --> mousePressed is: " + mousePressed);
		Cell cell = cellP.getCellModel();
		CellSelectMove m = new CellSelectMove(cell);
		m.doMove(game);
		((TileCellPanel) cellP).refresh();
		
		}

	public void mouseDragged(MouseEvent me) {
		System.out.println("entered dragged");
		Cell cell = cellP.getCellModel();
		CellSelectMove m = new CellSelectMove(cell);
		m.doMove(game);
		((TileCellPanel) cellP).refresh();
		}
		
	
	public void mouseMoved(MouseEvent me) {
		System.out.println("entered dragged");
		Cell cell = cellP.getCellModel();
		CellSelectMove m = new CellSelectMove(cell);
		m.doMove(game);
		((TileCellPanel) cellP).refresh();
		}

	public void mouseEntered(MouseEvent me) {
		/*
		System.out.println("mouse entered --> mousePressed is:" + mousePressed);
		if (mousePressed == true)
		{
			Cell cell = cellP.getCellModel();
			CellSelectMove m = new CellSelectMove(cell);
			m.doMove(game);
			((TileCellPanel) cellP).refresh();
		}
		// TODO Auto-generated method stub
		*/
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent arg0) {
	
		//mousePressed = false;
		//System.out.println("Mouse Released --> mousePressed is:" + mousePressed);
		
	}

}