package builder;

import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Builder builder = new Builder();
		BuilderFrame f = new BuilderFrame(builder);
		f.setVisible(true);
	}
}
