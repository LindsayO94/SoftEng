package common.entity;


public class LightningBoard extends Board {

	int timeLeft;
	
	public LightningBoard(Level level) {
		super(level);
		
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

}
