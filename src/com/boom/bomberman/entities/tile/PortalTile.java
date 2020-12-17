package com.boom.bomberman.entities.tile;

import com.boom.bomberman.Board;
import com.boom.bomberman.entities.Entity;
import com.boom.bomberman.entities.mob.Player;
import com.boom.bomberman.graphics.Sprite;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class PortalTile extends Tile {

	protected Board _board;
	
	public PortalTile(int x, int y, Board board, Sprite sprite) {
		super(x, y, sprite);
		_board = board;
	}

	public static void playSound(String soundName)
	{
		try
		{
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
			Clip clip = AudioSystem.getClip( );
			clip.open(audioInputStream);
			clip.start( );
		}
		catch(Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}
	}

	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player ) {
			
			if(_board.detectNoEnemies() == false)
				return false;
			
			if(e.getXTile() == getX() && e.getYTile() == getY()) {
				if(_board.detectNoEnemies())
					 playSound("win.wav");
					_board.nextLevel();
			}
			
			return true;
		}
		
		return false;
	}

}
