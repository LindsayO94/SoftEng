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
			System.out.println("Changing type to "+newType);
			editor.getLevel().setType(newType);
			if(newType.equals("Lightning")){
				options.getTimeLimitText().setEnabled(true);
				options.getMovesAllowed().setEnabled(false);
				options.getShuffle().setEnabled(true);
				options.getRemove().setEnabled(true);
				options.getSwap().setEnabled(true);
				options.getSixProbabilityField().setEnabled(true);
			}
			else if(newType.equals("Release")){
				options.getTimeLimitText().setEnabled(false);
				options.getMovesAllowed().setEnabled(true);
				options.getShuffle().setEnabled(false);
				options.getRemove().setEnabled(false);
				options.getSwap().setEnabled(false);
				options.getShuffle().setText("0");
				options.getRemove().setText("0");
				options.getSwap().setText("0");
				options.getSixProbabilityField().setText("0");
				options.getSixProbabilityField().setEnabled(false);
			}
			else{
				options.getTimeLimitText().setEnabled(false);
				options.getMovesAllowed().setEnabled(true);
				options.getShuffle().setEnabled(true);
				options.getRemove().setEnabled(true);
				options.getSwap().setEnabled(true);
				options.getSixProbabilityField().setEnabled(true);
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
		boolean reachedEndofSpinner = newType.equals(oldType);
		if (reachedEndofSpinner)
			return false;
		if (oldType.equals("Release")){
			if (options.getBoardPanel().getNumBaskets()>0)
			{
				options.getOutputField().setText("Please remove all baskets before changing the game mode.");
				options.refresh();  //Puts old type back in spinner
				return false;
			}
		}
		options.getOutputField().setText("");
		return true;
		//If the old mode is not Release, and if the user is not moving to the same type they
		//are already at, the move is valid.
		
	}

}
