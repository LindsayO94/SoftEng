package levelBuilder.move;

import java.awt.Component;
import java.awt.event.MouseListener;

import levelBuilder.boundary.EditPanel;
import levelBuilder.controller.GameTypeSpinnerController;
import levelBuilder.entity.LevelBuilder;


/**
 * 
 * @author August, Lindsay
 *
 */
public class GameTypeMove extends Move {
	
	String newType;
	String oldType;
	EditPanel options;
	
	public GameTypeMove(String newType, String oldType, EditPanel options){
		this.newType = newType;
		this.oldType = oldType;
		this.options = options;
	}

	@Override
	public boolean doMove(LevelBuilder editor) {
		if(valid(editor)){
			editor.getLevel().setType(newType);
			if(newType.equals("Lightning")){
				options.getTimeLimitText().setEnabled(true);
				options.getMovesAllowed().setEnabled(false);
				options.getShuffle().setEnabled(true);
			}
			else if(newType.equals("Release")){
				options.getTimeLimitText().setEnabled(false);
				options.getMovesAllowed().setEnabled(true);
				options.getShuffle().setEnabled(false);
			}
			else{
				options.getTimeLimitText().setEnabled(false);
				options.getMovesAllowed().setEnabled(true);
				options.getShuffle().setEnabled(true);
			}
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
