package game.boundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LevelSelectPanel extends JPanel {

	JButton mainMenuButton;
	JButton puzzle1;
	public LevelSelectPanel() {
		
		
		
		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblElimination = new JLabel("Elimination");
		lblElimination.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblRelease = new JLabel("Release");
		lblRelease.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		puzzle1 = new JButton("1");
		puzzle1.setBackground(Color.DARK_GRAY);
		puzzle1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		puzzle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton button = new JButton("2");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("3");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_2 = new JButton("4");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_3 = new JButton("5");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_4 = new JButton("1");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_5 = new JButton("2");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_6 = new JButton("3");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_7 = new JButton("4");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_8 = new JButton("5");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_9 = new JButton("1");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_10 = new JButton("2");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_11 = new JButton("3");
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_12 = new JButton("4");
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_13 = new JButton("5");
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_14 = new JButton("1");
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_15 = new JButton("2");
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_16 = new JButton("3");
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_17 = new JButton("4");
		button_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button_18 = new JButton("5");
		button_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSelectALevel = new JLabel("Select a Level!");
		lblSelectALevel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		mainMenuButton = new JButton("Main Menu");
		mainMenuButton.setBackground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(puzzle1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPuzzle, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblElimination, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_15, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_17, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_18, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_16, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addGap(128))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(mainMenuButton)
					.addGap(176)
					.addComponent(lblSelectALevel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblSelectALevel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(mainMenuButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuzzle, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblElimination)
						.addComponent(lblRelease))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(puzzle1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(button_15, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_16, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_17, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_18, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public JButton getPuzzle1Button(){
		return puzzle1;
	}
	
	public JButton getBackButton() {
		return mainMenuButton;
	}
	
}
