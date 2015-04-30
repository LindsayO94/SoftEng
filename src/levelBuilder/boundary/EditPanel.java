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
import levelBuilder.controller.MultiplierFieldController;
import levelBuilder.controller.UndoController;
import levelBuilder.entity.LevelBuilder;


/**
 * Panel which displays visual elements of the editor
 * put all of the controllers under the "controllers go here" comment
 * @author August
 *
 */
public class EditPanel extends JPanel {
	private JTextField textField;
	private JTextField multiplierField_1;
	private JTextField multiplierField_2;
	private JTextField multiplierField_3;
	private JTextField probabilitieField_1;
	private JTextField probabilitieField_2;
	private JTextField probabilitieField_3;
	private JTextField probabilitieField_4;
	private JTextField probabilitieField_5;
	private JTextField probabilitieField_6;
	private JTextField scoreField_10;
	private JTextField scoreField_11;
	private JTextField scoreField_12;
	
	private JLabel lblLevel;
	
	JSpinner spinner;
	
	JLabel lblAllowedMoves;
	
	JLabel lblNewLabel;
	JLabel lblNewLabel_2;
	
	JButton btnQuit;
	private BoardPanel board;
	private JTextField shuffleField;
	private JTextField removeField;
	private JTextField swapField_15;
	private JButton btnPreview;
	private JTextField outputField;
	LevelBuilder editor;
	Level level;
	
	public EditPanel(Level level, LevelBuilder editor){
		this.level = level;
		this.editor = editor;
		
		lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Puzzle", "Elimination", "Lightning", "Release"}));
		GameTypeController gtc1 = new GameTypeController(this, editor);
		GameTypeController gtc2 = new GameTypeController(this, editor);

		
		
		lblAllowedMoves = new JLabel("Allowed Moves:");
		lblAllowedMoves.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setText("20");
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Tile Probabilities:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_2 = new JLabel("Multiplier Probabilites:");
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
		
		multiplierField_2 = new JTextField();
		multiplierField_2.setText("1");
		multiplierField_2.setColumns(10);
		
		multiplierField_3 = new JTextField();
		multiplierField_3.setText("1");
		multiplierField_3.setColumns(10);
		
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
		
		probabilitieField_2 = new JTextField();
		probabilitieField_2.setText("1");
		probabilitieField_2.setColumns(10);
		
		probabilitieField_3 = new JTextField();
		probabilitieField_3.setText("1");
		probabilitieField_3.setColumns(10);
		
		probabilitieField_4 = new JTextField();
		probabilitieField_4.setText("1");
		probabilitieField_4.setColumns(10);
		
		probabilitieField_5 = new JTextField();
		probabilitieField_5.setText("1");
		probabilitieField_5.setColumns(10);
		
		probabilitieField_6 = new JTextField();
		probabilitieField_6.setText("1");
		probabilitieField_6.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Star Score Minimums");
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
		
		scoreField_10 = new JTextField();
		scoreField_10.setText("1");
		scoreField_10.setColumns(10);
		
		scoreField_11 = new JTextField();
		scoreField_11.setText("1");
		scoreField_11.setColumns(10);
		
		scoreField_12 = new JTextField();
		scoreField_12.setText("1");
		scoreField_12.setColumns(10);
		
		JLabel label_10 = new JLabel("");
		
		JLabel lblShuffleBoard = new JLabel("Shuffle Board");
		lblShuffleBoard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRemoveTiles = new JLabel("Remove Tiles");
		lblRemoveTiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSwapTiles = new JLabel("Swap Tiles");
		lblSwapTiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Save");
		
		btnQuit = new JButton("Back");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		board = new BoardPanel(Board.makeBoard(level));

	
		
		shuffleField = new JTextField();
		shuffleField.setColumns(10);
		
		removeField = new JTextField();
		removeField.setColumns(10);
		
		swapField_15 = new JTextField();
		swapField_15.setColumns(10);
		
		JLabel lblNumberOfMoves = new JLabel("Number of Moves");
		
		btnPreview = new JButton("Preview");
		
		outputField = new JTextField();
		outputField.setColumns(10);
		
		JButton btnUndo = new JButton("Undo");
		
		
		/**
		 * controllers are added here
		 */
		
		int i = 0;
		for(Component c:spinner.getComponents()){
			System.out.println("Component: "+c.toString());
			if (i==0)
				c.addMouseListener(gtc1);
			else if (i==1)
				c.addMouseListener(gtc2);
			i++;
		}
		
		board.addMouseListener(new ChangeCellTypeController(board, editor));
		btnUndo.addMouseListener(new UndoController(this, editor));
		multiplierField_1.getDocument().addDocumentListener(new MultiplierFieldController(editor, multiplierField_1,0, this));
		
		
		
		
		
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
											.addComponent(lblAllowedMoves)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
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
													.addComponent(label_8))))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(140)
											.addComponent(label_10)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(shuffleField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
												.addComponent(removeField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(swapField_15, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNumberOfMoves, Alignment.LEADING)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(scoreField_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_9))
													.addGap(18)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(scoreField_11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addGap(2)
															.addComponent(scoreField_12, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
														.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)))
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(lblRemoveTiles, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblShuffleBoard)
													.addComponent(lblSwapTiles, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))))
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
										.addComponent(btnNewButton)))
								.addComponent(board, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnPreview))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnQuit)
										.addComponent(btnUndo))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblAllowedMoves)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblLevel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(spinner, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel)
							.addGap(12)
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
									.addComponent(scoreField_10, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scoreField_11, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scoreField_12, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(52)
									.addComponent(label_10))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(lblNumberOfMoves)
									.addGap(13)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblShuffleBoard)
										.addComponent(shuffleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(removeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRemoveTiles, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSwapTiles, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(swapField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(board, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(outputField)
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label_9, label_11, label_13, scoreField_10, scoreField_11, scoreField_12});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label_8, multiplierField_1, multiplierField_2, multiplierField_3, label_5, label_7});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label, label_1, label_2, label_3, label_4, label_6, probabilitieField_1, probabilitieField_2, probabilitieField_3, probabilitieField_4, probabilitieField_5, probabilitieField_6});
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
		return board;
	}
	
	public void refresh(){
		board.refresh();
		probabilitieField_1.setText("" + editor.getLevel().getFrequency(0));
		probabilitieField_2.setText("" + editor.getLevel().getFrequency(1));
		probabilitieField_3.setText("" + editor.getLevel().getFrequency(2));
		probabilitieField_4.setText("" + editor.getLevel().getFrequency(3));
		probabilitieField_5.setText("" + editor.getLevel().getFrequency(4));
		probabilitieField_6.setText("" + editor.getLevel().getFrequency(5));
		
		multiplierField_1.setText("" + editor.getLevel().getMultiplierFrequency(0));
		multiplierField_2.setText("" + editor.getLevel().getMultiplierFrequency(1));
		multiplierField_3.setText("" + editor.getLevel().getMultiplierFrequency(2));
		
		scoreField_10.setText("" + editor.getLevel().getStarScore(0));
		scoreField_10.setText("" + editor.getLevel().getStarScore(1));
		scoreField_10.setText("" + editor.getLevel().getStarScore(2));
		
		spinner.setValue(editor.getLevel().getType());
		
		shuffleField.setText("" + editor.getLevel().getNumShuffle());
		removeField.setText("" + editor.getLevel().getNumSwap());
		swapField_15.setText("" + editor.getLevel().getNumRemove());
		
	}
}
