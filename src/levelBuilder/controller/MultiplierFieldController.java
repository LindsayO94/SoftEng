package levelBuilder.controller;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import levelBuilder.boundary.EditPanel;
import levelBuilder.entity.LevelBuilder;
import levelBuilder.move.MultiplierFrequencyMove;

public class MultiplierFieldController implements DocumentListener {
	
	LevelBuilder editor;
	EditPanel editPanel;
	JTextField field;
	int index;
	public MultiplierFieldController(LevelBuilder editor, JTextField field,int index, EditPanel editPanel){
		 
		this.editor = editor;
		this.field = field;
		this.index = index;
		this.editPanel = editPanel;
	
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		MultiplierFrequencyMove move = new MultiplierFrequencyMove(field.getText(), index, editor.getLevel().getMultiplierFrequencyArray());
		if(move.doMove(editor)){
			editor.pushMove(move);
			System.out.println("yo");
		}

		
	
	}

	@Override
	public void removeUpdate(DocumentEvent e) {

		MultiplierFrequencyMove move = new MultiplierFrequencyMove(field.getText(), index, editor.getLevel().getMultiplierFrequencyArray());
		if(move.doMove(editor)){
			editor.pushMove(move);
			System.out.println(editor.getLevel().getMultiplierFrequency(0));
		}
	
		
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
	

		
		
		
	}

}
