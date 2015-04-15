package game.controller;

import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SplashController implements MouseListener{
	
	GameFrame gf;
	
	public SplashController(GameFrame gf){
		this.gf = gf;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) gf.getContentPane().getLayout();
		cardLayout.show(gf.getContentPane(), "Main Menu");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
