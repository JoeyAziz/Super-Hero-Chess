package model.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.game.Cell;
import model.game.Game;
import model.game.Player;
import model.sounds.ButtonSound;

@SuppressWarnings("serial")
public class cellsPanel extends JPanel implements ActionListener {
	private ArrayList<cellButton> cells = new ArrayList<cellButton>();
	private ArrayList<Point> points = new ArrayList<Point>();
	private Game game;

	private static int clicks = 0;
	private static Player turn;

	public static cellButton targetCell;
	public static cellButton currentCell;
	public static Point 	 pointCell;


	public cellsPanel(Game game) throws IOException {
		this.game = game;
		this.setLayout(new GridLayout(game.getBoardHeight(), game.getBoardWidth()));
		this.setOpaque(false);

		createCells();

	}

	private void createCells() throws IOException {
		for(int i = 0; i<game.getBoardHeight(); i++) {
			for(int j = 0; j<game.getBoardWidth(); j++) {
				Cell cell = game.getCellAt(i, j);
				cellButton c = new cellButton("");
				c.setCell(cell);
				if(cell.getPiece()!= null) {
					if(cell.getPiece().getOwner().equals(game.getPlayer1()))
						c.updateIcon(1);
					else c.updateIcon(2);
				}
				points.add(new Point(i,j));
				cells.add(c);
				this.add(c);
				c.addActionListener(this);
			}
		}
	}

	public void updateCells() throws IOException {
		cells.clear();
		this.removeAll();
		this.createCells();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cellButton currentButton = (cellButton) e.getSource(); 
		
		try {
			new ButtonSound(new File("sounds/button click.wav"));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(game.getCurrentPlayer() != turn) {
			clicks = 0;
			turn = game.getCurrentPlayer();
		}

		clicks++;

		if(clicks == 1) {	
			targetCell = null;
			pointCell = null;
			
			for( cellButton c : cells)
				c.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			if(game.getCurrentPlayer().equals(game.getPlayer1()))
				currentButton.setBorder(BorderFactory.createLineBorder(Color.green));
			else currentButton.setBorder(BorderFactory.createLineBorder(Color.blue));
			
			currentCell = cells.get(cells.indexOf(currentButton));
			
		}
		else if(clicks == 2) {
			if(targetCell != null) {
				//System.out.println(targetCell.getCell().getPiece().toString());
				currentButton.setBorder(BorderFactory.createLineBorder(Color.black));
			}else {
				currentButton.setBorder(BorderFactory.createLineBorder(Color.red));
				targetCell = cells.get(cells.indexOf(currentButton));
			}
		}		
		else if(clicks == 3) {			
			currentButton.setBorder(BorderFactory.createLineBorder(Color.black));
			pointCell = points.get(cells.indexOf(currentButton));
			
			clicks = 0;
		}
			
		//System.out.println(currentCell.getCell().getPiece().toString());
	}

	public ArrayList<cellButton> getCells() {
		return cells;
	}
	
	

}
