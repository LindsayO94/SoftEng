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
import common.entity.Level;

import java.awt.Component;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PlayGamePanel extends JPanel {
	Level level;
	Board board;
	Game game;

	JButton mainMenuButton;
	JButton button_1;
	JButton btnRemove;
	JButton btnShuffle;
	JLabel lblPuzzleLevel;
	JLabel lblScore;
	private JLabel lblMovesRemaining;
	private JLabel labelStar1;
	
	public PlayGamePanel(Game game){	
		this.game = game;
		
		lblPuzzleLevel = new JLabel("Puzzle Level 1");
		lblPuzzleLevel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPuzzleLevel.setHorizontalAlignment(SwingConstants.CENTER);
		button_1 = new JButton("Swap");
		lblScore = new JLabel("Score: 1337");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMovesRemaining = new JLabel("Moves Remaining: 9001");
		lblMovesRemaining.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelStar1 = new JLabel("1");
		labelStar1.setIcon(new ImageIcon("Images/Star.png")); //AWESOME!
		labelStar1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		mainMenuButton = new JButton("Back to Main Menu!");
		
		btnRemove = new JButton("Remove");
		
		btnShuffle = new JButton("Shuffle");
		
		refresh();
	}
	
	// TODO: Some of this should probably be in the constructor
	public void refresh() {
		if (board == null) {
			return;
		}
		BoardPanel panel = new BoardPanel(board);
		
		JLabel lblMovesRemaining_1 = new JLabel("0 Moves Remaining");
		
		JLabel lblMovesRemaining_2 = new JLabel("2 Moves Remaining");
		
		JLabel lblMovesRemaing = new JLabel("4 Moves Remaining");
		
		JLabel labelStar2 = new JLabel("2");
		labelStar2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelStar2.setIcon(new ImageIcon("Images/Star.png")); //AWESOME! 2
		
		JLabel labelStar3 = new JLabel("3");
		labelStar3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelStar3.setIcon(new ImageIcon("Images/Star.png")); //AWESOME!3 
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblPuzzleLevel, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
					.addGap(35)
					.addComponent(mainMenuButton)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblScore)
						.addComponent(lblMovesRemaining)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(labelStar1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelStar2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelStar3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnShuffle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRemove, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMovesRemaining_2)
								.addComponent(lblMovesRemaining_1)
								.addComponent(lblMovesRemaing))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(mainMenuButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPuzzleLevel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMovesRemaining)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblScore)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelStar1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelStar2)
								.addComponent(labelStar3))
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemaining_1))
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemaining_2))
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemaing)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
					.addGap(62))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {labelStar1, labelStar2, labelStar3});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {labelStar1, labelStar2, labelStar3});
		setLayout(groupLayout);
	}



	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public JButton getBackButton() {
		return mainMenuButton;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
