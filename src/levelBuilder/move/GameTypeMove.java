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
	
	public GameTypeMove(String newType, String oldType){
		this.newType = newType;
		this.oldType = oldType;
	}

	@Override
	public boolean doMove(LevelBuilder editor) {
		if(valid(editor)){
		editor.getLevel().setType(newType);
		return true;
		} else {return false;}
		
	}

	@Override
	public boolean undo(LevelBuilder editor) {
		
		editor.getLevel().setType(oldType);
		return true;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		return(!newType.equals(oldType));
		
	}

}
