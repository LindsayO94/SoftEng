package common;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class TestUtil {
	private TestUtil() {} // Prevent instantiation
	
	public static void displayView(final JPanel panel, int w, int h) {
		// Java is *weird*
		JFrame f = new JFrame() {
			{
				GroupLayout groupLayout = new GroupLayout(getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, w, Short.MAX_VALUE)
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, h, Short.MAX_VALUE)
				);
				setMinimumSize(new Dimension(w, h+50));
				getContentPane().setLayout(groupLayout);

			}
		};
		f.setVisible(true);
	}
}
