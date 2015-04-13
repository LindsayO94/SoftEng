package game.boundary;
import entities.*;
import game.controller.GameAchievementsController;

import java.awt.Dimension;

import javax.swing.JFrame;

import java.awt.CardLayout;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	//Entities
	Game game;
	
	AchievementsPanel achievements;
	MainMenuPanel mainMenu = new MainMenuPanel();
	
	public GameFrame(Game game) {
		
		this.game = game;
		achievements = new AchievementsPanel(game);
		this.setMinimumSize(new Dimension(800, 600));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		mainMenu.getAchievementsButton().addMouseListener(new GameAchievementsController(this));

		getContentPane().add(mainMenu, "Main Menu");
		getContentPane().add(achievements, "Achievements");
	}

	/*public void showAchievements() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "Achievements");
	}*/
	
	
}
