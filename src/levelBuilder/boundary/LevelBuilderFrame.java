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
 * Frame for level editor, allows for three main layouts, Main Menu, Edit Panel, and Level Select
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
	
	/**
	 * LevelBuilderFrame: Constructor for the level builder frame
	 * @param levelBuilder: Copy of the LevelBuilder Entitiry for the LevelBuilderFrame
	 */
	public LevelBuilderFrame(LevelBuilder levelBuilder) {
		this.levelBuilder = levelBuilder;
		
		splash = new SplashPanel();
		splash.addMouseListener(new SplashController(this));
		
		this.setMinimumSize(new Dimension(800, 600));
		
		this.changePanel(splash);
	}
	
	/**
	 * changePanel: Method which changes the current panel being displayed, accessible only through one of the show methods
	 * @param panel: JPane to be set.
	 */
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

	/**
	 * showMainMenu: Method which constructs a new main menu panel, adds appropriate controllers and then sets the Main Menu to be visible
	 */
	public void showMainMenu() {
		mainMenu = new MainMenuPanel();
		mainMenu.getLoadButton().addMouseListener(new LoadLevelButtonController(levelBuilder, this));
		mainMenu.getNewLvlButton().addMouseListener(new NewLevelButtonController(this));
		
		this.changePanel(mainMenu);
	}
	
	/**
	 * showEditor: Method which constructs a new EditPanel given a level to edit and makes it visible
	 * @param level
	 */
	public void showEditor(Level level) {
		levelBuilder.setLevel(level);
		
		editor = new EditPanel(this.levelBuilder);
		editor.getBtnQuit().addMouseListener(new BackToMainBuilderMenuController(this));
		editor.getBtnSave().addMouseListener(new SaveButtonController(levelBuilder, this));

		this.changePanel(editor);
	}
	
	/**
	 * showLevelSelect: Method which constructs a LevelSelectPanel and then changes the frame to display it.
	 */
	public void showLevelSelect() {
		LevelSelectPanel levelSelect = new LevelSelectPanel(true);
		
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

	/**
	 * dispose: Cleans the LevelBuilderFrame and the objects it posseses.
	 */
	public void dispose(){

		
		editor.dispose();
		levelBuilder.dispose();;

		mainMenu = null;
		levelBuilder = null;
		editor = null;
		splash  = null;
		
		
	}
	
}
