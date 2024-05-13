package com.po.fuck.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Entity;
import com.po.fuck.FUCK;
import com.po.fuck.movement.BasicMovement;
import com.po.fuck.updates.Updatable;
import com.po.fuck.weapons.Glock;

import static com.po.fuck.Constants.DEFAULT_SPEED;

/**
 * Class representing an enemy entity in the game.
 * Inherits from the Entity class and adds functionality specific to enemies.
 */
public final class BasicEnemy extends Entity implements Updatable {
    {
        sprite = new Sprite(new Texture("player2.png"));
        weapon = new Glock(this);
        movement = new BasicMovement(this, DEFAULT_SPEED / 10);
    }

    public BasicEnemy(Vector2 position) {
        super(position,5);
    }

    @Override
    public void update(float delta) {
        Vector2 playersPosition = FUCK.player.getPosition();
        weapon.aim(playersPosition);
        weapon.attack();
        movement.setDirection(playersPosition.sub(position));
    }
}
