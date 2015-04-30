package levelBuilder.move;

import java.awt.Component;
import java.awt.event.MouseListener;

import levelBuilder.controller.GameTypeController;
import levelBuilder.entity.LevelBuilder;


/**
 * 
 * @author August
 *
 */
public class GameTypeMove extends Move {
	
	String newType;
	String oldType;
	
	public GameTypeMove(String newType){
		this.newType = newType;
	}

	@Override
	public boolean doMove(LevelBuilder editor) {
		oldType = editor.getLevel().getType();
		editor.getLevel().setType(newType);
		return true;
	}

	@Override
	public boolean undo(LevelBuilder editor) {
		
		editor.getLevel().setType(oldType);
		return true;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		// TODO Auto-generated method stub
		return true;
	}

}
