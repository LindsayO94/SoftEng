package game.boundary;
import game.entities.*;
import game.boundary.*;
import game.controller.*;

import java.awt.Dimension;

import javax.swing.JFrame;

import java.awt.CardLayout;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	//Entities
	Game game;
	
	AchievementsPanel achievements;
	PlayGamePanel playGame;
	LevelSelectPanel levelSelect;
	MainMenuPanel mainMenu = new MainMenuPanel();
	
	public GameFrame(Game game) {
		
		this.game = game;
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
		
		getContentPane().add(mainMenu, "Main Menu");
		getContentPane().add(playGame, "Play Game");
		getContentPane().add(levelSelect, "1");
		getContentPane().add(achievements, "Achievements");
	}

	/*public void showAchievements() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "Achievements");
	}*/
	
	
}
