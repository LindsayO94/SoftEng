package common.boundary;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;

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
	
	final static Color colors[][] = {
		{new Color(0xFE8048), new Color(0xE67441), new Color(0xD56B3C), new Color(0xC76438) },
		{new Color(0xFDE418), new Color(0xE5CE16), new Color(0xDEC815), new Color(0xC6B213) },
		{new Color(0x00F1B4), new Color(0x00D7A1), new Color(0x00CE9A), new Color(0x00BB8C) },
		{new Color(0x63ACFD), new Color(0x599CE5), new Color(0x5392D6), new Color(0x4E87C7) },
		{new Color(0xEE68FD), new Color(0xD85EE6), new Color(0xD15BDF), new Color(0xBB51C7) },
		{new Color(0x6817A6), new Color(0x5E1496), new Color(0x541385), new Color(0x4A1076) },
	};
	final static float positions[] = { 0.0f, 0.5f, 0.501f, 1.0f };
	
	public TilePanel(Tile tile) {
		this.tile = tile;
		
		// HERE THERE BE WINDOW BUILDER		
		label = new JLabel(tile.getValue() + "");
		if (tile.getValue() == 6) {
			label.setForeground(new Color(255,255,255,166));
		}
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
	
	private Color[] getColorArray() {
		return colors[tile.getValue()-1];
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        LinearGradientPaint gp = new LinearGradientPaint(
            0, 0, 0, h, positions, getColorArray());
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
