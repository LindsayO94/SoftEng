package levelBuilder.move;

import javax.swing.JTextField;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import levelBuilder.entity.LevelBuilder;

public class DummyUndoableEdit implements UndoableEdit  {

	
	
	public DummyUndoableEdit(){

	}
	
	@Override
	public void undo() throws CannotUndoException {
	
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void redo() throws CannotRedoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canRedo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addEdit(UndoableEdit anEdit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replaceEdit(UndoableEdit anEdit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSignificant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPresentationName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUndoPresentationName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRedoPresentationName() {
		// TODO Auto-generated method stub
		return null;
	}

}
