package levelBuilder.controller;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import common.entity.Level;
import levelBuilder.boundary.EditPanel;
import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.entity.LevelBuilder;

public class LoadLevelButtonController implements MouseListener {
	LevelBuilder builder;
	LevelBuilderFrame LbF;
	
	public LoadLevelButtonController(LevelBuilder builder, LevelBuilderFrame lbF) {
		this.builder = builder;
		this.LbF = lbF;
	}

	public void mouseClicked(MouseEvent e) {
		try {
			Level level = Level.fromJsonFile("temporaryname.json", 0);
			LbF.showEditor(level);
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
