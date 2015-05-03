package game.entities;

import java.util.ArrayList;
import java.util.Iterator;

import common.entity.Level;

public class Game implements Iterable<Level> {
	public ArrayList<Level> levels;
	
	public Game(ArrayList<Level> levels){
		this.levels = levels;
	}
	
	public Iterator<Level> iterator(){
		return levels.iterator();
	}
}
