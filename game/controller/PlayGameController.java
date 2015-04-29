package game.controller;
import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import common.entity.Board;
import common.entity.Level;

public class PlayGameController implements MouseListener {
	GameFrame gf;
	
	public PlayGameController(GameFrame gf){
		this.gf = gf;
	}

	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) gf.getContentPane().getLayout();
		cardLayout.show(gf.getContentPane(), "Play Game");
		
		// TODO: Give this the right Level object
		gf.setBoard(Board.makeBoard( new Level(0) ));
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
