package builder.boundary;

import javax.swing.JFrame;

import builder.entities.LevelBuilder;

@SuppressWarnings("serial")
public class LevelBuilderFrame extends JFrame {
	LevelBuilder builder;

	public LevelBuilderFrame(LevelBuilder builder) {
		this.builder = builder;
	}

}
