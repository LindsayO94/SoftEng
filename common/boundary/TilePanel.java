package common.boundary;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import common.entity.Tile;

public class TilePanel extends JPanel {
	Tile tile;
	JLabel label;
	
	final static Color colors[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.lightGray};
	
	public TilePanel(Tile tile) {
		this.tile = tile;
		
		// HERE THERE BE WINDOW BUILDER
		setBackground(colors[tile.getValue()-1]);
		
		// TODO: As soon as the "tile" parameter is working, change
		// this to reference the model.
		label = new JLabel(tile.getValue() + "");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Museo Slab", Font.PLAIN, 26));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	
	public void toggleNumber(){
		if (label.isVisible())
			setBackground(colors[6]);
		else
			setBackground(colors[tile.getOldValue()-1]);
		label.setVisible(!(label.isVisible()));
	}


	public Tile getTile() {
		return this.tile;
	}
}
