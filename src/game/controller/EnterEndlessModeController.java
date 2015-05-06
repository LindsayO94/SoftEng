package game.controller;
import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import common.entity.PuzzleBoard;

public class EnterEndlessModeController implements MouseListener{
	GameFrame gf;
	
	public EnterEndlessModeController(GameFrame gf){
		this.gf = gf;
	}

	public void mouseClicked(MouseEvent e) {
		((PuzzleBoard) gf.getPlayView().getBoard()).setEndlessMode(true);
		gf.getPlayView().refresh();
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
