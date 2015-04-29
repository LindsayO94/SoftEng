package game.boundary;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Color;

@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel {
	private JButton playGameButton;
	private JButton achievementsButton;

	public MainMenuPanel() {
		setBackground(new Color(0, 153, 255));
		setForeground(Color.BLUE);
		
		playGameButton = new JButton("Play Game");
		playGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		achievementsButton = new JButton("View Achievements");
		
		JLabel lblSixesWild = new JLabel("Sixes Wild!");
		lblSixesWild.setForeground(new Color(102, 0, 0));
		lblSixesWild.setHorizontalAlignment(SwingConstants.CENTER);
		lblSixesWild.setFont(new Font("Museo Slab", Font.PLAIN, 64));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addComponent(playGameButton, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
					.addGap(93)
					.addComponent(achievementsButton, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
					.addGap(93))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(163)
					.addComponent(lblSixesWild, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(179))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(lblSixesWild)
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(achievementsButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(playGameButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(180, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {playGameButton, achievementsButton});
		setLayout(groupLayout);
		
		// END WindowBuilder CODE
		
		
	}

	public JButton getPlayGameButton() {
		return playGameButton;
	}

	public JButton getAchievementsButton() {
		return achievementsButton;
	}
}
