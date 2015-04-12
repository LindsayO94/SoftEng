package game.boundary;

import game.controller.GameAchievementsController;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import java.awt.CardLayout;

public class GameFrame extends JFrame {
	AchievementsPanel achievements = new AchievementsPanel();
	MainMenuPanel mainMenu = new MainMenuPanel();
	
	public GameFrame() {
		
		this.setMinimumSize(new Dimension(800, 600));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		mainMenu.getAchievementsButton().addMouseListener(new GameAchievementsController(this));

		getContentPane().add(mainMenu, "Main Menu");
		getContentPane().add(achievements, "Achievements");
	}

	public void showAchievements() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "Achievements");
	}
	
	
}
