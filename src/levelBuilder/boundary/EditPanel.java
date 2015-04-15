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

public class EditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	
	private JLabel lblLevel;
	
	JSpinner spinner;
	
	JToggleButton tglbtnNewToggleButton;
	
	JLabel lblAllowedMoves;
	
	JLabel lblNewLabel;
	JLabel lblNewLabel_2;
	
	JButton btnQuit;
	
	public EditPanel(){
		
		lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Puzzle", "Elimination", "Lightning", "Release"}));
		
		tglbtnNewToggleButton = new JToggleButton("");
		
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
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_7 = new JLabel("2");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_8 = new JLabel("3");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel label = new JLabel("1");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("3");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("4");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("5");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_6 = new JLabel("6");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JToggleButton toggleButton = new JToggleButton("");
		
		JToggleButton toggleButton_1 = new JToggleButton("");
		
		JLabel lblNewLabel_1 = new JLabel("Star Score Minimums");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_9 = new JLabel("1");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_11 = new JLabel("2");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_13 = new JLabel("3");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		JLabel label_10 = new JLabel("");
		
		JLabel lblShuffleBoard = new JLabel("Shuffle Board");
		lblShuffleBoard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRemoveTiles = new JLabel("Remove Tiles");
		lblRemoveTiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSwapTiles = new JLabel("Swap Tiles");
		lblSwapTiles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Save");
		
		btnQuit = new JButton("Quit");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_5)
										.addGap(44)
										.addComponent(label_7)
										.addGap(44)
										.addComponent(label_8)))
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addContainerGap(592, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(12)
								.addComponent(lblAllowedMoves)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGap(78)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton)
									.addComponent(btnQuit))
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_2)
								.addContainerGap(562, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label)
										.addGap(18)
										.addComponent(label_1)
										.addGap(18)
										.addComponent(label_2)
										.addGap(18)
										.addComponent(label_3)
										.addGap(18)
										.addComponent(label_4)
										.addGap(18)
										.addComponent(label_6)))
								.addGap(530))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(tglbtnNewToggleButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(label_10)
									.addComponent(lblShuffleBoard))
								.addContainerGap(541, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(toggleButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblRemoveTiles, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(506, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(toggleButton_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblSwapTiles, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addContainerGap(644, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_9)
									.addGap(44)
									.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)))
							.addGap(536))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAllowedMoves)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_6))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(label_7)
						.addComponent(label_8))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tglbtnNewToggleButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(toggleButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(toggleButton_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(12, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblShuffleBoard)
								.addComponent(label_10))
							.addGap(44)
							.addComponent(lblRemoveTiles, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(lblSwapTiles, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(35, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuit)
					.addContainerGap(437, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public void setBtnQuit(JButton btnQuit) {
		this.btnQuit = btnQuit;
	}
	
	
}
