package model.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.game.Cell;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

@SuppressWarnings("serial")
public class deathPanel extends JPanel implements ActionListener {

	private ArrayList<cellButton> buttons;
	private Game game;

	public deathPanel(Game game) {
		buttons = new ArrayList<cellButton>();

		this.game = game;
		this.setPreferredSize(new Dimension(40, mainBoard.HEIGHT));
		this.setLayout(new GridLayout(12, 0));
		this.setOpaque(false);
	}

	public void updateDeathPanel(Player currentPlayer) throws IOException {

		int count = currentPlayer.getDeadCharacters().size();
		
		for(cellButton c : buttons) {
			c.setIcon(null);	
			c.setVisible(false);
		}
		this.removeAll();
		buttons.clear();
		
		for(int i =0; i <count; i++) {
			Piece piece = currentPlayer.getDeadCharacters().get(i);
			deathButton icon = new deathButton("");
			Cell temp = new Cell(piece);
			icon.setCell(temp);
			//put icons according to pieces
			if(temp.getPiece().getOwner().equals(game.getPlayer1()))
				icon.updateIcon(1);
			else icon.updateIcon(2);

			icon.setActionCommand("revive");
			icon.addActionListener(this);


			buttons.add(icon);
			this.add(icon);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cellButton currentButton = (cellButton) e.getSource(); 
		if(e.getActionCommand().equals("revive")) {
			cellsPanel.targetCell = currentButton;
		}	
	}
}
