package game.boundary;
import game.entities.*;

import java.awt.Graphics;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;

@SuppressWarnings("serial")
public class AchievementsPanel extends JPanel {
	private JTable table_1;
	JButton mainMenuButton;
	public AchievementsPanel(Game game) {
		
		JLabel lblAchievements = new JLabel("Achievements!");
		lblAchievements.setHorizontalAlignment(SwingConstants.CENTER);
		lblAchievements.setFont(new Font("Dialog", Font.PLAIN, 40));
		
		mainMenuButton = new JButton("Back to Main Menu!");
		
		String[] columns = {"", "Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
		Object[][] data = {
				{"", "Level 1", "Level 2", "Level 3", "Level 4", "Level 5"},
				{"Puzzle", 0, 0, 0, 0, 0},
				{"Lightning", 0, 0, 0, 0, 0},
				{"Elimination",  0, 0, 0, 0, 0},
				{"Release",  0, 0, 0, 0, 0}
		};
		
		Iterator<Level>levelList = game.iterator();
		
		for(int i=1; i<5;i++){
			for(int j=1; j<6;j++){
				if(levelList.hasNext()){
					data[i][j] = levelList.next().getHighScore();
				}
			}
		}
		
		table_1 = new JTable(data,columns) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; //Disallow the editing of any cell
			}
		};
		table_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setBackground(new Color(153, 204, 255));
		table_1.setRowHeight(50);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(50);
		table_1.setShowVerticalLines(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i=0;i<6;i++)
		{
			table_1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(672, Short.MAX_VALUE)
					.addComponent(mainMenuButton)
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(262)
					.addComponent(lblAchievements, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
					.addGap(262))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(131)
					.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
					.addGap(130))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAchievements)
					.addGap(103)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
					.addComponent(mainMenuButton)
					.addGap(15))
		);
		setLayout(groupLayout);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public JButton getBackButton() {
		return mainMenuButton;
	}
}
