package model.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class superPanel extends JPanel implements ActionListener {
	
	public superPanel(movementPanel m) throws IOException  {
		this.setOpaque(false);
		superButton b = new superButton();
		this.add(b).setPreferredSize(new Dimension(50, 50));
		b.addActionListener(m);
		b.setActionCommand("super");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
