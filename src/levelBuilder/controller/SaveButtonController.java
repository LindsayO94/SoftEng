package levelBuilder.controller;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import common.LevelSaver;
import common.entity.Level;
import levelBuilder.boundary.EditPanel;
import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.entity.LevelBuilder;

public class SaveButtonController implements MouseListener {
	LevelBuilderFrame lbf;
	LevelBuilder builder;
	
	public SaveButtonController(LevelBuilder builder, LevelBuilderFrame lbf) {
		this.builder = builder;
		this.lbf = lbf;
	}

	public void mouseClicked(MouseEvent e) {
		Level l = this.builder.getLevel();
		try {
			LevelSaver.levelToJsonFile(l);
			lbf.getEditor().getSpinner().setEnabled(false);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(lbf,
				    e1.getMessage(),
				    "Save Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
