package com.po.fuck.model.enemies;

import static com.po.fuck.model.Constants.DEFAULT_SPEED;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Core;
import com.po.fuck.controller.movement.BasicMovement;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Player;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.Weapon;

/**
 * Class representing an enemy entity in the game.
 * Inherits from the Entity class and adds functionality specific to enemies.
 */
public final class BasicEnemy extends Entity implements Updatable {
    {
        sprite = new Sprite(new Texture("player2.png"));
        weapon = Manager.create(new Glock(this));
        movement = Manager.create(new BasicMovement(this, DEFAULT_SPEED / 10));
    }

    public BasicEnemy(Vector2 position) {
        super(position, 5);
    }

    @Override
    public void update(float delta) {
        Player player = Core.player.get();
        if (player == null)
            return;

        Vector2 playersPosition = player.getPosition();
        Weapon w = weapon.get();
        if (w == null)
            return;

        w.aim(playersPosition);
        w.attack();
        movement.get().setDirection(playersPosition.sub(position));
    }
}
