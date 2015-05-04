package levelBuilder.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;

/**
 * 
 * @author Lindsay
 *
 */

public class PreviewController implements MouseListener{
	EditPanel panel;
	LevelBuilder editor;
	
	
	public PreviewController(EditPanel panel, LevelBuilder editor){
		this.panel = panel;
		this.editor = editor;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		editor.getBoard().refresh();
		panel.getBoardPanel().refresh();
		if (panel.getOutputField().getText().equals("")){
			panel.getSaveButton().setEnabled(true);
		}else{
			panel.getSaveButton().setEnabled(false);
		}
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
