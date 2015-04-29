package game.entities;

public class Level {
	private int highScore;
	String type;
	public Level (int highScore, String type){
		this.setHighScore(highScore);
		this.type = type;
	}
	public int getHighScore() {
		return highScore;
	}
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
}
