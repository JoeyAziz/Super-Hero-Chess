package model.view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.game.Direction;

public class KeyBoardControls implements KeyListener {
	private movementPanel mp;
	public KeyBoardControls(movementPanel mp) {
		this.mp = mp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_W: //up
				movementPanel.currentDirection = Direction.UP;
				mp.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), "move"));
				break;
			case KeyEvent.VK_S: //down
				movementPanel.currentDirection = Direction.DOWN;
				mp.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), "move"));
				break;
			case KeyEvent.VK_A: //left
				movementPanel.currentDirection = Direction.LEFT;
				mp.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), "move"));
				break;
			case KeyEvent.VK_D: //right
				movementPanel.currentDirection = Direction.RIGHT;
				mp.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), "move"));
				break;
			case KeyEvent.VK_E: //up right
				movementPanel.currentDirection = Direction.UPRIGHT;
				mp.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), "move"));
				break;
			case KeyEvent.VK_Q: //up left
				movementPanel.currentDirection = Direction.UPLEFT;
				mp.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), "move"));
				break;
			case KeyEvent.VK_C: //down right
				movementPanel.currentDirection = Direction.DOWNRIGHT;
				mp.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), "move"));
				break;
			case KeyEvent.VK_Z: //down left
				movementPanel.currentDirection = Direction.DOWNLEFT;
				mp.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), "move"));
				break;				
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
