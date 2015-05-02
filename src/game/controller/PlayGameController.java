package game.controller;
import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import common.LevelSaver;
import common.entity.Board;
import common.entity.Level;

public class PlayGameController implements MouseListener {
	GameFrame gf;
	String filename;
	
	public PlayGameController(GameFrame gf, String filename){
		this.gf = gf;
		this.filename = filename;
	}

	public void mouseClicked(MouseEvent e) {
		CardLayout cardLayout = (CardLayout) gf.getContentPane().getLayout();
		cardLayout.show(gf.getContentPane(), "Play Game");
		
		try {
			gf.setBoard(Board.makeBoard( LevelSaver.levelFromJsonFile(filename, gf.getSeed()) ));
			gf.getPlayView().refresh();
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(gf,
				    e1.getMessage(),
				    "Error loading file",
				    JOptionPane.ERROR_MESSAGE);
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
