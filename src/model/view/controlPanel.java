package model.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.game.Game;

@SuppressWarnings("serial")
public class controlPanel extends JPanel {
		public exceptionPanel exPanel;
		public JLabel currentPlayer;
		
		public static KeyBoardControls k;
		
		public controlPanel(Game game, mainBoard main) throws IOException {
			this.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
			//this.setLayout(new GridLayout(0,6, 5, 0));
			this.setOpaque(false);
			//this.setPreferredSize(new Dimension(mainBoard.WIDTH, 30));
			
			//Image image = ImageIO.read(new File("art/skull_icon_2.png"));
			//JLabel skull = new JLabel(new ImageIcon(image.getScaledInstance(25, 70, Image.SCALE_SMOOTH)));
			JLabel gif = new JLabel(new ImageIcon("art/fire.gif"));
			this.add(gif);
			
			//Movements Panel
			movementPanel m = new movementPanel(game, main); 
			this.add(m);
			
			k = new KeyBoardControls(m);
			
			//super Button
			this.add(new superPanel(m));
			
			
			//empty space
			JLabel space = new JLabel("");
			space.setPreferredSize(new Dimension(40, 50));
			this.add(space);
			
			//Current Player Label
			createCurrentPlayerLabel(game);
			
			//Exception panel
			this.add(exPanel = new exceptionPanel());
			
				//test
			//exPanel.setText("This is an exception due to wrong movement");
			
			//Skull image
			//image = ImageIO.read(new File("art/skull_icon_1.png"));
			//skull = new JLabel(new ImageIcon(image.getScaledInstance(25, 70, Image.SCALE_SMOOTH)));
			//URL url2 = new URL("art/fire.gif");
			JLabel gif2 = new JLabel(new ImageIcon("art/fire.gif"));
			this.add(gif2);
		}

		public void createCurrentPlayerLabel(Game game) {
			currentPlayer = new JLabel(game.getCurrentPlayer().getName());
			currentPlayer.setFont(new Font("Times New Roman",Font.BOLD,23));
			currentPlayer.setPreferredSize(new Dimension(135, 50));
			if(game.getCurrentPlayer().equals(game.getPlayer1())) {
				currentPlayer.setForeground(Color.red);
			}else {
				currentPlayer.setForeground(Color.blue);
			}
			currentPlayer.setToolTipText(game.getCurrentPlayer().getName());
			
			this.add(currentPlayer);
			
		}
		
		public void updateCurrentPlayerLabel(Game game) {
			currentPlayer.setText(game.getCurrentPlayer().getName());
			if(game.getCurrentPlayer().equals(game.getPlayer1())) {
				currentPlayer.setForeground(Color.red);
			}else {
				currentPlayer.setForeground(Color.blue);
			}			
			currentPlayer.setToolTipText(game.getCurrentPlayer().getName());
		}
}
