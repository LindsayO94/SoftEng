package common.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.border.LineBorder;

import common.entity.BasketCell;
import common.entity.Cell;
import common.entity.Tile;
import common.entity.TileCell;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * 
 * @author Lindsay
 *
 */

public class BasketCellPanel extends CellPanel {
	static Image image;
	static int w;
	static int h;
	static {
		image = new ImageIcon("Images/BasketCell.png").getImage();
		w = image.getWidth(null)/2;
		h = image.getHeight(null)/2;
	}
	
	TilePanel tileView = null;

	public BasketCellPanel(BasketCell cell) {
		super(cell);
		setForeground(Color.GRAY);
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		if (getTile() != null) {
			if (getTile().getValue() != 6) {
				throw new IllegalStateException("Basket contains a non-six");
			}
			tileView = new TilePanel(getTile());
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(tileView, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(tileView, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
			);
			setLayout(groupLayout);
		}
	}
	
	public Tile getTile() {
		return ((BasketCell) this.getCellModel()).getTile();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null)/2, image.getHeight(null)/2, null);
    }
}
