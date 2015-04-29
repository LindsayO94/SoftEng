package game;

import java.util.ArrayList;

import common.entity.Level;

import game.entities.*;
import game.boundary.*;

public class Main {
	public static ArrayList<Level> addLevels(ArrayList<Level> levels){
		for (String type : Level.allowedTypes) {
			for (int score = 100; score <= 500; score += 100) {
				Level l = new Level(type, 0);
				l.setHighScore(score);
				levels.add(l);
			}
		}
		return levels;
	}
	
	public static void main(String args[]) {
		ArrayList<Level> levels = new ArrayList<Level>();
		levels = addLevels(levels);
		Game game = new Game(levels);
		//System.out.println(game.iter.next().getHighScore());
		GameFrame f = new GameFrame(game);
		f.setVisible(true);
	}
	
	
}
