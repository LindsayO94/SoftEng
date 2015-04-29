package levelBuilder.boundary;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import levelBuilder.controller.BackToMainBuilderMenuController;
import levelBuilder.controller.NewLevelButtonController;
import levelBuilder.controller.SplashController;
import levelBuilder.entity.LevelBuilder;

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
		mainMenu = new MainMenuPanel();
		editor = new EditPanel(levelBuilder.getLevel(), this.levelBuilder);
		
		this.setMinimumSize(new Dimension(800, 600));
		getContentPane().setLayout(new CardLayout(0, 0));
		
		splash.addMouseListener(new SplashController(this));
		editor.getBtnQuit().addMouseListener(new BackToMainBuilderMenuController(this));
		mainMenu.getLoadButton().addMouseListener(new NewLevelButtonController(this));
		mainMenu.getNewLvlButton().addMouseListener(new NewLevelButtonController(this));
		
		getContentPane().add(splash, "Splash");
		getContentPane().add(mainMenu, "Main Menu");
		getContentPane().add(editor, "Editor");
		
		
		
	}
	
	public EditPanel getEditor(){
		return editor;
	}
	
}
