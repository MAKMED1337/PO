package com.po.fuck.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.Constants;
import com.po.fuck.GeometryMisc;
import com.po.fuck.Entity;
import com.po.fuck.collections.All;
import com.po.fuck.movement.BasicMovement;
import com.po.fuck.updates.Updatable;
import com.po.fuck.weapons.Glock;
import com.po.fuck.weapons.Weapon;
import com.po.fuck.lifetime.Manager;


import static com.po.fuck.Constants.DEFAULT_SPEED;

/**
 * Class representing an enemy entity in the game.
 * Inherits from the Entity class and adds functionality specific to enemies.
 */
public final class BasicEnemy extends Entity implements Updatable {
    {
        sprite = new Sprite(new Texture("player2.png"));
        weapon = Manager.create(new Glock(this));
        movement = Manager.create(new BasicMovement(this, DEFAULT_SPEED / 10));
        teamTag = Constants.ENEMY_TEAM_TAG;
    }

    public BasicEnemy(Vector2 position) {
        super(position, 5);
    }

    @Override
    public void update(float delta) {
        Entity target = GeometryMisc.findClosest(this, All.entityCollection.getOpponents(this.teamTag));
        if (target == null) return;
        Vector2 targetPosition = target.getPosition();
        Weapon w = weapon.get();
        if (w == null) return;

        w.aim(targetPosition);
        w.attack();
        movement.get().setDirection(targetPosition.sub(position));
    }
}
