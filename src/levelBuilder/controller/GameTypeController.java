package levelBuilder.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.ChangeCellTypeMove;
import levelBuilder.move.GameTypeMove;
import levelBuilder.move.Move;

import common.boundary.BoardPanel;

public class GameTypeController implements MouseListener{
	EditPanel options;
	LevelBuilder editor;
	
	public GameTypeController(EditPanel options, LevelBuilder editor){
		this.options = options;
		this.editor = editor;
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		String newType = (String)options.getSpinner().getValue();
		Move m = new GameTypeMove(newType, editor.getLevel().getType());
		if(m.doMove(editor)){
			editor.pushMove(m);
		};
		
		options.getBoard().refresh();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
