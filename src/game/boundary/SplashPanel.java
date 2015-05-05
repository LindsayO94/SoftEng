package game.boundary;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;

public class SplashPanel extends JPanel{
	public SplashPanel() {
		setBackground(new Color(0, 51, 153));
		
		JLabel lblSixesWild = new JLabel("Sixes Wild");
		lblSixesWild.setHorizontalAlignment(SwingConstants.CENTER);
		lblSixesWild.setForeground(new Color(0, 204, 255));
		lblSixesWild.setFont(new Font("Kokonor", Font.PLAIN, 54));
		
		JLabel lblCreatedBy = new JLabel("Created By");
		lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedBy.setForeground(new Color(0, 255, 255));
		lblCreatedBy.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblAugustBeers = new JLabel("August Beers");
		lblAugustBeers.setHorizontalAlignment(SwingConstants.CENTER);
		lblAugustBeers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAugustBeers.setForeground(new Color(51, 255, 255));
		
		JLabel lblArtyKica = new JLabel("Arty Kica is the worst");
		lblArtyKica.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtyKica.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblArtyKica.setForeground(new Color(51, 255, 255));
		
		JLabel lblAndrewLaManna = new JLabel("Andrew La Manna");
		lblAndrewLaManna.setHorizontalAlignment(SwingConstants.CENTER);
		lblAndrewLaManna.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAndrewLaManna.setForeground(new Color(51, 255, 255));
		
		JLabel lblLindsayOdonnell = new JLabel("Lindsay O'Donnell");
		lblLindsayOdonnell.setHorizontalAlignment(SwingConstants.CENTER);
		lblLindsayOdonnell.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLindsayOdonnell.setForeground(new Color(51, 255, 255));
		
		JLabel lblWillPryor = new JLabel("Will Pryor");
		lblWillPryor.setHorizontalAlignment(SwingConstants.CENTER);
		lblWillPryor.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblWillPryor.setForeground(new Color(51, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(122)
					.addComponent(lblSixesWild, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(122))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(208)
					.addComponent(lblCreatedBy, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
					.addGap(208))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(296)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWillPryor, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(lblLindsayOdonnell, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(lblAndrewLaManna, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(lblArtyKica, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addComponent(lblAugustBeers, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
					.addGap(296))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblSixesWild)
					.addGap(40)
					.addComponent(lblCreatedBy)
					.addGap(29)
					.addComponent(lblAugustBeers)
					.addGap(18)
					.addComponent(lblArtyKica)
					.addGap(18)
					.addComponent(lblAndrewLaManna)
					.addGap(18)
					.addComponent(lblLindsayOdonnell)
					.addGap(18)
					.addComponent(lblWillPryor)
					.addContainerGap(143, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
