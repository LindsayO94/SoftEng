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
import javax.swing.text.PlainDocument;

import common.boundary.BoardPanel;
import common.boundary.CellPanel;
import common.entity.Board;
import common.entity.Cell;
import common.entity.Level;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Component;

import levelBuilder.LevelBuilderDocumentFilter;
import levelBuilder.controller.ChangeCellTypeController;
import levelBuilder.controller.GameTypeSpinnerController;
import levelBuilder.controller.MovesFieldController;
import levelBuilder.controller.MultiplierFieldController;
import levelBuilder.controller.PreviewController;
import levelBuilder.controller.RemoveFieldController;
import levelBuilder.controller.ShuffleFieldController;
import levelBuilder.controller.StarScoreFieldController;
import levelBuilder.controller.SwapFieldController;
import levelBuilder.controller.TileFieldContoller;
import levelBuilder.controller.TimeLimitFieldController;
import levelBuilder.controller.UndoButtonController;
import levelBuilder.entity.LevelBuilder;


/**
 * Panel which displays visual elements of the editor
 * put all of the controllers under the "controllers go here" comment
 * @author August, Lindsay
 *
 */
public class EditPanel extends JPanel {
	JTextField maxMovesField;
	JTextField multiplierField_1;
	JTextField multiplierField_2;
	JTextField multiplierField_3;
	JTextField probabilitieField_1;
	JTextField probabilitieField_2;
	JTextField probabilitieField_3;
	JTextField probabilitieField_4;
	JTextField probabilitieField_5;
	JTextField probabilitieField_6;
	JTextField scoreField_1;
	JTextField scoreField_2;
	JTextField scoreField_3;
	
	JLabel lblLevel;
	
	JSpinner spinner;
	
	JLabel lblAllowedMoves;
	
	JLabel lblNewLabel;
	JLabel lblNewLabel_2;
	
	JButton btnQuit;
	BoardPanel boardPanel;
	JTextField shuffleField;
	JTextField removeField;
	JTextField swapField;
	JButton btnPreview;
	JTextField outputField;
	LevelBuilder editor;
	JButton btnSave;
	JTextField timeLimitTextField;
	JLabel lblNewLabel_3;
	
	public EditPanel(LevelBuilder builder){
		this.editor = builder;
		this.boardPanel = new BoardPanel(builder.getBoard());
		
		lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner.setModel(new SpinnerListModel(new String[] {"Puzzle", "Elimination", "Lightning", "Release"}));
		GameTypeSpinnerController gtc1 = new GameTypeSpinnerController(this, builder);
		GameTypeSpinnerController gtc2 = new GameTypeSpinnerController(this, builder);

		
		
		lblAllowedMoves = new JLabel("Allowed Moves:");
		lblAllowedMoves.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		maxMovesField = new JTextField();
		maxMovesField.setText("20");
		((PlainDocument) maxMovesField.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		maxMovesField.setColumns(10);
		
		lblNewLabel = new JLabel("Tile Weighted Probabilities:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_2 = new JLabel("Multiplier Weighted Probabilities:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_5 = new JLabel("1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_7 = new JLabel("2");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_8 = new JLabel("3");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		multiplierField_1 = new JTextField();
		multiplierField_1.setText("1");
		multiplierField_1.setColumns(10);
		((PlainDocument) multiplierField_1.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		multiplierField_1.setText("" + editor.getLevel().getMultiplierFrequency(0));
		
		
		multiplierField_2 = new JTextField();
		multiplierField_2.setText("1");
		multiplierField_2.setColumns(10);
		((PlainDocument) multiplierField_2.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		multiplierField_2.setText("" + editor.getLevel().getMultiplierFrequency(1));
	
		
		multiplierField_3 = new JTextField();
		multiplierField_3.setText("1");
		multiplierField_3.setColumns(10);
		((PlainDocument) multiplierField_3.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		multiplierField_3.setText("" + editor.getLevel().getMultiplierFrequency(2));
		
		JLabel label = new JLabel("1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("2");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("3");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("4");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("5");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_6 = new JLabel("6");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		probabilitieField_1 = new JTextField();
		probabilitieField_1.setText("1");
		probabilitieField_1.setColumns(10);
		((PlainDocument) probabilitieField_1.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		probabilitieField_1.setText("" + editor.getLevel().getFrequency(0));

		
		probabilitieField_2 = new JTextField();
		probabilitieField_2.setText("1");
		probabilitieField_2.setColumns(10);
		((PlainDocument) probabilitieField_2.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		probabilitieField_2.setText("" + editor.getLevel().getFrequency(1));

		
		probabilitieField_3 = new JTextField();
		probabilitieField_3.setText("1");
		probabilitieField_3.setColumns(10);
		((PlainDocument) probabilitieField_3.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		probabilitieField_3.setText("" + editor.getLevel().getFrequency(2));

		
		probabilitieField_4 = new JTextField();
		probabilitieField_4.setText("1");
		probabilitieField_4.setColumns(10);
		((PlainDocument) probabilitieField_4.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		probabilitieField_4.setText("" + editor.getLevel().getFrequency(3));

		
		probabilitieField_5 = new JTextField();
		probabilitieField_5.setText("1");
		probabilitieField_5.setColumns(10);
		((PlainDocument) probabilitieField_5.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		probabilitieField_5.setText("" + editor.getLevel().getFrequency(4));

		
		probabilitieField_6 = new JTextField();
		probabilitieField_6.setText("1");
		probabilitieField_6.setColumns(10);
		((PlainDocument) probabilitieField_6.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		probabilitieField_6.setText("" + editor.getLevel().getFrequency(5));
		
		JLabel lblNewLabel_1 = new JLabel("Star Score Thresholds:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_9 = new JLabel("1");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_11 = new JLabel("2");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_13 = new JLabel("3");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scoreField_1 = new JTextField();
		scoreField_1.setText("1");
		scoreField_1.setColumns(10);
		((PlainDocument) scoreField_1.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		scoreField_1.setText("" + editor.getLevel().getStarScore(0));

		
		scoreField_2 = new JTextField();
		scoreField_2.setText("1");
		scoreField_2.setColumns(10);
		((PlainDocument) scoreField_2.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		scoreField_2.setText("" + editor.getLevel().getStarScore(1));

		
		scoreField_3 = new JTextField();
		scoreField_3.setText("1");
		scoreField_3.setColumns(10);
		((PlainDocument) scoreField_3.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		scoreField_3.setText("" + editor.getLevel().getStarScore(2));
		
		JLabel label_10 = new JLabel("");
		
		JLabel lblShuffleBoard = new JLabel("Shuffle Board");
		lblShuffleBoard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRemoveTiles = new JLabel("Remove Tiles");
		lblRemoveTiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSwapTiles = new JLabel("Swap Tiles");
		lblSwapTiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		
		btnQuit = new JButton("Back");
		
		shuffleField = new JTextField();
		shuffleField.setColumns(10);
		((PlainDocument) shuffleField.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		shuffleField.setText("" + editor.getLevel().getNumShuffle());

		
		removeField = new JTextField();
		removeField.setColumns(10);
		((PlainDocument) removeField.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		removeField.setText("" + editor.getLevel().getNumSwap());

		
		swapField = new JTextField();
		swapField.setColumns(10);
		((PlainDocument) swapField.getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		swapField.setText("" + editor.getLevel().getNumRemove());
		
		JLabel lblNumberOfMoves = new JLabel("Number of Moves");
		lblNumberOfMoves.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnPreview = new JButton("Preview");
		
		outputField = new JTextField();
		outputField.setEditable(false);
		outputField.setColumns(10);
		
		JButton btnUndo = new JButton("Undo");
		
		setTimeLimitTextField(new JTextField());
		getTimeLimitTextField().setColumns(10);
		((PlainDocument) getTimeLimitTextField().getDocument()).setDocumentFilter(new LevelBuilderDocumentFilter());
		getTimeLimitTextField().setText("" + editor.getLevel().getMaxTime());
		
		//Sets enabled and disabled text fields based on level type being loaded.
		if (editor.getLevel().getType().equals("Lightning")){
			getTimeLimitTextField().setEnabled(true);
			maxMovesField.setEnabled(false);
			shuffleField.setEnabled(true);
			removeField.setEnabled(true);
			swapField.setEnabled(true);
			probabilitieField_6.setEnabled(true);
		}
		else if(editor.getLevel().getType().equals("Release")){
			shuffleField.setEnabled(false);
			removeField.setEnabled(false);
			swapField.setEnabled(false);
			getTimeLimitTextField().setEnabled(false);
			maxMovesField.setEnabled(true);
			probabilitieField_6.setText("0");
			probabilitieField_6.setEnabled(false);
		}
		else{
			getTimeLimitTextField().setEnabled(false);
			maxMovesField.setEnabled(true);
			shuffleField.setEnabled(true);
			removeField.setEnabled(true);
			swapField.setEnabled(true);
			probabilitieField_6.setEnabled(true);
		}
		
		lblNewLabel_3 = new JLabel("Time Limit:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		/**
		 * controllers are added here
		 */
		
		int i = 0;
		for(Component c:spinner.getComponents()){
//			System.out.println("Component: "+c.toString());
			if (i==0)
				c.addMouseListener(gtc1);
			else if (i==1)
				c.addMouseListener(gtc2);
			i++;
		}
		
		boardPanel.addMouseListener(new ChangeCellTypeController(this, builder));
		btnUndo.addMouseListener(new UndoButtonController(this, builder));
		btnPreview.addMouseListener(new PreviewController(this, builder));
		
		
		multiplierField_1.getDocument().addUndoableEditListener(new MultiplierFieldController(builder, multiplierField_1,0, this));
		multiplierField_2.getDocument().addUndoableEditListener(new MultiplierFieldController(builder, multiplierField_2,1, this));
		multiplierField_3.getDocument().addUndoableEditListener(new MultiplierFieldController(builder, multiplierField_3,2, this));
		
		probabilitieField_1.getDocument().addUndoableEditListener(new TileFieldContoller(builder, probabilitieField_1,0, this));
		probabilitieField_2.getDocument().addUndoableEditListener(new TileFieldContoller(builder, probabilitieField_2,1, this));
		probabilitieField_3.getDocument().addUndoableEditListener(new TileFieldContoller(builder, probabilitieField_3,2, this));
		probabilitieField_4.getDocument().addUndoableEditListener(new TileFieldContoller(builder, probabilitieField_4,3, this));
		probabilitieField_5.getDocument().addUndoableEditListener(new TileFieldContoller(builder, probabilitieField_5,4, this));
		probabilitieField_6.getDocument().addUndoableEditListener(new TileFieldContoller(builder, probabilitieField_6,5, this));
		
		scoreField_1.getDocument().addUndoableEditListener(new StarScoreFieldController(builder, scoreField_1,0, this));
		scoreField_2.getDocument().addUndoableEditListener(new StarScoreFieldController(builder, scoreField_2,1, this));
		scoreField_3.getDocument().addUndoableEditListener(new StarScoreFieldController(builder, scoreField_3,2, this));
		
		shuffleField.getDocument().addUndoableEditListener(new ShuffleFieldController(builder, shuffleField, this));
		swapField.getDocument().addUndoableEditListener(new SwapFieldController(builder, swapField, this));
		removeField.getDocument().addUndoableEditListener(new RemoveFieldController(builder, removeField, this));
		
		maxMovesField.getDocument().addUndoableEditListener(new MovesFieldController(builder, maxMovesField, this));
		
		getTimeLimitTextField().getDocument().addUndoableEditListener(new TimeLimitFieldController(builder, getTimeLimitTextField(), this));
		
	
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(outputField, 702, 702, 702))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(140)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(label_10)
												.addComponent(swapField, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
												.addComponent(removeField)
												.addComponent(shuffleField)
												.addComponent(lblNumberOfMoves, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addComponent(lblNewLabel_1)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(scoreField_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_9))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(scoreField_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(2)
													.addComponent(scoreField_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
												.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblNewLabel_2)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(multiplierField_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(multiplierField_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(multiplierField_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(label_5)
													.addGap(18)
													.addComponent(label_7)
													.addGap(18)
													.addComponent(label_8))))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(20)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblRemoveTiles, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblShuffleBoard)
										.addComponent(lblSwapTiles, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(probabilitieField_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(probabilitieField_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(probabilitieField_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(probabilitieField_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(probabilitieField_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(probabilitieField_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblAllowedMoves)
										.addComponent(lblNewLabel_3))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)

										.addComponent(getTimeLimitTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(maxMovesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(88)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnPreview)
										.addComponent(btnUndo))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnQuit)
										.addComponent(btnSave)))
								.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(148, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSave)
								.addComponent(btnPreview))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnQuit)
								.addComponent(btnUndo)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblLevel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(spinner, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAllowedMoves)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(maxMovesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(getTimeLimitTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3))))
							.addGap(18)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3)
								.addComponent(label_4)
								.addComponent(label_6))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(probabilitieField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(probabilitieField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(probabilitieField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(probabilitieField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(probabilitieField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(probabilitieField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(label_7)
								.addComponent(label_8))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(multiplierField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(multiplierField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(multiplierField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scoreField_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scoreField_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scoreField_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_10)
								.addComponent(lblNumberOfMoves))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblShuffleBoard)
								.addComponent(shuffleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRemoveTiles, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(removeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSwapTiles, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(swapField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(outputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label_9, label_11, label_13, scoreField_1, scoreField_2, scoreField_3});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label_5, label_7, label_8, multiplierField_1, multiplierField_2, multiplierField_3});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label, label_1, label_2, label_3, label_4, label_6, probabilitieField_1, probabilitieField_2, probabilitieField_3, probabilitieField_4, probabilitieField_5, probabilitieField_6});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label_5, label_7, label_8, multiplierField_1, multiplierField_2, multiplierField_3});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label_9, label_11, label_13, scoreField_1, scoreField_2, scoreField_3});
		setLayout(groupLayout);
		
		this.refresh();
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public void setBtnQuit(JButton btnQuit) {
		this.btnQuit = btnQuit;
	}
	
	public JSpinner getSpinner(){
		return spinner;
	}
	
	public BoardPanel getBoard(){
		return boardPanel;
	}
	
	public JTextField getTimeLimitText(){
		return getTimeLimitTextField();
	}
	
	public JTextField getOutputField() {
		return outputField;
	}
	
	public void refresh(){
		
		try {
			boardPanel.refresh();
			outputField.setText("");
		}catch (IllegalStateException e){
			outputField.setText("Too many baskets in one column!");
		}catch (IllegalArgumentException e){
			outputField.setText("Must have at least one positive weight.");
		}
		
		int star1 = boardPanel.getBoardModel().getLevel().getStar1Score();
		int star2 = boardPanel.getBoardModel().getLevel().getStar2Score();
		int star3 = boardPanel.getBoardModel().getLevel().getStar3Score();
		
		if ((star1 > star2)||(star2 > star3)){
			outputField.setText("Star scores must increase from 1 star to 3 stars.");
		}
		
		spinner.setValue(editor.getLevel().getType());
		btnSave.setEnabled(false);
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public JTextField getMovesAllowed() {
		// TODO Auto-generated method stub
		return maxMovesField;
	}

	public JTextField getShuffle() {
		// TODO Auto-generated method stub
		return shuffleField;
	}
	
	public JTextField getRemove() {
		return removeField;
	}
	
	public JButton getSaveButton(){
		return btnSave;
	}
	
	public JTextField getSwap() {
		return swapField;
	}
	
	public JTextField getSixProbabilityField() {
		return probabilitieField_6;
	}
	
	public JTextField getTimeLimitTextField() {
		return timeLimitTextField;
	}

	public void setTimeLimitTextField(JTextField timeLimitTextField) {
		this.timeLimitTextField = timeLimitTextField;
	}

	public void dispose(){
		maxMovesField = null;
		multiplierField_1  = null;
		multiplierField_2  = null;
		multiplierField_3  = null;
		probabilitieField_1  = null;
		probabilitieField_2  = null;
		probabilitieField_3  = null;
		probabilitieField_4  = null;
		probabilitieField_5  = null;
		probabilitieField_6 = null;
		scoreField_1  = null;
		scoreField_2  = null;
		scoreField_3  = null;
		
		lblLevel  = null;
		
		JSpinner spinner  = null;
		
		JLabel lblAllowedMoves  = null;
		
		JLabel lblNewLabel  = null;
		JLabel lblNewLabel_2  = null;
		
		JButton btnQuit;
		boardPanel  = null;
		shuffleField  = null;
		removeField  = null;
		swapField  = null;
		btnPreview  = null;
		outputField  = null;
		
		editor = null;
		btnSave  = null;
		setTimeLimitTextField(null);
		lblNewLabel_3  = null;
	}

	public JTextField getMaxMovesTextField() {
		return maxMovesField;
	}
	
}
