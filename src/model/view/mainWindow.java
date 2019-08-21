package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.game.Game;
import model.game.Player;
import model.sounds.BackgroundSound;
import model.sounds.ButtonSound;

@SuppressWarnings("serial")
public class mainWindow extends JFrame implements ActionListener{
	
	private JTextArea area;
	private JTextArea area2;
	
	private JLabel errlabel;
	private JButton button1;
	private JButton button2;
	
	private boolean ready_1 = false;
	private boolean ready_2 = false;
	
	public static BackgroundSound b1;
	
	public mainWindow() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		
		b1 = new BackgroundSound("sounds/background2.wav");
		
		setIconImage(ImageIO.read(new File("art/super.png")));
		setTitle("Super Hero Chess");
		setResizable(false);
		setSize(500, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5,5));
		setLocation((int) ((getWidth()/2)*(1.75)),(int)(( getHeight()/2)*(1.75)));
		
		Image g = ImageIO.read(new File("art/plume.png"));
		JLabel background = new JLabel(new ImageIcon(g.getScaledInstance(500, 250, Image.SCALE_SMOOTH)));
		add(background, BorderLayout.CENTER);
		background.setLayout(new BorderLayout(5,5));
		
		//NORTH panel
		JPanel northPart = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPart.setOpaque(false);
		background.add(northPart, BorderLayout.NORTH);
		
		//Label (Title)
		JLabel title = new JLabel("Choose Your Names!");
		title.setFont(new Font("Times New Roman",Font.BOLD,25));
		northPart.add(title);

		//---------------

		//Components panel
		JPanel compPanel = new JPanel(new BorderLayout(5,5));
		compPanel.setOpaque(false);
		background.add(compPanel, BorderLayout.CENTER);

		//First part
		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20, 5));
		leftPanel.setOpaque(false);
		compPanel.add(leftPanel, BorderLayout.NORTH);		

		JLabel label = new JLabel("Player 1:");
		label.setForeground(Color.white);
		label.setFont(new Font("Times New Roman",Font.ITALIC,15));
		leftPanel.add(label);

		area = new JTextArea("changeme");
		area.selectAll();
		area.setSelectionColor(Color.gray);
		area.setSelectedTextColor(Color.white);
		area.setTabSize(0);
		area.setPreferredSize(new Dimension(200,15));
		area.setBackground(Color.white);
		area.addKeyListener(new EnterKeyForMainWindow(this, "player1"));
		leftPanel.add(area);

		button1 = new JButton("READY");
		button1.setFont(new Font("Times New Roman",Font.TYPE1_FONT,10));
		leftPanel.add(button1);
		button1.setActionCommand("player1");
		button1.addActionListener(this);
		//-------------------

		//Second part
		JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20, 5));
		rightPanel.setOpaque(false);
		compPanel.add(rightPanel, BorderLayout.CENTER);		

		label = new JLabel("Player 2:");
		label.setForeground(Color.white);
		label.setFont(new Font("Times New Roman",Font.ITALIC,15));
		rightPanel.add(label);

		area2 = new JTextArea("changeme");
		area2.setTabSize(0);
		area2.setPreferredSize(new Dimension(200,15));
		area2.setBackground(Color.white);
		area2.addKeyListener(new EnterKeyForMainWindow(this, "player2"));
		rightPanel.add(area2);

		button2 = new JButton("READY");
		button2.setFont(new Font("Times New Roman",Font.TYPE1_FONT,10));
		rightPanel.add(button2);
		button2.setActionCommand("player2");
		button2.addActionListener(this);
		//-------------------
		
		//Last Part
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		southPanel.setOpaque(false);
		errlabel = new JLabel("be ready to start!  ");
		errlabel.setForeground(Color.gray);
		errlabel.setFont(new Font("Times New Roman",Font.ITALIC,15));
		southPanel.add(errlabel);
		compPanel.add(southPanel, BorderLayout.SOUTH);
		//-------------------


		setVisible(true);
	}

	public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		new mainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String player1_name = area.getText();
		String player2_name = area2.getText();
		
		try {
			new ButtonSound(new File("sounds/button click2.wav"));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(e.getActionCommand().equals("player1")) {
			if(player1_name.equals(player2_name)) {
				//error label
				errlabel.setText("You can't have the same names, grow up  ");
				errlabel.setForeground(Color.red);
			}else if(player1_name.contains(" ")) {
				errlabel.setText("You can't add spaces, sorry  ");
				errlabel.setForeground(Color.red);
			}else {
				if(player1_name.length() > 7) {
					errlabel.setText("That's a big name!!  ");
					errlabel.setForeground(Color.red);
				}if(player1_name.length() < 1) {
					errlabel.setText("So...Where's your name? ");
					errlabel.setForeground(Color.red);
				}else {
					player1_name = area.getText();
					area.setEditable(false);
					area.setBackground(Color.LIGHT_GRAY);
					area.setForeground(Color.red);
					button1.setEnabled(false);
					ready_1 = true;
					errlabel.setText("That's a cool name " + player1_name + "! " );
					errlabel.setForeground(Color.LIGHT_GRAY);
				}
			}
			
		}else if(e.getActionCommand().equals("player2")) {
			if(player1_name.equals(player2_name)) {
				//error label
				errlabel.setText("You can't have the same names, grow up  ");
				errlabel.setForeground(Color.red);
			}else {
				player2_name = area2.getText();
				if(player2_name.length() > 7) {
					errlabel.setText("That's too much for a name  ");
					errlabel.setForeground(Color.red);
				}if(player2_name.length() < 1) {
					errlabel.setText("So...Where's your name? ");
					errlabel.setForeground(Color.red);
				}else if(player2_name.contains(" ")) {
					errlabel.setText("You can't add spaces, sorry  ");
					errlabel.setForeground(Color.red);
				}else {
					area2.setEditable(false);
					area2.setBackground(Color.LIGHT_GRAY);
					area2.setForeground(Color.blue);
					button2.setEnabled(false);
					ready_2 = true;
					errlabel.setText("That's a cool name " + player2_name + "! " );
					errlabel.setForeground(Color.LIGHT_GRAY);
				}
			}
		}
		if(e.getActionCommand().equals("player1") || e.getActionCommand().equals("player2") ){
			if(ready_1 == true && ready_2 == true) {
				Player player1 = new Player(player1_name);
				Player player2 = new Player(player2_name);
				Game game = new Game(player1, player2);
				this.setVisible(false);
				try {
					try {
						new mainBoard(game);
					} catch (LineUnavailableException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
	}
}
