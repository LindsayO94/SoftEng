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
		
		BoardPanel panel = new BoardPanel();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblPuzzleLevel, GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStarPlaceholder)
								.addComponent(lblScore)
								.addComponent(lblMovesRemaining))
							.addGap(31))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
							.addGap(28)))
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(532, Short.MAX_VALUE)
					.addComponent(mainMenuButton, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPuzzleLevel)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(lblMovesRemaining)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblScore)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblStarPlaceholder)
							.addGap(54)
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnShuffle, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
							.addGap(114))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(mainMenuButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
