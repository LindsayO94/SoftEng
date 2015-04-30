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
		editor.getLevel().setType(newType);
		return true;
	}

	@Override
	public boolean undo(LevelBuilder editor) {
		for(Component c:editor.getFrame().getEditor().getSpinner().getComponents()){
			for(MouseListener m:c.getMouseListeners()){
				if (m instanceof GameTypeController){
					GameTypeController gc = (GameTypeController)m;
					gc.setOldType(oldType);
				}
			}
		}
		editor.getLevel().setType(oldType);
		return true;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		// TODO Auto-generated method stub
		return true;
	}

}
