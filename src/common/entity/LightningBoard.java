package common.entity;

import game.boundary.GameFrame;
import game.boundary.PlayGamePanel;
import game.entities.Game;

import java.util.Timer;
import java.util.TimerTask;


public class LightningBoard extends Board {
	Timer timer;
	int timeLeft;
	private TimerTask task;
	
	public LightningBoard(Level level) {
		super(level);
		
		timer = new Timer();
		this.timeLeft = level.maxTime;
	}

	@Override
	public boolean isWon() {
		// reach a certain score (before the time limit ends)
		//if the high score is higher than the lowest star score value, then the level is won
		if (level.getStar1Score() < this.getScore()){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isCompleted() {
		return timeLeft <= 0;
	}
	
	@Override
	public void moveMade(PlayGamePanel panel) {
		if (task == null) {
			startTimer(panel);
		}
	}
	
	@Override
	protected void onCompleteAction() {
		stopTimer();
	}
	
	@Override
	public void onExitLevelAction() {
		stopTimer();
	}
	
	private void stopTimer() {
		if (task != null) {
			task.cancel();
			task = null;
		}
	}

	private void startTimer(final PlayGamePanel panel) {
		task = new TimerTask() {
			@Override
			public void run() {
				timeLeft -= 1;
				System.out.println(timeLeft);
				checkWin();
				panel.refreshTimeRemaining();
			}
		};
		timer.scheduleAtFixedRate(task, 1000, 1000); // Run timer every 1000 ms starting in 1000 ms
	}

	public int getTimeLeft() {
		return timeLeft;
	}

}
