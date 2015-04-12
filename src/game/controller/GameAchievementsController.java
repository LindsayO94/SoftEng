package game.controller;
import game.boundary.GameFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameAchievementsController implements MouseListener {
	GameFrame gf;
	
	public GameAchievementsController(GameFrame gf){
		this.gf = gf;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gf.showAchievements();
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
