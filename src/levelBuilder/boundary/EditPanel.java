package levelBuilder.boundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;

import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.entity.Board;
import common.entity.Cell;
import common.entity.Level;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Component;

import levelBuilder.controller.ChangeCellTypeController;
import levelBuilder.controller.GameTypeController;
import levelBuilder.controller.UndoController;
import levelBuilder.entity.LevelBuilder;


/**
 * Panel which displays visual elements of the editor
 * @author August
 *
 */
public class EditPanel extends JPanel {
	// Other LevelBuilder objects
	BoardPanel boardPanel;
	LevelBuilder editor;
	
	// Fields on the left of the builder
	JSpinner levelTypeSpinner;
	
	JTextField allowedMovesField;
	
	JTextField tileOnesWeightField;
	JTextField tileTwosWeightField;
	JTextField tileThreesWeightField;
	JTextField tileFoursWeightField;
	JTextField tileFivesWeightField;
	JTextField tileSixesWeightField;
	
	JTextField multiplier1xWeightField;
	JTextField multiplier2xWeightField;
	JTextField multiplier3xWeightField;
	
	JTextField oneStarThresholdField;
	JTextField twoStarThresholdField;
	JTextField threeStarThresholdField;

	JTextField shuffleBoardMovesField;
	JTextField removeTilesMovesField;
	JTextField swapTilesMovesField;
	
	// Buttons
	JButton btnQuit;
	JButton btnPreview;
	JButton saveBtn;
	
	// Error output
	JTextField errorOutputField;
	JButton btnUndo;
	
	public EditPanel(LevelBuilder editor){
		this.editor = editor;
		this.boardPanel = new BoardPanel(editor.getBoard());
		
		// HERE THERE BE WINDOWBUILDER - Controllers are after WindowBuilder
		JLabel levelLabel = new JLabel("Level");
		levelLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		levelTypeSpinner = new JSpinner();
		levelTypeSpinner.setModel(new SpinnerListModel(new String[] {"Puzzle", "Elimination", "Lightning", "Release"}));
		
		JLabel allowedMovesLabel = new JLabel("Allowed Moves:");
		allowedMovesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		allowedMovesField = new JTextField();
		allowedMovesField.setText("20");
		allowedMovesField.setColumns(10);
		
		JLabel tileWeightsLabel = new JLabel("Tile Probability Weights:");
		tileWeightsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel multiplierProbabilitiesLabel = new JLabel("Multiplier Probability Weights:");
		multiplierProbabilitiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel multiplier1xWeightLabel = new JLabel("1");
		multiplier1xWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		multiplier1xWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel multiplier2xWeightLabel = new JLabel("2");
		multiplier2xWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		multiplier2xWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel multiplier3xWeightLabel = new JLabel("3");
		multiplier3xWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		multiplier3xWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		multiplier1xWeightField = new JTextField();
		multiplier1xWeightField.setText("1");
		multiplier1xWeightField.setColumns(10);
		
		multiplier2xWeightField = new JTextField();
		multiplier2xWeightField.setText("1");
		multiplier2xWeightField.setColumns(10);
		
		multiplier3xWeightField = new JTextField();
		multiplier3xWeightField.setText("1");
		multiplier3xWeightField.setColumns(10);
		
		JLabel tileOnesWeightLabel = new JLabel("1");
		tileOnesWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tileOnesWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel tileTwosWeightLabel = new JLabel("2");
		tileTwosWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tileTwosWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel tileThreesWeightLabel = new JLabel("3");
		tileThreesWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tileThreesWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel tileFoursWeightLabel = new JLabel("4");
		tileFoursWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tileFoursWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel tileFivesWeightLabel = new JLabel("5");
		tileFivesWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tileFivesWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel tileSixesWeightLabel = new JLabel("6");
		tileSixesWeightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tileSixesWeightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tileOnesWeightField = new JTextField();
		tileOnesWeightField.setText("1");
		tileOnesWeightField.setColumns(10);
		
		tileTwosWeightField = new JTextField();
		tileTwosWeightField.setText("1");
		tileTwosWeightField.setColumns(10);
		
		tileThreesWeightField = new JTextField();
		tileThreesWeightField.setText("1");
		tileThreesWeightField.setColumns(10);
		
		tileFoursWeightField = new JTextField();
		tileFoursWeightField.setText("1");
		tileFoursWeightField.setColumns(10);
		
		tileFivesWeightField = new JTextField();
		tileFivesWeightField.setText("1");
		tileFivesWeightField.setColumns(10);
		
		tileSixesWeightField = new JTextField();
		tileSixesWeightField.setText("1");
		tileSixesWeightField.setColumns(10);
		
		JLabel starScoreThresholdsLabel = new JLabel("Star Score Minimums");
		starScoreThresholdsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel oneStarThresholdLabel = new JLabel("1");
		oneStarThresholdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oneStarThresholdLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel twoStarThresholdLabel = new JLabel("2");
		twoStarThresholdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		twoStarThresholdLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel threeStarThresholdLabel = new JLabel("3");
		threeStarThresholdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		threeStarThresholdLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		oneStarThresholdField = new JTextField();
		oneStarThresholdField.setText("1");
		oneStarThresholdField.setColumns(10);
		
		twoStarThresholdField = new JTextField();
		twoStarThresholdField.setText("1");
		twoStarThresholdField.setColumns(10);
		
		threeStarThresholdField = new JTextField();
		threeStarThresholdField.setText("1");
		threeStarThresholdField.setColumns(10);
		
		JLabel shuffleBoardMovesLabel = new JLabel("Shuffle Board");
		shuffleBoardMovesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel removeTilesMovesLabel = new JLabel("Remove Tiles");
		removeTilesMovesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel swapTilesMovesLabel = new JLabel("Swap Tiles");
		swapTilesMovesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		shuffleBoardMovesField = new JTextField();
		shuffleBoardMovesField.setColumns(10);
		
		removeTilesMovesField = new JTextField();
		removeTilesMovesField.setColumns(10);
		
		swapTilesMovesField = new JTextField();
		swapTilesMovesField.setColumns(10);
		
		JLabel specalMovesNumLabel = new JLabel("Number of Moves");
		
		saveBtn = new JButton("Save");
		btnQuit = new JButton("Back");
		btnPreview = new JButton("Preview");
		btnUndo = new JButton("Undo");
		
		errorOutputField = new JTextField();
		errorOutputField.setEditable(false);
		errorOutputField.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(errorOutputField, 702, 702, 702))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(allowedMovesLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(allowedMovesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(multiplierProbabilitiesLabel)
										.addComponent(tileWeightsLabel)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(tileOnesWeightLabel)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileTwosWeightLabel)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileThreesWeightLabel)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileFoursWeightLabel)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileFivesWeightLabel)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileSixesWeightLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(tileOnesWeightField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileTwosWeightField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileThreesWeightField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileFoursWeightField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileFivesWeightField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(tileSixesWeightField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(multiplier1xWeightField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(multiplier2xWeightField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(multiplier3xWeightField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(multiplier1xWeightLabel)
													.addGap(18)
													.addComponent(multiplier2xWeightLabel)
													.addGap(18)
													.addComponent(multiplier3xWeightLabel))))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(146)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(shuffleBoardMovesField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
												.addComponent(removeTilesMovesField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(swapTilesMovesField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
												.addComponent(specalMovesNumLabel, Alignment.LEADING)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(starScoreThresholdsLabel)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(oneStarThresholdField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addComponent(oneStarThresholdLabel))
													.addGap(18)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(twoStarThresholdField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addComponent(twoStarThresholdLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addGap(2)
															.addComponent(threeStarThresholdField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
														.addComponent(threeStarThresholdLabel, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)))
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(removeTilesMovesLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
													.addComponent(shuffleBoardMovesLabel)
													.addComponent(swapTilesMovesLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(levelTypeSpinner, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(levelLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(88)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnPreview)
										.addComponent(btnUndo))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnQuit)
										.addComponent(saveBtn)))
								.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(saveBtn)
								.addComponent(btnPreview))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnQuit)
										.addComponent(btnUndo))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(allowedMovesLabel)
									.addComponent(allowedMovesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(levelLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(levelTypeSpinner, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(tileWeightsLabel)
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tileOnesWeightLabel)
								.addComponent(tileTwosWeightLabel)
								.addComponent(tileThreesWeightLabel)
								.addComponent(tileFoursWeightLabel)
								.addComponent(tileFivesWeightLabel)
								.addComponent(tileSixesWeightLabel))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tileOnesWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tileTwosWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tileThreesWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tileFoursWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tileFivesWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tileSixesWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(multiplierProbabilitiesLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(multiplier1xWeightLabel)
								.addComponent(multiplier2xWeightLabel)
								.addComponent(multiplier3xWeightLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(multiplier1xWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(multiplier2xWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(multiplier3xWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(starScoreThresholdsLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(oneStarThresholdLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(oneStarThresholdField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(twoStarThresholdLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(twoStarThresholdField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(threeStarThresholdLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(threeStarThresholdField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addGap(12)
							.addComponent(specalMovesNumLabel)
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(shuffleBoardMovesLabel)
								.addComponent(shuffleBoardMovesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(removeTilesMovesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(removeTilesMovesLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(swapTilesMovesLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(swapTilesMovesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(errorOutputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {tileOnesWeightLabel, tileTwosWeightLabel, tileThreesWeightLabel, tileFoursWeightLabel, tileFivesWeightLabel, tileSixesWeightLabel, tileOnesWeightField, tileTwosWeightField, tileThreesWeightField, tileFoursWeightField, tileFivesWeightField, tileSixesWeightField});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {multiplier1xWeightLabel, multiplier2xWeightLabel, multiplier3xWeightLabel, multiplier1xWeightField, multiplier2xWeightField, multiplier3xWeightField});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {oneStarThresholdLabel, twoStarThresholdLabel, threeStarThresholdLabel, oneStarThresholdField, twoStarThresholdField, threeStarThresholdField});
		setLayout(groupLayout);
		// END WINDOWBUILDER

		
		/**
		 * controllers are added here
		 */
		boardPanel.addMouseListener(new ChangeCellTypeController(boardPanel, editor));
		btnUndo.addMouseListener(new UndoController(boardPanel, editor));
		
		GameTypeController gtc1 = new GameTypeController(this, editor, null);
		GameTypeController gtc2 = new GameTypeController(this, editor, gtc1);
		gtc1.setOtherController(gtc2);
		int i = 0;
		for(Component c:levelTypeSpinner.getComponents()){
			System.out.println("Component: "+c.toString());
			if (i==0)
				c.addMouseListener(gtc1);
			else if (i==1)
				c.addMouseListener(gtc2);
			i++;
		}
		
		this.refresh();
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public void setBtnQuit(JButton btnQuit) {
		this.btnQuit = btnQuit;
	}
	
	public JSpinner getSpinner(){
		return levelTypeSpinner;
	}
	
	public BoardPanel getBoardPanel(){
		return boardPanel;
	}
	
	public void refresh(){
		boardPanel.refresh();
		
		tileOnesWeightField.setText("" + editor.getLevel().getFrequency(0));
		tileTwosWeightField.setText("" + editor.getLevel().getFrequency(1));
		tileThreesWeightField.setText("" + editor.getLevel().getFrequency(2));
		tileFoursWeightField.setText("" + editor.getLevel().getFrequency(3));
		tileFivesWeightField.setText("" + editor.getLevel().getFrequency(4));
		tileSixesWeightField.setText("" + editor.getLevel().getFrequency(5));
		
		multiplier1xWeightField.setText("" + editor.getLevel().getMultiplierFrequency(0));
		multiplier2xWeightField.setText("" + editor.getLevel().getMultiplierFrequency(1));
		multiplier3xWeightField.setText("" + editor.getLevel().getMultiplierFrequency(2));
		
		oneStarThresholdField.setText("" + editor.getLevel().getStarScore(0));
		oneStarThresholdField.setText("" + editor.getLevel().getStarScore(1));
		oneStarThresholdField.setText("" + editor.getLevel().getStarScore(2));
		
		levelTypeSpinner.setValue(editor.getLevel().getType());
		
		shuffleBoardMovesField.setText("" + editor.getLevel().getNumShuffle());
		removeTilesMovesField.setText("" + editor.getLevel().getNumSwap());
		swapTilesMovesField.setText("" + editor.getLevel().getNumRemove());
		
	}

	public JButton getBtnSave() {
		return saveBtn;
	}
}
