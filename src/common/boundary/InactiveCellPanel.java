package common.boundary;

import common.entity.Cell;
import common.entity.InactiveCell;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class InactiveCellPanel extends CellPanel {

	public InactiveCellPanel(InactiveCell cell) {
		super(cell);
		setForeground(Color.GRAY);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
	}

}
