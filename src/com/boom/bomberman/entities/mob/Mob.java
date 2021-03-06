package com.boom.bomberman.entities.mob;

import com.boom.bomberman.Board;
import com.boom.bomberman.Game;
import com.boom.bomberman.entities.AnimatedEntitiy;
import com.boom.bomberman.graphics.Screen;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public abstract class Mob extends AnimatedEntitiy {
	
	protected Board _board;
	protected int _direction = -1;
	protected boolean _alive = true;
	protected boolean _moving = false;
	public int _timeAfter = 80;
	
	public Mob(int x, int y, Board board) {
		_x = x;
		_y = y;
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
	public abstract void update();
	
	@Override
	public abstract void render(Screen screen);
	
	protected abstract void calculateMove();
	
	protected abstract void move(double xa, double ya);
	
	public abstract void kill();
	
	protected abstract void afterKill();
	
	protected abstract boolean canMove(double x, double y);
	
	public boolean isAlive() {
		return _alive;
	}
	
	public boolean isMoving() {
		return _moving;
	}
	
	public int getDirection() {
		return _direction;
	}
	
	protected double getXMessage() {
		return (_x * Game.SCALE) + (_sprite.SIZE / 2 * Game.SCALE);
	}
	
	protected double getYMessage() {
		return (_y* Game.SCALE) - (_sprite.SIZE / 2 * Game.SCALE);
	}
	
}
