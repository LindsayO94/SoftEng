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

import common.boundary.BoardPanel;
import common.boundary.TilePanel;
import common.entity.Board;

@SuppressWarnings("serial")
public class PlayGamePanel extends JPanel {
	Board board;

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
		
		BoardPanel panel = new BoardPanel(board);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPuzzleLevel, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
							.addGap(35)
							.addComponent(mainMenuButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStarPlaceholder)
										.addComponent(lblScore)
										.addComponent(lblMovesRemaining))
									.addGap(3))
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
							.addGap(71)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(mainMenuButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPuzzleLevel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMovesRemaining)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblScore)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblStarPlaceholder)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
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
