package levelBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import common.entity.Level;
import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.entity.LevelBuilder;


/**
 * Main file for LevelBuilder project. Run the LevelBuilder from this file
 * @author August
 *
 */
public class Main {
	public static void main(String args[]) {
		LevelBuilder model = new LevelBuilder();
		LevelBuilderFrame f = new LevelBuilderFrame(model) ;
		model.setFrame(f);
		f.setVisible(true);
	}
}
