package levelBuilder.move;

import javax.swing.undo.UndoableEdit;

import levelBuilder.entity.LevelBuilder;

/**
 * A move which changes a value in one of the multiplier frequency text fields
 * @author August
 *
 */
public class MultiplierFrequencyMove extends Move{

	String newValue;
	int index; 
	int oldMultiplierFrequencies[];
	UndoableEdit undo;
	
	
	public MultiplierFrequencyMove(String newValue, int index, int oldFrequencies[], UndoableEdit undo){
		this.newValue = newValue;
		this.index = index;
		this.oldMultiplierFrequencies = oldFrequencies;
		this.undo = undo;
	}
	
	@Override
	public boolean doMove(LevelBuilder editor) {
		if(valid(editor)){
			int newIntValue = Integer.parseInt(newValue);
			int newMultiplierFrequencies[] = new int[3];
					
			for(int i = 0; i <3; i++){
				 newMultiplierFrequencies[i] = oldMultiplierFrequencies[i];
			}
			
			newMultiplierFrequencies[index] = newIntValue;
			
			editor.getLevel().setMultiplierFrequency(newMultiplierFrequencies);
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean undo(LevelBuilder editor) {
		
		editor.getLevel().setMultiplierFrequency(oldMultiplierFrequencies);
		undo.undo();	
		
		return true;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		return newValue.matches("[0-9]+");
	}
	

}
