package model.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.NonActivatablePowerHero;

@SuppressWarnings("serial")
public class movementPanel extends JPanel implements ActionListener {

	private ArrayList<directionButton> directions = new ArrayList<directionButton>();
	
	private mainBoard main;

	private Game game;
	public static Direction currentDirection;
	
	public movementPanel(Game game, mainBoard main) throws IOException {
		this.main = main;
		this.game = game;
		this.setLayout(new GridLayout(3,3));
		this.setOpaque(false);

		this.setPreferredSize(new Dimension(100,50));

		for(Direction r : Direction.values()) {
			if(r == Direction.RIGHT){
				moveButton b = new moveButton();
				b.setActionCommand("move");
				b.addActionListener(this);
				this.add(b);
			}
			directionButton b = new directionButton(r);
			b.addActionListener(this);
			directions.add(b);
			this.add(b);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(cellsPanel.currentCell != null ) {
			Piece currentPiece = cellsPanel.currentCell.getCell().getPiece();
			if(currentPiece != null) {
				if(e.getSource() instanceof directionButton) {
					directionButton currentButton = (directionButton) e.getSource(); 
					currentDirection = directions.get(directions.indexOf(currentButton)).getDirection();
					//System.out.println(currentDirection);
				}
				//movement
				if(e.getActionCommand().equals("move")) {
					
					try {
						if(currentDirection == null)
							main.control_panel.exPanel.setText("choose your direction!");
						else {
							currentPiece.move(currentDirection);
							main.control_panel.exPanel.HideText();
							//updateBoard
							try {
								updateBoard();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} 
					catch (UnallowedMovementException e1) 
					{
						System.out.println(e1.toString());
						main.control_panel.exPanel.setText("You can't move here!");
					} 
					catch (OccupiedCellException e1) 
					{
						main.control_panel.exPanel.setText("That's a friendly piece!");
						System.out.println(e1.toString());
					} 
					catch (WrongTurnException e1) 
					{
						main.control_panel.exPanel.setText("Wait for your turn!");
						System.out.println(e1.toString());
					}
					currentDirection = null;
					//System.out.println(currentPiece.toString());
				}
				//super
				else if(e.getActionCommand().equals("super")) {
					if(currentPiece instanceof NonActivatablePowerHero) {
						main.control_panel.exPanel.setText("This piece has no power to use!");
						return ;
					}
					if(currentDirection == null) 
							main.control_panel.exPanel.setText("choose your direction!");					
					else {
						Point p = cellsPanel.pointCell;
													
						Piece target = cellsPanel.targetCell.getCell().getPiece();
						try {
							((ActivatablePowerHero) currentPiece).usePower(currentDirection,target,p);
							main.control_panel.exPanel.HideText();
							//updateBoard
							try {
								updateBoard();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (InvalidPowerUseException e2) {
							main.control_panel.exPanel.setText(e2.getMessage());
							System.out.println(e2.toString());
						} catch (WrongTurnException e2) {
							main.control_panel.exPanel.setText("Wait for your turn!");
							System.out.println(e2.toString());
						}
					}
				}
			}

		}
	}
	
	private void updateBoard() throws IOException {
		
		main.deathPanelP1.updateDeathPanel(game.getPlayer1());
		main.deathPanelP2.updateDeathPanel(game.getPlayer2());

		main.payLoadPanelP2.updatepayLoadPanel();
		main.payLoadPanelP1.updatepayLoadPanel();
		main.CellsPanel.updateCells();
		//Current Player Label		
		main.control_panel.updateCurrentPlayerLabel(game);
		checkWinner();
		
	}
	
	private void checkWinner() throws IOException {
		if( game.getPlayer1().getPayloadPos() == game.getPayloadPosTarget() ) {
			main.control_panel.setVisible(false);
			new GameOver(game.getPlayer1());
		}else if( game.getPlayer2().getPayloadPos() == game.getPayloadPosTarget() ) {
			main.control_panel.setVisible(false);
			new GameOver(game.getPlayer2());
		}
	}
}
