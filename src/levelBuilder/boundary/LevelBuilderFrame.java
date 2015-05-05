package levelBuilder.boundary;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import levelBuilder.controller.BackToMainBuilderMenuController;
import levelBuilder.controller.ChooseLevelButtonController;
import levelBuilder.controller.LoadLevelButtonController;
import levelBuilder.controller.NewLevelButtonController;
import levelBuilder.controller.SaveButtonController;
import levelBuilder.controller.SplashController;
import levelBuilder.entity.LevelBuilder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;

import common.boundary.LevelSelectPanel;
import common.entity.Level;

/**
 * Frame for level editor
 * @author August
 *
 */
public class LevelBuilderFrame extends JFrame {
	//Entities go here
	LevelBuilder levelBuilder;

	//Boundary Class Hierarchy Connections
	MainMenuPanel mainMenu;
	EditPanel editor;
	SplashPanel splash;
	
	public LevelBuilderFrame(LevelBuilder levelBuilder) {
		this.levelBuilder = levelBuilder;
		
		splash = new SplashPanel();
		splash.addMouseListener(new SplashController(this));
		
		this.setMinimumSize(new Dimension(800, 600));
		
		this.changePanel(splash);
	}
	
	private void changePanel(JPanel panel) {
		getContentPane().removeAll();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}

	public void showMainMenu() {
		mainMenu = new MainMenuPanel();
		mainMenu.getLoadButton().addMouseListener(new LoadLevelButtonController(levelBuilder, this));
		mainMenu.getNewLvlButton().addMouseListener(new NewLevelButtonController(this));
		
		this.changePanel(mainMenu);
	}
	
	public void showEditor(Level level) {
		levelBuilder.setLevel(level);
		
		editor = new EditPanel(this.levelBuilder);
		editor.getBtnQuit().addMouseListener(new BackToMainBuilderMenuController(this));
		editor.getBtnSave().addMouseListener(new SaveButtonController(levelBuilder, this));

		this.changePanel(editor);
	}
	
	public void showLevelSelect() {
		LevelSelectPanel levelSelect = new LevelSelectPanel(false);
		
		levelSelect.getMainMenuButton().addMouseListener(new BackToMainBuilderMenuController(this));
		for (String filename : levelSelect.getLevelButtons().keySet()) {
			ChooseLevelButtonController c = new ChooseLevelButtonController(this, filename, levelBuilder.getSeed());
			levelSelect.getLevelButton(filename).addMouseListener(c);
		}
		
		this.changePanel(levelSelect);
	}
	
	public EditPanel getEditor(){
		return editor;
	}

	public void dispose(){

		mainMenu.dispose();
		editor.dispose();
		levelBuilder.dispose();;

		mainMenu = null;
		levelBuilder = null;
		editor = null;
		splash  = null;
		
		
	}
	
}
