package levelBuilder.move;

import javax.swing.undo.UndoableEdit;

import levelBuilder.entity.LevelBuilder;

public class ScoreMove extends Move{

	String newValue;
	int index; 
	int oldStarScores[];
	UndoableEdit undo;
	
	
	public ScoreMove(String newValue, int index, int newScores[], UndoableEdit undo){
		this.newValue = newValue;
		this.index = index;
		this.oldStarScores = newScores;
		this.undo = undo;
	}
	
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

	@Override
	public boolean undo(LevelBuilder editor) {
		
		editor.getLevel().setStarScore(oldStarScores);
		undo.undo();	
		
		return true;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		return newValue.matches("[0-9]+") || newValue.matches("");
	} 

}
