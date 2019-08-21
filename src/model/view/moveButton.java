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
public class moveButton extends JButton {
	
	public moveButton() throws IOException {
		//this.setText("move");
		Image image = ImageIO.read(new File("art/play.png"));
		this.setIcon(new ImageIcon(image.getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		
		image = ImageIO.read(new File("art/pressed2.png"));
		this.setPressedIcon(new ImageIcon(image.getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		
		this.setToolTipText("move button");
		
	}
	
	public JToolTip createToolTip() {
        JToolTip tip = super.createToolTip();
        tip.setBackground(Color.gray);
        tip.setForeground(Color.white);
        return tip;
      }

}
