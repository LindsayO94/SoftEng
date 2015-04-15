package levelBuilder.controller;

import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.boundary.LevelBuilderFrame;

public class SplashController implements MouseListener{
	
	LevelBuilderFrame bf;
	
	public SplashController(LevelBuilderFrame levelBuilderFrame){
		this.bf = levelBuilderFrame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) bf.getContentPane().getLayout();
		cardLayout.show(bf.getContentPane(), "Main Menu");
		
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
