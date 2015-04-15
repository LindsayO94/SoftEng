package builder;

import builder.boundary.LevelBuilderFrame;
import builder.entities.LevelBuilder;

public class Main {
	public static void main(String args[]) {
		LevelBuilder builder = new LevelBuilder();
		LevelBuilderFrame f = new LevelBuilderFrame(builder);
		f.setVisible(true);
	}
}
