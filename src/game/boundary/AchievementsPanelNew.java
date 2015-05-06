package game.boundary;

import game.controller.PlayGameController;
import game.entities.Game;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.SwingConstants;

import levelBuilder.controller.ChooseLevelButtonController;
import common.LevelSaver;
import common.entity.Level;

import javax.swing.ScrollPaneConstants;

/**
 * Achievements Panel for Game
 * Much of the functionality of this panel was taken from Will's level select panel
 * @author Arty
 *
 */
public class AchievementsPanelNew extends JPanel {
	HashMap<String, JButton> levelButtons = new HashMap<String, JButton>();
	private JButton btnBackToMain;
	JScrollPane puzzleScroll;
	
	boolean disableLockedLevels;

	JScrollPane lightningScroll;
	JScrollPane eliminationScroll;
	JScrollPane releaseScroll;
	JPanel releasePanel;
	JPanel eliminationPanel;
	JPanel lightningPanel;
	JPanel puzzlePanel;


	public AchievementsPanelNew(Game game){
		this.disableLockedLevels = disableLockedLevels;
		setBackground(new Color(255, 204, 102));
		
		JLabel lblSixesWildLevel = new JLabel("Achievements!");
		lblSixesWildLevel.setBounds(35, 11, 705, 38);
		lblSixesWildLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSixesWildLevel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 36));
		
		puzzleScroll = new JScrollPane();
		puzzleScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		puzzleScroll.setBounds(35, 89, 150, 200);
		
		lightningScroll = new JScrollPane();
		lightningScroll.setBounds(220, 89, 150, 200);
		
		eliminationScroll = new JScrollPane();
		eliminationScroll.setBounds(405, 89, 150, 200);
		
		releaseScroll = new JScrollPane();
		releaseScroll.setBounds(590, 89, 150, 200);
		
		releasePanel = new JPanel();
		releaseScroll.setViewportView(releasePanel);
		releasePanel.setLayout(new BoxLayout(releasePanel, BoxLayout.Y_AXIS));
		
		eliminationPanel = new JPanel();
		eliminationScroll.setViewportView(eliminationPanel);
		eliminationPanel.setLayout(new BoxLayout(eliminationPanel, BoxLayout.Y_AXIS));
		
		lightningPanel = new JPanel();
		lightningScroll.setViewportView(lightningPanel);
		lightningPanel.setLayout(new BoxLayout(lightningPanel, BoxLayout.Y_AXIS));
		setLayout(null);
		
		puzzlePanel = new JPanel();
		puzzleScroll.setViewportView(puzzlePanel);
		puzzlePanel.setLayout(new BoxLayout(puzzlePanel, BoxLayout.Y_AXIS));
		add(puzzleScroll);
		add(lightningScroll);
		add(eliminationScroll);
		add(releaseScroll);
		add(lblSixesWildLevel);
		
		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setBounds(35, 55, 150, 30);
		add(lblPuzzle);
		
		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblLightning.setBounds(220, 55, 150, 30);
		add(lblLightning);
		
		JLabel lblElimination = new JLabel("Elimination");
		lblElimination.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimination.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblElimination.setBounds(405, 55, 150, 30);
		add(lblElimination);
		
		JLabel lblRelease = new JLabel("Release");
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblRelease.setBounds(590, 55, 150, 30);
		add(lblRelease);
		
		btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.setBounds(590, 519, 150, 29);
		add(btnBackToMain);
		
		JLabel lblLevel = new JLabel("Level Info");
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblLevel.setBounds(35, 338, 335, 38);
		add(lblLevel);
		
		JLabel lblHighScore = new JLabel("High Score");
		lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScore.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblHighScore.setBounds(381, 338, 206, 38);
		add(lblHighScore);
		
		JLabel label = new JLabel("<Level Name>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(35, 413, 150, 14);
		add(label);
		
		JLabel label_1 = new JLabel("<High Score>");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(381, 413, 206, 14);
		add(label_1);
		
		JLabel lblStars = new JLabel("Stars");
		lblStars.setHorizontalAlignment(SwingConstants.CENTER);
		lblStars.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblStars.setBounds(597, 338, 143, 38);
		add(lblStars);
		
		JLabel label_2 = new JLabel("<S/S>");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(597, 413, 143, 14);
		add(label_2);
		
Level level = new Level(0);
		
		puzzlePanel.removeAll();
		for (String filename : LevelSaver.getLevelFilenames("Puzzle")) {
			JButton btnNewButton = new JButton(LevelSaver.filenameToLevelName(filename));
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			puzzlePanel.add(btnNewButton);
			if (disableLockedLevels){
				try {
					level = LevelSaver.levelFromJsonFile(filename, 0);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(this,
						    e.getMessage(),
						    "Error loading file",
						    JOptionPane.ERROR_MESSAGE);
				}
				btnNewButton.setEnabled(!level.getLocked());
			}
			levelButtons.put(filename, btnNewButton);
		}
		
		lightningPanel.removeAll();
		for (String filename : LevelSaver.getLevelFilenames("Lightning")) {
			JButton btnNewButton = new JButton(LevelSaver.filenameToLevelName(filename));
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			lightningPanel.add(btnNewButton);
			if (disableLockedLevels){
				try {
					level = LevelSaver.levelFromJsonFile(filename, 0);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(this,
						    e.getMessage(),
						    "Error loading file",
						    JOptionPane.ERROR_MESSAGE);
				}
				btnNewButton.setEnabled(!level.getLocked());
			}
			levelButtons.put(filename, btnNewButton);
		}
		
		eliminationPanel.removeAll();
		for (String filename : LevelSaver.getLevelFilenames("Elimination")) {
			JButton btnNewButton = new JButton(LevelSaver.filenameToLevelName(filename));
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			eliminationPanel.add(btnNewButton);
			if (disableLockedLevels){
				try {
					level = LevelSaver.levelFromJsonFile(filename, 0);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(this,
						    e.getMessage(),
						    "Error loading file",
						    JOptionPane.ERROR_MESSAGE);
				}
				btnNewButton.setEnabled(!level.getLocked());
			}
			levelButtons.put(filename, btnNewButton);
		}
		
		releasePanel.removeAll();
		for (String filename : LevelSaver.getLevelFilenames("Release")) {
			JButton btnNewButton = new JButton(LevelSaver.filenameToLevelName(filename));
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			releasePanel.add(btnNewButton);
			if (disableLockedLevels){
				try {
					level = LevelSaver.levelFromJsonFile(filename, 0);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(this,
						    e.getMessage(),
						    "Error loading file",
						    JOptionPane.ERROR_MESSAGE);
				}
				btnNewButton.setEnabled(!level.getLocked());
			}
			levelButtons.put(filename, btnNewButton);
		}
	}
	
	public void refresh() {
		Level level = new Level(0);
		
		for (String filename : getLevelButtons().keySet()) {
			if (disableLockedLevels){
				try {
					level = LevelSaver.levelFromJsonFile(filename, 0);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(this,
						    e.getMessage(),
						    "Error loading file",
						    JOptionPane.ERROR_MESSAGE);
				}
				getLevelButton(filename).setEnabled(!level.getLocked());
			}
		}
	}

	public HashMap<String, JButton> getLevelButtons() {
		return levelButtons;
	}

	public JButton getLevelButton(String filename) {
		return levelButtons.get(filename);
	}
	
	public JButton getMainMenuButton() {
		return btnBackToMain;
	}
}
