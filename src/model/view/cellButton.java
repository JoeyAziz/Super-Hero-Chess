package model.view;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolTip;

import model.game.Cell;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;

@SuppressWarnings("serial")
public class cellButton extends JButton{
	private Cell cell;
	
	public cellButton(String s) throws IOException {
		super(s);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));	
		
		this.addKeyListener(controlPanel.k);
	}
	
	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public void updateIcon(int p) throws IOException {
		Piece piece = cell.getPiece();
		
		Image image = null;
		String name = "";
		
		String player = (p == 1)? "/player1": "/player2";
		
		if(piece == null) {
			return;
		}
		else if (piece instanceof  SideKick) {
			image = ImageIO.read(new File("art/pieces"+player+"/sidekick.png"));
			name = "Sidekick";
		}
		else if (piece instanceof Armored) {
			image = ImageIO.read(new File("art/pieces"+player+"/armored.png"));
			name = "Armored";
		}
		else if (piece instanceof Medic) {
			image = ImageIO.read(new File("art/pieces"+player+"/medic.png"));
			name = "Medic";
		}
		else if (piece instanceof Ranged) {
			image = ImageIO.read(new File("art/pieces"+player+"/ranged.png"));
			name = "Ranged";
		}
		else if (piece instanceof Speedster) {
			image = ImageIO.read(new File("art/pieces"+player+"/speedster.png"));
			name = "Speedster";
		}
		else if (piece instanceof Super) {
			image = ImageIO.read(new File("art/pieces"+player+"/super.png"));
			name = "Super";
		}
		else if (piece instanceof Tech) {
			image = ImageIO.read(new File("art/pieces"+player+"/tech.png"));
			name = "Tech";

		}
		if(piece instanceof ActivatablePowerHero)
			this.setToolTipText("<html>" +
								name 	 +
								"<br>"	 +
								"Onwer:  "	 
										 +
								piece.getOwner().getName()
										 +
								"<br>"	 +
								"Power used:  "
										 + 
				((ActivatablePowerHero) piece).isPowerUsed()
										 +
								"</html>");
		else if(piece instanceof Armored)
						this.setToolTipText("<html>" +
								name 	 +
								"<br>"	 +
								"Onwer:  "	 
										 +
								piece.getOwner().getName()
										 +
								"<br>"	 +
								"Armour up:  "
										 + 
				((Armored) piece).isArmorUp()
										 +
								"</html>");
		
		else this.setToolTipText("<html>"+
								name 	 +
								"<br>"	 +
								"Onwer:  "	 
										 +
								piece.getOwner().getName()
										 +
								"</html>");

		//this.setToolTipText(name);
		
		this.setIcon(new ImageIcon(image.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		this.setPressedIcon(new ImageIcon(image.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
	}
	
	public JToolTip createToolTip() {
        JToolTip tip = super.createToolTip();
        tip.setBackground(Color.black);
        tip.setForeground(Color.white);
        return tip;
      }

}
