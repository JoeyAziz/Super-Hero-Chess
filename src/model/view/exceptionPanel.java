package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.sounds.ButtonSound;

@SuppressWarnings("serial")
public class exceptionPanel extends JPanel {
	private JLabel warn;
	private JLabel editText;
	public exceptionPanel() throws IOException {
		this.setLayout(new BorderLayout());
		
		this.setForeground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(275, 50));
		this.setOpaque(false);
		editText = new JLabel();
		
		Image image = ImageIO.read(new File("art/warning.png"));
		warn = new JLabel(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		warn.setVisible(false);
	}
	
	public void setText(String text) {
		
		try {
			new ButtonSound(new File("sounds/exception.wav"));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.add(warn, BorderLayout.WEST);
		editText.setText(text);
		this.add(editText,BorderLayout.CENTER);
		
		this.setToolTipText(text);

		warn.setVisible(true);
		editText.setVisible(true);
	}
	
	public void HideText() {
		if(warn.isVisible())
			warn.setVisible(false);
		if(editText.isVisible())
		editText.setVisible(false);
	}
}
