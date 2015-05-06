package game.controller;
import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AchievementsSwitchLevelController implements MouseListener{
	GameFrame gf;
	String fileName;
	
	public AchievementsSwitchLevelController(GameFrame gf, String fileName){
		this.gf = gf;
		this.fileName = fileName;
	}

	public void mouseClicked(MouseEvent e) {
		gf.getAchievementsPanel().getLevelNameLabel().setText(fileName);
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
