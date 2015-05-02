package levelBuilder.move;

import javax.swing.undo.UndoableEdit;

import levelBuilder.entity.LevelBuilder;

/**
 * A move representing a change to the a Tile Frequency 
 * @author August
 *
 */
public class TileFrequencyMove extends Move{

	String newValue;
	int index; 
	int oldTileFrequencies[];
	UndoableEdit undo;
	
	
	public TileFrequencyMove(String newValue, int index, int oldFrequencies[], UndoableEdit undo){
		this.newValue = newValue;
		this.index = index;
		this.oldTileFrequencies = oldFrequencies;
		this.undo = undo;
	}
	
	@Override
	public boolean doMove(LevelBuilder editor) {
		if(valid(editor)){
			int newIntValue = Integer.parseInt(newValue);
			int newTileFrequencies[] = new int[6];
					
			for(int i = 0; i <6; i++){
				 newTileFrequencies[i] = oldTileFrequencies[i];
			}
			
			newTileFrequencies[index] = newIntValue;
			
			editor.getLevel().setFrequency(newTileFrequencies);
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean undo(LevelBuilder editor) {
		
		editor.getLevel().setFrequency(oldTileFrequencies);
		undo.undo();	
		
		return true;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		return newValue.matches("[0-9]+");
	}

}
