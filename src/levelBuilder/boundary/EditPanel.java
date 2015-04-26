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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;

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
	
	JLabel lblAllowedMoves;
	
	JLabel lblNewLabel;
	JLabel lblNewLabel_2;
	
	JButton btnQuit;
	private BoardPanel board;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JButton btnPreview;
	private JTextField textField_16;
	
	public EditPanel(){
		
		lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Puzzle", "Elimination", "Lightning", "Release"}));
		
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
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
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
		
		btnQuit = new JButton("Back");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		board = new BoardPanel(null);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		JLabel lblNumberOfMoves = new JLabel("Number of Moves");
		
		btnPreview = new JButton("Preview");
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_16))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
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
													.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
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
												.addComponent(textField_13, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
												.addComponent(textField_14, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(textField_15, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
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
														.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_9))
													.addGap(18)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addGap(2)
															.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
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
									.addGap(106)
									.addComponent(btnPreview)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnQuit)
										.addComponent(btnNewButton)))
								.addComponent(board, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(54, Short.MAX_VALUE))
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
									.addComponent(btnQuit)
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
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
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
										.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRemoveTiles, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSwapTiles, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(board, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(textField_16, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label, label_1, label_2, label_3, label_4, label_6, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label_5, label_7, label_8, textField_7, textField_8, textField_9});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {label_9, label_11, label_13, textField_10, textField_11, textField_12});
		setLayout(groupLayout);
		
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public void setBtnQuit(JButton btnQuit) {
		this.btnQuit = btnQuit;
	}
}
