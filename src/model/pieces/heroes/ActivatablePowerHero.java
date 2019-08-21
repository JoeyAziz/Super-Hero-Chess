package model.pieces.heroes;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.sounds.ButtonSound;
import exceptions.InvalidPowerUseException;
import exceptions.PowerAlreadyUsedException;
import exceptions.WrongTurnException;

public abstract class ActivatablePowerHero extends Hero {

	private boolean powerUsed;

	public ActivatablePowerHero(Player player, Game game, String name) {
		super(player, game, name);
	}

	public void usePower(Direction d, Piece target, Point newPos)
			throws InvalidPowerUseException, WrongTurnException {
		
		try {
			new ButtonSound(new File("sounds/power.wav"));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (getOwner() != getGame().getCurrentPlayer())
			throw new WrongTurnException(this);

		if (powerUsed)
			throw new PowerAlreadyUsedException("Power is already used!",this);

	}

	public boolean isPowerUsed() {
		return powerUsed;
	}

	public void setPowerUsed(boolean powerUsed) {
		this.powerUsed = powerUsed;
	}
}
