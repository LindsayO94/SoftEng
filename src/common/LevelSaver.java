package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JFileChooser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import common.entity.Level;

public class LevelSaver {
	static HashMap<String, Integer> nextLevelNumber;
	static { // Java is _weird_
		// Initialize the HashMap
		nextLevelNumber = new HashMap<String, Integer>();
		// For each allowed level type, set the max number
		for (String type : Level.allowedTypes) {
			int max = 0;
			for (String filename : getLevelFilenames(type)) {
				int val = Integer.parseInt(filename.replaceAll("[^\\d]+", ""));
				max = val > max ? val : max;
			}
			nextLevelNumber.put(type, max+1);
		}
	}
	
	private LevelSaver() {} // Do this so nobody can initialize a LevelSaver
	
	public static int getNextLevelNumber(String type) {
		int num = nextLevelNumber.get(type);
		updateNextLevelNumber(type, num);
		
		return num;
	}
	
	private static void updateNextLevelNumber(String type, int number) {
		if (nextLevelNumber.get(type) <= number) {
			nextLevelNumber.put(type, number);
		}
	}
	
	public static File getSaveLocation() {
		File sixesWildPath = new File(".", "SixesWild");
		sixesWildPath.mkdir();
		
		return sixesWildPath;
	}
	
	public static File getSaveLocation(String filename) {
		return new File(getSaveLocation(), filename);
	}
	
	private static String levelToJsonString(Level l) {
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		return g.toJson(l);
	}
	
	public static File levelToJsonFile(Level l) throws IOException {
		if (l.getNumber() == -1) {
			l.setNumber(getNextLevelNumber(l.getType()));
		}
		
		File file = getSaveLocation(l.filename());
		FileWriter writer = new FileWriter(file);
		writer.write(levelToJsonString(l));
		writer.close();
		
		return file;
	}
	
	public static Level levelFromJsonString(String json, long seed) {
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		
		Level l = g.fromJson(json, Level.class);
		l.setRand(new Random(seed));
		
		return l;
	}

	public static Level levelFromJsonFile(String filename, long seed) throws FileNotFoundException {
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		File file = getSaveLocation(filename);
		JsonReader reader = new JsonReader(new FileReader(file));
		
		Level l = g.fromJson(reader, Level.class);
		l.setRand(new Random(seed));
		
		updateNextLevelNumber(l.getType(), l.getNumber());
		
		return l;
	}
	
	public static String[] getLevelFilenames(final String type) {
		File folder = getSaveLocation();
		
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith(type);
			}
		};
		
		String[] filenames = folder.list(filter);
		
		Arrays.sort(filenames, new Comparator<String>() {
			public int compare(String a, String b) {
				int aVal = Integer.parseInt(a.replaceAll("[^\\d]+", ""));
				int bVal = Integer.parseInt(b.replaceAll("[^\\d]+", ""));
				return Integer.compare(aVal, bVal);
			}
		});
		
		return filenames;
	}
	
	public static String filenameToLevelName(String name) {
		return name.replace('_', ' ').replaceAll(".json$", "");
	}
}
