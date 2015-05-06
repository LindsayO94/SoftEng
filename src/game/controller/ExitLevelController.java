package game.controller;
import game.boundary.GameFrame;
import game.boundary.PlayGamePanel;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import common.LevelSaver;
import common.entity.Board;

public class ExitLevelController implements MouseListener{
	GameFrame gf;
	PlayGamePanel playGamePanel;
	
	public ExitLevelController(GameFrame gf, PlayGamePanel playGame){
		this.gf = gf;
		this.playGamePanel = playGame;
	}

	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) gf.getContentPane().getLayout();
		cardLayout.show(gf.getContentPane(), "Main Menu");
		
		Board b = playGamePanel.getBoard();
		
		b.saveHighScore();
		b.onExitLevelAction();
		
		try {
			LevelSaver.levelToJsonFile(b.getLevel());
			System.out.println("Saved changes to level");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
