package game.boundary;

import java.awt.Graphics;

import game.controller.CellSelectController;
import game.controller.SelectController;
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
import common.entity.Cell;
import common.entity.Level;

import java.awt.Component;
import java.util.Timer;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PlayGamePanel extends JPanel {
	Level level;
	Board board;
	Game game;
	Cell cell;
	
	
	String inactivePath = "Images/InactiveStar.png";
	String activePath = "Images/Star.png";

	JButton mainMenuButton;
	JButton button_1;
	JButton btnRemove;
	JButton btnShuffle;
	JLabel lblPuzzleLevel;
	JLabel lblScore;
	private JLabel lblMovesRemaining;
	private JLabel labelStar1;
	private JLabel labelStar2;
	private JLabel labelStar3;
	private JLabel lblMovesRemaining_Shuffle;
	private JLabel lblNumber;
	
	public PlayGamePanel(Game game){	
		this.game = game;
		
		lblPuzzleLevel = new JLabel("");
		lblPuzzleLevel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPuzzleLevel.setHorizontalAlignment(SwingConstants.CENTER);
		button_1 = new JButton("Swap");
		lblScore = new JLabel("Score: 1337");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMovesRemaining = new JLabel("Moves Remaining: 9001");
		lblMovesRemaining.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelStar1 = new JLabel("1");
		labelStar1.setIcon(new ImageIcon(inactivePath)); //AWESOME!
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
		
		lblPuzzleLevel.setText(board.getLevel().getType()+" Level "+board.getLevel().getNumber());
		panel.addMouseMotionListener(new SelectController(panel, game));
		panel.addMouseListener(new SelectController(panel, game));
		
		JLabel lblMovesRemaining_Swap = new JLabel("0");
		lblMovesRemaining_Swap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovesRemaining_Swap.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblMovesRemaining_Remove = new JLabel("2");
		lblMovesRemaining_Remove.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMovesRemaining_Remove.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblMovesRemaining_Shuffle = new JLabel("4");
		lblMovesRemaining_Shuffle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovesRemaining_Shuffle.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		labelStar2 = new JLabel("2");
		labelStar2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelStar2.setIcon(new ImageIcon(inactivePath)); //AWESOME! 2
		
		labelStar3 = new JLabel("3");
		labelStar3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelStar3.setIcon(new ImageIcon(inactivePath)); //AWESOME!3 
		
		JLabel lblTimeLeft = new JLabel("Time Left:");
		lblTimeLeft.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNumber = new JLabel("NUM");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblScore)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnShuffle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblMovesRemaining_Remove, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(lblMovesRemaining_Swap, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(lblMovesRemaining_Shuffle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
						.addComponent(lblMovesRemaining)
						.addComponent(mainMenuButton)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTimeLeft)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(labelStar1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(labelStar2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(labelStar3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPuzzleLevel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
					.addGap(126))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPuzzleLevel)
						.addComponent(mainMenuButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMovesRemaining)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblScore)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelStar1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelStar2)
								.addComponent(labelStar3))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTimeLeft)
								.addComponent(lblNumber))
							.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemaining_Swap))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemaining_Remove))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemaining_Shuffle, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(24))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
	
	public JLabel getStar(int starNum){
		switch(starNum){
		case 1:
			return labelStar1;
		case 2:
			return labelStar2;
		case 3:
			return labelStar3;
		}
		return null;
	}
}
