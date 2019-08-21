package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.game.Player;
import model.sounds.BackgroundSound;

@SuppressWarnings("serial")
public class GameOver extends JFrame {
	static final public int WIDTH 	= 354;
	static final public int HEIGHT 	= 400;
	
	public GameOver(Player winner) throws IOException {
		
		try {
			mainBoard.b2.stop();
		}catch(NullPointerException e) {
			
		}
		
		try {
			/*Random random = new Random();
			int index = random.nextInt(2);
			if(index > 0)
				new BackgroundSound("sounds/game over.wav");
			else*/
				new BackgroundSound("sounds/background3.wav");
		} catch (LineUnavailableException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setIconImage(ImageIO.read(new File("art/super.png")));
		setTitle("Super hero Chess");
		setSize(WIDTH, HEIGHT);
		setLocation(getWidth()/2, getHeight()/6);
		setLayout(new BorderLayout());
		setResizable(false);
		
		//frame Background
		Image image = ImageIO.read(new File("art/game over.png"));
		JLabel background = new JLabel(new ImageIcon(image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
		background.setLayout( new BorderLayout() );
		this.add(background);
		
		image = ImageIO.read(new File("art/sports.png"));
		//JLabel icon = new JLabel(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		//JLabel icon2 = new JLabel(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		
		//Label (Title)
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel title = new JLabel(winner.getName());
		title.setFont(new Font("Times New Roman",Font.BOLD,25));
		title.setForeground(Color.YELLOW);
		center.setOpaque(false);
		//center.add(icon);
		center.add(addCeleb(2));
		center.add(title);
		title = new JLabel(" Is The...");
		title.setForeground(Color.white);
		title.setFont(new Font("Times New Roman",Font.BOLD,20));
		center.add(title);
		//center.add(icon2);
		center.add(addCeleb(4));
		//Center
		JPanel c = new JPanel(new BorderLayout());
		c.setOpaque(false);
		title = new JLabel("   WINNER");
		title.setForeground(Color.red);
		title.setFont(new Font("Times New Roman",Font.BOLD,15));
		c.add(title, BorderLayout.CENTER);
		c.add(addCeleb(1), BorderLayout.WEST);
		c.add(addCeleb(1), BorderLayout.EAST);
		c.add(addCeleb(6), BorderLayout.NORTH);//--
		//---------------
		background.add(c, BorderLayout.CENTER);
		background.add(center, BorderLayout.NORTH);
		background.add(addCeleb(3), BorderLayout.SOUTH);
		//---------------
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		new GameOver(new Player("Johnny"));
	}
	
	private JLabel addCeleb(int i) {
		return new JLabel(new ImageIcon("art/celebration"+i+".gif"));		
	}
}
