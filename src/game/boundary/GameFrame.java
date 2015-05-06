package game.boundary;
import game.entities.*;
import game.controller.*;

import java.awt.Dimension;

import javax.swing.JFrame;

import common.boundary.BoardPanel;
import common.boundary.LevelSelectPanel;
import common.entity.Board;
import common.entity.Cell;
import common.entity.Level;

import java.awt.CardLayout;
import java.util.Random;
import java.util.Timer;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	//Entities
	Game game;
	
	AchievementsPanel achievements;
	PlayGamePanel playGame;
	LevelSelectPanel levelSelect = new LevelSelectPanel(true);
	MainMenuPanel mainMenu = new MainMenuPanel();
	SplashPanel splash = new SplashPanel();
	Random rand = new Random();

	AchievementsPanelNew achievementsNew;
	
	public GameFrame(Game game) {
		this.game = game;
		
		achievements = new AchievementsPanel(game);
		achievementsNew = new AchievementsPanelNew(game);
		playGame = new PlayGamePanel(game);
		this.setMinimumSize(new Dimension(800, 600));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		mainMenu.getPlayGameButton().addMouseListener(new LevelSelectController(this));
		mainMenu.getAchievementsButton().addMouseListener(new GameAchievementsController(this));
		
		achievements.getBackButton().addMouseListener(new BackToMainMenuController(this));
		achievementsNew.getMainMenuButton().addMouseListener(new BackToMainMenuController(this));
		
		playGame.getBackButton().addMouseListener(new ExitLevelController(this, playGame));
		playGame.getCompletedBackButton().addMouseListener(new ExitLevelController(this, playGame));
		playGame.getEnterEndlessButton().addMouseListener(new EnterEndlessModeController(this));
		playGame.getSwapButton().addMouseListener(new SwapController(this));
		playGame.getRemoveButton().addMouseListener(new RemoveController(this)); 
		playGame.getShuffleButton().addMouseListener(new ShuffleController(this));
		
		levelSelect.getMainMenuButton().addMouseListener(new BackToMainMenuController(this));
		splash.addMouseListener(new SplashController(this));
		
		for (String filename : levelSelect.getLevelButtons().keySet()) {
			levelSelect.getLevelButton(filename).addMouseListener(new PlayGameController(this, filename));
		}
		
		for (String filename : achievementsNew.getLevelButtons().keySet()) {
			achievementsNew.getLevelButton(filename).addMouseListener(new AchievementsSwitchLevelController(this, filename));
		}
		
		getContentPane().add(splash, "Splash");
		getContentPane().add(mainMenu, "Main Menu");
		getContentPane().add(playGame, "Play Game");
		getContentPane().add(levelSelect, "Level Select");
		getContentPane().add(achievementsNew, "AchievementsNew");
	}

	public void setBoard(Board board) {
		playGame.setBoard(board);
	}

	public PlayGamePanel getPlayView() {
		return playGame;
	}
	
	public LevelSelectPanel getLevelSelectPanel(){
		return levelSelect;
	}
	
	public AchievementsPanelNew getAchievementsPanel(){
		return achievementsNew;
	}

	public long getSeed() {
		return rand.nextLong();
	}
	
	public Game getGame() {
		return game;
	}
		
}
