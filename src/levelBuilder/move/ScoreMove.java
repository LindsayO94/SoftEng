package levelBuilder.move;

import javax.swing.undo.UndoableEdit;

import levelBuilder.entity.LevelBuilder;

public class ScoreMove extends Move{

	String newValue;
	int index; 
	int oldStarScores[];
	UndoableEdit undo;
	
	/**
	 * Class constructor
	 * @param newValue: string value of the change
	 * @param index: indicates which tile StarScore array index this change effects
	 * @param oldFrequencies: array containing old Star Scores
	 * @param undo: UndoableEdit generated by the change
	 */
	public ScoreMove(String newValue, int index, int newScores[], UndoableEdit undo){
		this.newValue = newValue;
		this.index = index;
		this.oldStarScores = newScores;
		this.undo = undo;
	}
	
	/**
	 * checks to see if the move is valid. If the move is valid doMove converts new value string into an appropriate integer. 
	 * Then updates the appropriate attribute in the LevelBuilder's level class.
	 * 
	 * @param editor: the LevelBuilder entity class
	 */
	@Override
	public boolean doMove(LevelBuilder editor) {
		if(valid(editor)){
			int newIntValue;
			if(newValue.matches("")){
				newIntValue = 0;
			}
			else{
				newIntValue = Integer.parseInt(newValue);
			}
			
			int newStarScores[] = new int[3];
					
			for(int i = 0; i <3; i++){
				 newStarScores[i] = oldStarScores[i];
			}
			
			newStarScores[index] = newIntValue;
			
			editor.getLevel().setStarScore(newStarScores);
			return true;
			
		}
		else{
			return false;
		}
		
	}

	/**
	 * Undos the move by setting the appropriate attribute in the LeveBuilder level to oldStarScores and then undoing the change to the corresponding text field.
	 * @param editor: top level level builder entity object.
	 */
	@Override
	public boolean undo(LevelBuilder editor) {
		
		editor.getLevel().setStarScore(oldStarScores);
		undo.undo();	
		
		return true;
	}

	/**
	 * Determines if a move is valid by checking to see if the newValue contains only numerals and the empty string
	 * @param editor: top level level builder entity object.
	 */
	@Override
	public boolean valid(LevelBuilder editor) {
		return newValue.matches("[0-9]+") || newValue.matches("");
	} 

}
