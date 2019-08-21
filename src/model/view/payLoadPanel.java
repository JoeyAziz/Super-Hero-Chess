package model.view;

import java.awt.Color;
import java.awt.Dimension;
import java.net.MalformedURLException;
import javax.swing.JProgressBar;
import javax.swing.JToolTip;
import javax.swing.SwingConstants;

import model.game.Game;

@SuppressWarnings("serial")
public class payLoadPanel extends JProgressBar {
	
	private Game game;

	public payLoadPanel(Game game) throws MalformedURLException {
		
		super( SwingConstants.VERTICAL,0, game.getPayloadPosTarget());
		//JLabel background = new JLabel(new ImageIcon("art/payLoad.gif") );
		this.game = game;
		
		this.setValue(game.getPlayer1().getPayloadPos());
		
		this.setBackground(Color.BLACK);
		changeColor();
		
		this.setPreferredSize(new Dimension(20, mainBoard.HEIGHT));
		updateToolTip();
	}
	
	public void updatepayLoadPanel() {
		this.setValue(game.getPlayer1().getPayloadPos());
		updateToolTip();
		changeColor();
	}
	
	private void changeColor() {
		if(this.getValue() < 3) this.setForeground(Color.yellow);
		else if(this.getValue() <5) this.setForeground(Color.ORANGE);
		else this.setForeground(Color.RED);
	}
	
	private void updateToolTip() {
		this.setToolTipText("<html>"+
				game.getPlayer1().getName() + 
				"'s" 	 +
				"<br>"	 +
				"payLoad :  "	 
						 +
				this.getValue()
						 +
					" / 6"
						 +
				"</html>");
	}
	
	public JToolTip createToolTip() {
        JToolTip tip = super.createToolTip();
        tip.setBackground(Color.BLACK);
        tip.setForeground(Color.red);
        return tip;
      }
}
