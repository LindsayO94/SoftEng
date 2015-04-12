package game.boundary;

import java.awt.Graphics;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class AchievementsPanel extends JPanel {
	private JTable table;
	public AchievementsPanel() {
		
		JLabel lblAchievements = new JLabel("Achievements!");
		lblAchievements.setFont(new Font("Museo Slab", Font.PLAIN, 44));
		
		JButton btnNewButton = new JButton("Back to Main Menu!");
		
		table = new JTable(6,6);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addComponent(lblAchievements)
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(267, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(315, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblAchievements)
					.addGap(52)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(15))
		);
		setLayout(groupLayout);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
