package game.controller;
import game.boundary.GameFrame;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import common.LevelSaver;
import common.entity.Level;

public class AchievementsSwitchLevelController implements MouseListener{
	GameFrame gf;
	String fileName;
	
	Level level;
	
	public AchievementsSwitchLevelController(GameFrame gf, String fileName){
		this.gf = gf;
		this.fileName = fileName;
	}

	public void mouseClicked(MouseEvent e) {
		
		try {
			level = LevelSaver.levelFromJsonFile(fileName, 0);
		} catch (FileNotFoundException e1) {
			return;
		}

		gf.getAchievementsPanel().getLevelNameLabel().setText(level.filename());
		
		//Max amount of time/moves
		//if it's lightning, display max time and not max moves
		if (level.getType().equals("Lightning")){
			gf.getAchievementsPanel().getMaxLabel().setText("Max Time: " + level.getMaxTime());
		} else{
			gf.getAchievementsPanel().getMaxLabel().setText("Max Moves: " + level.getMaxMoves());
		}
		
		//high score
		gf.getAchievementsPanel().getHighScoreLabel().setText("" + level.getHighScore());
		
		//stars
		if (level.getHighScore() >= level.getStar3Score()){
			gf.getAchievementsPanel().getStarsLabel().setText("3/3");
			
		} else if (level.getHighScore() >= level.getStar2Score()) {
			gf.getAchievementsPanel().getStarsLabel().setText("2/3");
			
		} else if (level.getHighScore() >= level.getStar1Score()){
			gf.getAchievementsPanel().getStarsLabel().setText("1/3");
			
		} else {
			gf.getAchievementsPanel().getStarsLabel().setText("0/3");
		}			
		
		//Locked
		if (level.getLocked()){
			gf.getAchievementsPanel().getLblLocked().setText("Availability: Locked");
		} else {
			gf.getAchievementsPanel().getLblLocked().setText("Availability: Unlocked");
		}
		
		//isWon
		if (level.getIsWon()){
			gf.getAchievementsPanel().getLblIsWon().setText("Win Status: Won");
		} else {
			gf.getAchievementsPanel().getLblIsWon().setText("Win Status: Incomplete");
		}
		
		//number of special moves allowed
		gf.getAchievementsPanel().getLblNumSwaps().setText("Number of Swaps Allowed: " + level.getNumSwap());
		gf.getAchievementsPanel().getLblNumRemoves().setText("Number of Removes Allowed: " + level.getNumRemove());
		gf.getAchievementsPanel().getLblNumShuffles().setText("Number of Shuffles Allowed: " + level.getNumShuffle());
		
		//Active Cells
		gf.getAchievementsPanel().getLblNumActiveCells().setText("Number of Active Cells: " + level.getNumActiveCells());
		
		if (level.getType().equals("Release")){
			gf.getAchievementsPanel().getLblNumBaskets().setText("numBaskets");
		} else {
			gf.getAchievementsPanel().getLblNumBaskets().setText("");
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
