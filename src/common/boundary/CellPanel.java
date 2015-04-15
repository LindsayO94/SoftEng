package common.boundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CellPanel extends JPanel {
	TilePanel tile;
	
	public CellPanel() {
		
		tile = new TilePanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tile, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tile, GroupLayout.PREFERRED_SIZE, 298, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

}
