package model.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.game.Direction;

@SuppressWarnings("serial")
public class directionButton extends JButton  {
	private Direction direction;

	public directionButton(Direction r) throws IOException {
		
		//this.setText(r.name());
		this.direction = r;
		Image image = null ; 
		switch(r) {
		case DOWN:
			image = ImageIO.read(new File("art/down.png"));	
			break;
		case DOWNLEFT:
			image = ImageIO.read(new File("art/down_left.png"));	
			break;
		case DOWNRIGHT:
			image = ImageIO.read(new File("art/down_right.png"));	
			break;
		case LEFT:
			image = ImageIO.read(new File("art/left.png"));	
			break;
		case RIGHT:
			image = ImageIO.read(new File("art/right.png"));	
			break;
		case UP:
			image = ImageIO.read(new File("art/up.png"));	
			break;
		case UPLEFT:
			image = ImageIO.read(new File("art/up_left.png"));	
			break;
		case UPRIGHT:
			image = ImageIO.read(new File("art/up_right.png"));	
			break;			
		}
		this.setIcon(new ImageIcon(image.getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		
		image = ImageIO.read(new File("art/pressed.png"));	
		this.setPressedIcon(new ImageIcon(image.getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		
		
	}
	
	public Direction getDirection() {
		return direction;
	}
}
