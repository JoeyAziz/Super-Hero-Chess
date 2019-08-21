package model.view;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolTip;

@SuppressWarnings("serial")
public class superButton extends JButton {

		public superButton() throws IOException {
			//this.setText("Z");
			Image image = ImageIO.read(new File("art/super.png"));
			this.setIcon(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
			
			image = ImageIO.read(new File("art/super.png"));
			this.setPressedIcon(new ImageIcon(image.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
			
			this.setOpaque(false);
			this.setBorderPainted(false);
			this.setContentAreaFilled(false);
			
			this.setToolTipText("activate power button");
		}
		
		public JToolTip createToolTip() {
	        JToolTip tip = super.createToolTip();
	        tip.setBackground(Color.gray);
	        tip.setForeground(Color.white);
	        return tip;
	      }
}
