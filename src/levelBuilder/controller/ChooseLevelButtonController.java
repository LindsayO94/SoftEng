package levelBuilder.controller;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import common.LevelSaver;
import common.entity.Level;
import levelBuilder.boundary.EditPanel;
import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.entity.LevelBuilder;

public class ChooseLevelButtonController implements MouseListener {
	LevelBuilderFrame LbF;
	String filename;
	long seed;
	
	public ChooseLevelButtonController(LevelBuilderFrame lbF, String filename, long seed) {
		this.LbF = lbF;
		this.filename = filename;
		this.seed = seed;
	}

	public void mouseClicked(MouseEvent e) {
		try {
			Level level = LevelSaver.levelFromJsonFile(filename, seed);
			LbF.showEditor(level);
			// Don't allow to change a level type because that messes up filenames
			LbF.getEditor().getSpinner().setEnabled(false);
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(LbF,
				    e1.getMessage(),
				    "Error loading file",
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
