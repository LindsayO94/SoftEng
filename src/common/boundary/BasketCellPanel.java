package common.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.border.LineBorder;

import common.entity.BasketCell;
import common.entity.Cell;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

public class BasketCellPanel extends CellPanel {
	static Image image;
	static int w;
	static int h;
	static {
		image = new ImageIcon("Images/BasketCell.png").getImage();
		w = image.getWidth(null)/2;
		h = image.getHeight(null)/2;
	}

	public BasketCellPanel(BasketCell cell) {
		super(cell);
		setForeground(Color.GRAY);
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, w, h, null);
    }

}
