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
	GameTypeController other;
	String oldType;
	
	public GameTypeController(EditPanel options, LevelBuilder editor, GameTypeController other){
		this.options = options;
		this.editor = editor;
		this.other = other;
		this.oldType = (String)options.getSpinner().getValue();
	}
	
	public void setOldType(String oldType){
		System.out.println("old type is now "+oldType);
		this.oldType = oldType;
	}
	
	public void setOtherController(GameTypeController gtc){
		this.other = gtc;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		String newType = (String)options.getSpinner().getValue();
		System.out.println("Changing type to "+newType+"old type is "+oldType);
		Move m = new GameTypeMove(newType, oldType);
		if(m.doMove(editor)){
			editor.pushMove(m);
			oldType = newType;
			other.setOldType(oldType);
		};
		System.out.println("old type is "+oldType);
		
		options.getBoardPanel().refresh();
		
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
