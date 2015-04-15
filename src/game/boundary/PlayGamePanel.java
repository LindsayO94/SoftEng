package game.boundary;

import java.awt.Graphics;

import game.entities.Game;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PlayGamePanel extends JPanel {

	JButton mainMenuButton;
	public PlayGamePanel(Game game){
		JLabel lblPuzzleLevel = new JLabel("Puzzle Level 1");
		lblPuzzleLevel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPuzzleLevel.setHorizontalAlignment(SwingConstants.CENTER);
		JButton button_1 = new JButton("Swap");
		JLabel lblScore = new JLabel("Score: 1337");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JLabel lblMovesRemaining = new JLabel("Moves Remaining: 9001");
		lblMovesRemaining.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JLabel lblStarPlaceholder = new JLabel("Star Placeholder");
		lblStarPlaceholder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		mainMenuButton = new JButton("Back to Main Menu!");
		
		JButton btnRemove = new JButton("Remove");
		
		JButton btnShuffle = new JButton("Shuffle");
		
		JLabel lblNewLabel = new JLabel("This is such a great placeholder for a board. Man, I sure hope that one day a board will be placed here so that we can revel in the glory of this placeholder. None of it would have been possible without him, and for that we thank him. Praise the board placeholder for all of eternity! May we Hold our praise for Him in its rightful Place.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStarPlaceholder)
						.addComponent(lblScore)
						.addComponent(lblMovesRemaining))
					.addGap(70)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 494, Short.MAX_VALUE)
					.addGap(55))
				.addComponent(lblPuzzleLevel, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addGap(617))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(595, Short.MAX_VALUE)
					.addComponent(mainMenuButton, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPuzzleLevel)
							.addGap(19)
							.addComponent(lblMovesRemaining)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblScore)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblStarPlaceholder)
							.addGap(54)
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnShuffle, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
							.addGap(33))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainMenuButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		setLayout(groupLayout);
		
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public JButton getBackButton() {
		return mainMenuButton;
	}
	
}
