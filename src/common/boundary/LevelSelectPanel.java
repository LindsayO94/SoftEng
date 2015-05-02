package common.boundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.SwingConstants;

import levelBuilder.controller.ChooseLevelButtonController;
import common.LevelSaver;

import javax.swing.ScrollPaneConstants;

/**
 * Main Menu Panel for level builder
 * @author August
 *
 */
public class LevelSelectPanel extends JPanel {
	HashMap<String, JButton> levelButtons = new HashMap<String, JButton>();
	private JButton btnBackToMain;

	public LevelSelectPanel(){
		setBackground(new Color(255, 204, 102));
		
		JLabel lblSixesWildLevel = new JLabel("Choose Level");
		lblSixesWildLevel.setBounds(304, 5, 205, 38);
		lblSixesWildLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSixesWildLevel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 32));
		
		JScrollPane puzzleScroll = new JScrollPane();
		puzzleScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		puzzleScroll.setBounds(35, 89, 150, 366);
		
		JScrollPane lightningScroll = new JScrollPane();
		lightningScroll.setBounds(220, 89, 150, 366);
		
		JScrollPane eliminationScroll = new JScrollPane();
		eliminationScroll.setBounds(405, 89, 150, 366);
		
		JScrollPane releaseScroll = new JScrollPane();
		releaseScroll.setBounds(590, 89, 150, 366);
		
		JPanel releasePanel = new JPanel();
		releaseScroll.setViewportView(releasePanel);
		releasePanel.setLayout(new BoxLayout(releasePanel, BoxLayout.Y_AXIS));
		
		JPanel eliminationPanel = new JPanel();
		eliminationScroll.setViewportView(eliminationPanel);
		eliminationPanel.setLayout(new BoxLayout(eliminationPanel, BoxLayout.Y_AXIS));
		
		JPanel lightningPanel = new JPanel();
		lightningScroll.setViewportView(lightningPanel);
		lightningPanel.setLayout(new BoxLayout(lightningPanel, BoxLayout.Y_AXIS));
		setLayout(null);
		
		JPanel puzzlePanel = new JPanel();
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
		btnBackToMain.setBounds(622, 5, 150, 29);
		add(btnBackToMain);
		
		for (String filename : LevelSaver.getLevelFilenames("Puzzle")) {
			JButton btnNewButton = new JButton(LevelSaver.filenameToLevelName(filename));
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			puzzlePanel.add(btnNewButton);
			levelButtons.put(filename, btnNewButton);
		}
		
		for (String filename : LevelSaver.getLevelFilenames("Lightning")) {
			JButton btnNewButton = new JButton(LevelSaver.filenameToLevelName(filename));
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			lightningPanel.add(btnNewButton);
			levelButtons.put(filename, btnNewButton);
		}
		
		for (String filename : LevelSaver.getLevelFilenames("Elimination")) {
			JButton btnNewButton = new JButton(LevelSaver.filenameToLevelName(filename));
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			eliminationPanel.add(btnNewButton);
			levelButtons.put(filename, btnNewButton);
		}
		
		for (String filename : LevelSaver.getLevelFilenames("Relase")) {
			JButton btnNewButton = new JButton(LevelSaver.filenameToLevelName(filename));
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			releasePanel.add(btnNewButton);
			levelButtons.put(filename, btnNewButton);
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
