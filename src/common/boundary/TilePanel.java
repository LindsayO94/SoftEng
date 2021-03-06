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
import javax.swing.LayoutStyle.ComponentPlacement;

public class TilePanel extends JPanel {
	Tile tile;
	
	final static Color colors[][] = {
		{new Color(0xFE8048), new Color(0xE67441), new Color(0xD56B3C), new Color(0xC76438) },
		{new Color(0xFDE418), new Color(0xE5CE16), new Color(0xDEC815), new Color(0xC6B213) },
		{new Color(0x00F1B4), new Color(0x00D7A1), new Color(0x00CE9A), new Color(0x00BB8C) },
		{new Color(0x63ACFD), new Color(0x599CE5), new Color(0x5392D6), new Color(0x4E87C7) },
		{new Color(0xEE68FD), new Color(0xD85EE6), new Color(0xD15BDF), new Color(0xBB51C7) },
		{new Color(0x6817A6), new Color(0x5E1496), new Color(0x541385), new Color(0x4A1076) },
	};
	final static float positions[] = { 0.0f, 0.5f, 0.501f, 1.0f };

	JLabel numberShadow;
	JLabel number;
	private JLabel multiplier;
	private JLabel multiplierShadow;
	
	public TilePanel(Tile tile) {
		this.tile = tile;
		
		if (tile == null) {
			return;
		}
		numberShadow = new JLabel(tile.getValue() + "");
		if (tile.getValue() == 6) {
			numberShadow.setBounds(0, -1, 45, 45);
			numberShadow.setForeground(new Color(0,0,0,66));
		} else {
			numberShadow.setBounds(0, 1, 45, 45);
			numberShadow.setForeground(new Color(255,255,255,66));
		}
		numberShadow.setHorizontalAlignment(SwingConstants.CENTER);
		numberShadow.setFont(new Font("Museo Slab", Font.PLAIN, 26));
		setLayout(null);
		add(numberShadow);
		
		number = new JLabel(tile.getValue() + "");
		number.setBounds(0, 0, 45, 45);
		if (tile.getValue() == 6) {
			number.setForeground(new Color(255,255,255,166));
		}
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setFont(new Font("Museo Slab", Font.PLAIN, 26));
		add(number);
		add(numberShadow);
		
		if (tile.showMultiplier()) {
			multiplierShadow = new JLabel(tile.getMultiplier()+"x");
			multiplierShadow.setHorizontalAlignment(SwingConstants.CENTER);
			multiplierShadow.setFont(new Font("Museo Slab", Font.PLAIN, 12));
			multiplierShadow.setForeground(new Color(255,255,255,66));
			add(multiplierShadow);
			
			multiplier = new JLabel(tile.getMultiplier()+"x");
			multiplier.setHorizontalAlignment(SwingConstants.CENTER);
			multiplier.setFont(new Font("Museo Slab", Font.PLAIN, 12));
			add(multiplier);
		}
		
	}
	
	private Color[] getColorArray() {
		return colors[tile.getValue()-1];
	}
	
	@Override
    public void paintComponent(Graphics g) {
		if (tile == null) return;
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        numberShadow.setBounds(0, 1, w, h);
        number.setBounds(0, 0, w, h);
        if (tile.showMultiplier()) {
        	multiplierShadow.setBounds(w - 20, h - 14, 20, 15);
        	multiplier.setBounds(w - 20, h - 15, 20, 15);
        }
        LinearGradientPaint gp = new LinearGradientPaint(
            0, 0, 0, h, positions, getColorArray());
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
