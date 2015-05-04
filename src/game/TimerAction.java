/*package game;

import game.boundary.PlayGamePanel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerAction extends TimerTask{

	int timeLeft;
	
	public TimerAction(int maxTime){
		this.timeLeft = maxTime;
	}
	
	@Override
	public void run() {
		System.out.println("timer is working");
		this.timeLeft--;
		PlayGamePanel.getTimeLeftLabel().setText(""+timeLeft);
		
		if (timeLeft == 0){
			//Time's up!
			PlayGamePanel.getTimeLeftLabel().setText("GG");
		}
		
	}
	
	public void launchTimer(){
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this, 1000, 1000);
	}
}
*/