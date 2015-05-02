package levelBuilder.move;

import javax.swing.undo.UndoableEdit;

import levelBuilder.entity.LevelBuilder;

public class MaxMovesMove extends Move{

	String newValue;
	int oldValue;
	UndoableEdit undo;
	
	
	public MaxMovesMove(String newValue, int oldValue, UndoableEdit undo){
		this.newValue = newValue;
		this.oldValue = oldValue;
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
						
			editor.getLevel().setMaxMoves(newIntValue);
			return true;
			
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean undo(LevelBuilder editor) {
		
		editor.getLevel().setMaxMoves(oldValue);
		undo.undo();	
		
		return true;
	}

	@Override
	public boolean valid(LevelBuilder editor) {
		return newValue.matches("[0-9]+") || newValue.matches("");
	}  

}
