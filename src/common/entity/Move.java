package common.entity;

import levelBuilder.entity.LevelBuilder;


public abstract class Move {
	protected Move() { }
	
	public abstract boolean doMove (LevelBuilder editor);
	
	public abstract boolean undo(LevelBuilder editor);
	
	public abstract boolean valid (LevelBuilder editor);
}

//this is not a common move class since it only works for LevelBuilder
