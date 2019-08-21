package model.view;

import java.awt.Dimension;
import java.io.IOException;


@SuppressWarnings("serial")
public class deathButton extends cellButton {
	
	public deathButton(String s) throws IOException {
		super(s);
		this.setPreferredSize(new Dimension(30, 30));
		//this.setOpaque(false);				
		this.setBorderPainted(false);
		//this.setContentAreaFilled(false);
		
	}

}
