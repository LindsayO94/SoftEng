package levelBuilder;
import levelBuilder.boundary.LevelBuilderFrame;
import levelBuilder.entity.LevelBuilder;



public class Main {
	public static void main(String args[]) {
		LevelBuilder model = new LevelBuilder();
		LevelBuilderFrame f = new LevelBuilderFrame(model) ;
		f.setVisible(true);
	}

}
