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

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	//Entities
	Game game;
	Board Eboard;
	Level level;
	
	AchievementsPanel achievements;
	PlayGamePanel playGame;
	LevelSelectPanel levelSelect = new LevelSelectPanel();
	MainMenuPanel mainMenu = new MainMenuPanel();
	SplashPanel splash = new SplashPanel();
	BoardPanel board; 
	
	public GameFrame(Game game) {
		
		this.game = game;
		//this.level = game.iterator().next();
		
		//board = new BoardPanel(Board.makeBoard(level));
		achievements = new AchievementsPanel(game);
		playGame = new PlayGamePanel(game);
		this.setMinimumSize(new Dimension(800, 600));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		mainMenu.getPlayGameButton().addMouseListener(new LevelSelectController(this));
		mainMenu.getAchievementsButton().addMouseListener(new GameAchievementsController(this));
		achievements.getBackButton().addMouseListener(new BackToMainMenuController(this));
		playGame.getBackButton().addMouseListener(new BackToMainMenuController(this));
		levelSelect.getBackButton().addMouseListener(new BackToMainMenuController(this));
		levelSelect.getPuzzle1Button().addMouseListener(new PlayGameController(this));
		splash.addMouseListener(new SplashController(this));
		//board.addMouseListener(new SelectController(board, game));
		
		
		getContentPane().add(splash, "Splash");
		getContentPane().add(mainMenu, "Main Menu");
		getContentPane().add(playGame, "Play Game");
		getContentPane().add(levelSelect, "Level Select");
		getContentPane().add(achievements, "Achievements");
	}

	public void setBoard(Board board) {
		playGame.setBoard(board);
	}

	public PlayGamePanel getPlayView() {
		return playGame;
	}
}
