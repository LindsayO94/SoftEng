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

	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) bf.getContentPane().getLayout();
		cardLayout.show(bf.getContentPane(), "Main Menu");
		
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
