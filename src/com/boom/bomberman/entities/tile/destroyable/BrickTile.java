package com.boom.bomberman.entities.tile.destroyable;


import com.boom.bomberman.entities.Entity;
import com.boom.bomberman.entities.bomb.DirectionalExplosion;
import com.boom.bomberman.entities.mob.enemy.Boss;
import com.boom.bomberman.entities.mob.enemy.Kondoria;
import com.boom.bomberman.entities.mob.enemy.Vip;
import com.boom.bomberman.graphics.Screen;
import com.boom.bomberman.graphics.Sprite;
import com.boom.bomberman.level.Coordinates;

public class BrickTile extends DestroyableTile {
	
	public BrickTile(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	@Override
	public void render(Screen screen) {
		int x = Coordinates.tileToPixel(_x);
		int y = Coordinates.tileToPixel(_y);
		
		if(_destroyed) {
			_sprite = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2);
			
			screen.renderEntityWithBelowSprite(x, y, this, _belowSprite);
		}
		else
			screen.renderEntity( x, y, this);
	}
	
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof DirectionalExplosion)
			destroy();
		
		if(e instanceof Kondoria)
			return true;

		if(e instanceof Boss)
			return true;

		if(e instanceof Vip)
        	return true;
		return false;
	}
	
	
}
