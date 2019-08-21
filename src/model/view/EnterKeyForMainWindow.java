package model.view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EnterKeyForMainWindow implements KeyListener {

	private mainWindow mw;
	private String ActionCommand;

	public EnterKeyForMainWindow(mainWindow mw, String ActionCommand) {
		this.mw = mw;
		this.ActionCommand = ActionCommand;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) 
			mw.actionPerformed(new ActionEvent(e.getSource(), e.getKeyCode(), ActionCommand));	

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
