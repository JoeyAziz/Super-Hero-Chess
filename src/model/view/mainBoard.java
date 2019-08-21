package model.view;

import java.awt.BorderLayout;
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

import model.game.Game;
import model.game.Player;
import model.sounds.BackgroundSound;

@SuppressWarnings("serial")
public class mainBoard extends JFrame {
		static final public int WIDTH 	= 720;
		static final public int HEIGHT 	= 600;
		
		public deathPanel deathPanelP1;
		public deathPanel deathPanelP2;
		public payLoadPanel payLoadPanelP1;
		public payLoadPanel2 payLoadPanelP2;
		public cellsPanel CellsPanel;
		public controlPanel control_panel;
		
		public static BackgroundSound b2;
		
		public mainBoard(Game game) throws IOException, LineUnavailableException, UnsupportedAudioFileException{
			try {
				mainWindow.b1.stop();
			}catch(NullPointerException e) {
				
			}
			
			
			b2 = new BackgroundSound("sounds/background.wav");
			
			setIconImage(ImageIO.read(new File("art/super.png")));
			setTitle("Super hero Chess");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(WIDTH, HEIGHT);
			setLocation(getWidth()/2, getHeight()/6);
			setLayout(new BorderLayout());
			setResizable(false);
			//setUndecorated(true);
			
			//board Background
			Image image = ImageIO.read(new File("art/Background.jpg"));
			JLabel background = new JLabel(new ImageIcon(image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
			background.setLayout( new BorderLayout() );
			this.add(background);
			
			//helpPanel
			//this.add(new helpPanel(), BorderLayout.NORTH);
			
			//payLoad panel & death panel
			JPanel eastPanel = new JPanel( new BorderLayout(5,5));
			JPanel westPanel = new JPanel( new BorderLayout(5,5));
			eastPanel.setOpaque(false);
			westPanel.setOpaque(false);
			background.add(eastPanel, BorderLayout.EAST);
			background.add(westPanel, BorderLayout.WEST);
			eastPanel.add(payLoadPanelP1 = new payLoadPanel(game), BorderLayout.EAST);
			eastPanel.add(deathPanelP1 = new deathPanel(game), BorderLayout.CENTER);
			westPanel.add(payLoadPanelP2 = new payLoadPanel2(game), BorderLayout.WEST);
			westPanel.add(deathPanelP2 = new deathPanel(game), BorderLayout.CENTER);
			
			//control panel
			background.add(control_panel = new controlPanel(game, this), BorderLayout.SOUTH);
			
			//cells panel
			background.add(CellsPanel = new cellsPanel(game) , BorderLayout.CENTER);
			
			
			setVisible(true);
		}
		
		public static void main(String args[]) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
			Player pl1 = new Player("Joe");
			Player pl2 = new Player("Ahmed");
			Game game = new Game(pl1, pl2);
			new mainBoard(game);
		}
}
