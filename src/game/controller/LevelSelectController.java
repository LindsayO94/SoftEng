package game.controller;

import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LevelSelectController implements MouseListener {
GameFrame gf;
	
	public LevelSelectController(GameFrame gf){
		this.gf = gf;
	}

	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) gf.getContentPane().getLayout();
		cardLayout.show(gf.getContentPane(), "Level Select");
		gf.getLevelSelectPanel().refresh();
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

