package com.boom.bomberman.entities.mob.enemy;

import com.boom.bomberman.Board;
import com.boom.bomberman.Game;
import com.boom.bomberman.entities.Message;
import com.boom.bomberman.entities.mob.enemy.ai.AIMedium;
import com.boom.bomberman.graphics.Sprite;

import java.awt.*;

public class Vip extends Enemy{
    public Vip(int x, int y, Board board) {
        super(x, y, board, Sprite.vip_dead, Game.getPlayerSpeed() / 1.5, 3000);

         _sprite = Sprite.vip_right1;

        _ai = new AIMedium(_board.getPlayer(), this); //TODO: implement AIHigh
        _direction = _ai.calculateDirection();
    }





    /*
    |--------------------------------------------------------------------------
    | Mob Sprite
    |--------------------------------------------------------------------------
     */
    @Override
    protected void chooseSprite() {
        switch (_direction) {
            case 0:

            case 1:
                if (_moving)
                    _sprite = Sprite.movingSprite(Sprite.vip_right1, Sprite.vip_right2, Sprite.vip_right3, _animate, 60);
                else
                    _sprite = Sprite.vip_left1;
                break;


            case 2:

            case 3:
                if (_moving)
                    _sprite = Sprite.movingSprite(Sprite.vip_left1, Sprite.vip_left2, Sprite.vip_left3, _animate, 60);
                else
                    _sprite = Sprite.vip_left1;
                break;

        }
    }
}
