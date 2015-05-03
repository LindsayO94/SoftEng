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
	Random rand = new Random(); 
	
	public GameFrame(Game game) {
		this.game = game;
		this.level = game.iterator().next();
		
		board = new BoardPanel(Board.makeBoard(level));
		achievements = new AchievementsPanel(game);
		playGame = new PlayGamePanel(game);
		this.setMinimumSize(new Dimension(800, 600));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		mainMenu.getPlayGameButton().addMouseListener(new LevelSelectController(this));
		mainMenu.getAchievementsButton().addMouseListener(new GameAchievementsController(this));
		achievements.getBackButton().addMouseListener(new BackToMainMenuController(this));
		playGame.getBackButton().addMouseListener(new BackToMainMenuController(this));
		levelSelect.getMainMenuButton().addMouseListener(new BackToMainMenuController(this));
		splash.addMouseListener(new SplashController(this));
		board.addMouseMotionListener(new SelectController(board, game));
		board.addMouseListener(new SelectController(board, game));
		
		for (String filename : levelSelect.getLevelButtons().keySet()) {
			levelSelect.getLevelButton(filename).addMouseListener(new PlayGameController(this, filename));
		}
		
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

	public long getSeed() {
		return rand.nextLong();
	}
}
