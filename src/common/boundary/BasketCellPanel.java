package common.boundary;

import java.awt.Color;

import javax.swing.border.LineBorder;

import common.entity.BasketCell;
import common.entity.Cell;
import javax.swing.JLabel;
import java.awt.Font;

public class BasketCellPanel extends CellPanel {

	public BasketCellPanel(BasketCell cell) {
		super(cell);
		setForeground(Color.GRAY);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Dialog", Font.BOLD, 14));
		add(lblB);
		// TODO Auto-generated constructor stub
	}

}
