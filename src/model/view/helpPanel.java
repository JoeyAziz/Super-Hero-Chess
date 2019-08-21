package model.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class helpPanel extends JPanel {
	
	public helpPanel() throws IOException {
		Image image = ImageIO.read(new File("art/helpPanel.png"));
		JLabel background = new JLabel(new ImageIcon(image.getScaledInstance(mainBoard.WIDTH, 25, Image.SCALE_SMOOTH)));
		this.setLayout( new BorderLayout());
		this.setPreferredSize(new Dimension(mainBoard.WIDTH, 25));
		this.setOpaque(true);
		this.add(background, BorderLayout.CENTER);
	}
}
