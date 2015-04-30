package levelBuilder.move;

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
	
	public MultiplierFrequencyMove(String newValue, int index, int oldFrequencies[]){
		this.newValue = newValue;
		this.index = index;
		this.oldMultiplierFrequencies = oldFrequencies;
	}
	
	@Override
	public boolean doMove(LevelBuilder editor) {
		if(valid(editor)){
			int newIntValue = Integer.parseInt(newValue);
			int newMultiplierFrequencies[] = oldMultiplierFrequencies;
					
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
		return false;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		return newValue.matches("[0-9]+");
	}

}
