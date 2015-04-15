package levelBuilder.boundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class MainMenuPanel extends JPanel {
	
	public JButton getNewLvlButton() {
		return newLvlButton;
	}

	public void setNewLvlButton(JButton newLvlButton) {
		this.newLvlButton = newLvlButton;
	}

	public JButton getLoadButton() {
		return loadButton;
	}

	public void setLoadButton(JButton loadButton) {
		this.loadButton = loadButton;
	}

	private JButton newLvlButton;
	private JButton loadButton;
	
	public MainMenuPanel(){
		setBackground(new Color(255, 204, 102));
		
		newLvlButton = new JButton("Create New Level");
		newLvlButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		newLvlButton.setBackground(new Color(102, 51, 204));
		
		loadButton = new JButton("Load Existing Project");
		loadButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loadButton.setBackground(new Color(102, 51, 204));
		
		JLabel label = new JLabel("");
		
		JLabel lblSixesWildLevel = new JLabel("Sixes Wild Level Editor!");
		lblSixesWildLevel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 32));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(194)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(142)
							.addComponent(newLvlButton, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(99)
							.addComponent(loadButton, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(220)
							.addComponent(lblSixesWildLevel)))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(label)
					.addGap(65)
					.addComponent(lblSixesWildLevel)
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(loadButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(newLvlButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
					.addContainerGap(215, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
}
