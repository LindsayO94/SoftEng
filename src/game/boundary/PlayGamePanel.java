package game.boundary;

import java.awt.Graphics;

import game.controller.CellSelectController;
import game.controller.SelectController;
import game.entities.Game;

import javax.swing.JComponent;
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
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class PlayGamePanel extends JPanel {
	Level level;
	Board board;
	Game game;
	Cell cell;
	
	String inactivePath = "Images/InactiveStar.png";
	String activePath = "Images/Star.png";

	JButton mainMenuButton;
	
	JToggleButton btnSwap;
	JToggleButton btnRemove;
	//the shuffle button doesn't need to be toggled because there is no selection that needs to be made. 
	//So we can just use a regular button. 
	JButton btnShuffle; 
	
	JLabel lblPuzzleLevel;
	JLabel lblScore;
	
	private JLabel lblMovesRemaining;
	private JLabel labelStar1;
	private JLabel labelStar2;
	private JLabel labelStar3;
	
	//TODO eventually will combine these when i feel like it
	private JLabel lblTimeLeft;
	private JLabel lblTimeLeftValue;
	
	private JLabel lblMovesRemainingSwap;
	private JLabel lblMovesRemainingRemove;
	private JLabel lblMovesRemainingShuffle;
	
	
	public PlayGamePanel(Game game){	
		this.game = game;
		
		mainMenuButton = new JButton("Back to Main Menu!");
		
		lblPuzzleLevel = new JLabel("");
		lblPuzzleLevel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPuzzleLevel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblScore = new JLabel("Score: <NUM>");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblMovesRemaining = new JLabel("Moves Remaining: <NUM>");
		lblMovesRemaining.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		labelStar1 = new JLabel("1");
		labelStar1.setIcon(new ImageIcon(inactivePath)); //AWESOME!
		labelStar1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		lblTimeLeft = new JLabel("Time Left:");
		lblTimeLeftValue = new JLabel("<NUM>");
		
		btnSwap = new JToggleButton("Swap");
		btnRemove = new JToggleButton("Remove");
		btnShuffle = new JButton("Shuffle"); 
		
		//Special Moves
		lblMovesRemainingSwap = new JLabel("<SWAP>");
		lblMovesRemainingRemove = new JLabel("<REMOVE>");
		lblMovesRemainingShuffle = new JLabel("<SHUFFLE>");
		
		refresh();
	}
	
	
	
	// TODO: Some of this should probably be in the constructor
	public void refresh() {
		if (board == null) {
			return;
		}
		BoardPanel panel = new BoardPanel(board);
		
		//Set up Title...and put a mouse listener on it? TODO
		lblPuzzleLevel.setText(board.getLevel().getType()+" Level "+board.getLevel().getNumber());
		panel.addMouseMotionListener(new SelectController(panel, game));
		panel.addMouseListener(new SelectController(panel, game));
		
		lblTimeLeftValue.setVisible(true);
		lblTimeLeft.setVisible(true);
		
		//If it's not lightning, hide the time stuff. TODO Probably should go in constructor
		//TODO Why doesn't this work?
		System.out.println("Accessed board type is: " + board.getLevel().getType());
		System.out.println("Accessed board type equals Lightning:");
		System.out.println(board.getLevel().getType().equals("Lightning"));
		
		//TODO can uncomment this when below code for identifying board type works
		lblMovesRemaining.setVisible(false);
		

		//If it's not lightning, we want to see the moves remaining and not the timer
		if (!board.getLevel().getType().equals("Lightning")){ //TODO figure out how to ID it as a lightning level
			lblTimeLeftValue.setVisible(false);
			lblTimeLeft.setVisible(false);
			lblMovesRemaining.setVisible(true);
		}
	
		
		//refresh number of regular moves remaining
		lblMovesRemaining.setText("Moves Remaining: " + board.getMovesRemaining());
		lblMovesRemaining.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//Refresh score
		lblScore.setText("Score: " + board.getScore());
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//refresh number of special moves remaining
		lblMovesRemainingSwap.setText("" + board.getSwapsRemaining());
		lblMovesRemainingSwap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovesRemainingSwap.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		lblMovesRemainingRemove.setText("" + board.getRemovesRemaining());
		lblMovesRemainingRemove.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMovesRemainingRemove.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblMovesRemainingShuffle.setText("" + board.getShufflesRemaining());
		lblMovesRemainingShuffle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovesRemainingShuffle.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		//if any of the special moves are out of moves, disable the buttons
		if (board.getSwapsRemaining() == 0){
			btnSwap.setEnabled(false);
		}
		
		if (board.getRemovesRemaining() == 0){
			btnRemove.setEnabled(false);
		}
		
		if (board.getShufflesRemaining() == 0){
			btnShuffle.setEnabled(false);
		}
		
		
		labelStar2 = new JLabel("2");
		labelStar2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelStar2.setIcon(new ImageIcon(inactivePath)); //AWESOME! 2
		
		labelStar3 = new JLabel("3");
		labelStar3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelStar3.setIcon(new ImageIcon(inactivePath)); //AWESOME!3 
		
		//TODO Combine these two time labels, no point keeping them separate
		lblTimeLeft.setText("Time Left:");
		lblTimeLeft.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblTimeLeftValue.setText("" + board.getTimeLeft());
		lblTimeLeftValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeLeftValue.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblScore)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnSwap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnShuffle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnRemove, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblMovesRemainingRemove, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
										.addComponent(lblMovesRemainingSwap, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
										.addComponent(lblMovesRemainingShuffle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
								.addComponent(lblMovesRemaining)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblTimeLeft)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblTimeLeftValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(labelStar1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(labelStar2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(labelStar3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
							.addGap(18))
						.addComponent(mainMenuButton))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPuzzleLevel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
					.addGap(93))
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
								.addComponent(lblTimeLeftValue))
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSwap, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemainingSwap))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemainingRemove))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMovesRemainingShuffle, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
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

	public Board getBoard(){
		return board;
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
	
	public JToggleButton getSwapButton(){
		return btnSwap; 
	}
	
	public JToggleButton getRemoveButton(){
		return btnRemove; 
	}
	
	public JButton getShuffleButton(){
		return btnShuffle; 
	}
	
	public JLabel getTimeLeftValueLabel(){
		return lblTimeLeftValue;
	}
	
	public JLabel getMovesRemainingSwap(){
		return lblMovesRemainingSwap;
	}
	
	public JLabel getMovesRemainingRemove(){
		return lblMovesRemainingRemove;
	}
	
	public JLabel getMovesRemainingShuffle(){
		return lblMovesRemainingShuffle;
	}
}
