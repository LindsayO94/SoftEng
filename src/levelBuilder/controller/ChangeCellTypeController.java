package levelBuilder.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import common.boundary.CellPanel;

public class ChangeCellTypeController implements MouseListener{

	CellPanel cell;
	
	public ChangeCellTypeController(CellPanel cell){
		this.cell = cell;
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Click!");
		cell.getCellModel().toggleActive();
		cell.getTileView().setBackground();
		cell.getTileView().toggleNumber();
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
