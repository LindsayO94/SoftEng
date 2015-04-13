package game;
import entities.*;
import java.util.ArrayList;

import game.boundary.GameFrame;

public class Main {
	public static ArrayList<Level> addLevels(ArrayList<Level> levels){
		levels.add(new Level(100, "Puzzle"));
		levels.add(new Level(200, "Puzzle"));
		levels.add(new Level(300, "Puzzle"));
		levels.add(new Level(400, "Puzzle"));
		levels.add(new Level(500, "Puzzle"));
		levels.add(new Level(100, "Lightning"));
		levels.add(new Level(200, "Lightning"));
		levels.add(new Level(300, "Lightning"));
		levels.add(new Level(400, "Lightning"));
		levels.add(new Level(500, "Lightning"));
		levels.add(new Level(100, "Elimination"));
		levels.add(new Level(200, "Elimination"));
		levels.add(new Level(300, "Elimination"));
		levels.add(new Level(400, "Elimination"));
		levels.add(new Level(500, "Elimination"));
		levels.add(new Level(100, "Release"));
		levels.add(new Level(200, "Release"));
		levels.add(new Level(300, "Release"));
		levels.add(new Level(400, "Release"));
		levels.add(new Level(500, "Release"));
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
