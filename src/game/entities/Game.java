package game.entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import common.LevelSaver;
import common.entity.Board;
import common.entity.Level;

public class Game implements Iterable<Level> {
	public ArrayList<Level> levels;
	Random rand;
	
	public Game(ArrayList<Level> levels) {
		this.rand = new Random();
		
		if (levels == null) {
			this.levels = new ArrayList<Level>();
			
			for (String levelType : Level.allowedTypes) {
				for (String filename : LevelSaver.getLevelFilenames(levelType)) {
					try {
						this.levels.add(LevelSaver.levelFromJsonFile(filename, rand.nextLong()));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			this.levels = levels;
		}
	}
	
	public Game() {
		this(null);
	}
	
	public Iterator<Level> iterator(){
		return levels.iterator();
	}
}
