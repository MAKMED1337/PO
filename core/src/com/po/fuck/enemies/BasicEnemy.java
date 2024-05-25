package com.po.fuck.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.*;
import com.po.fuck.collections.All;
import com.po.fuck.collections.EntityCollection;
import com.po.fuck.movement.BasicMovement;
import com.po.fuck.updates.Updatable;
import com.po.fuck.weapons.Glock;
import com.po.fuck.weapons.Weapon;
import com.po.fuck.lifetime.Manager;

import java.util.ArrayList;

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
    }

    public BasicEnemy(Vector2 position) {
        super(position, 5);
        this.teamTag = Constants.CREEP_TEAM_TAG;
    }

    @Override
    public void update(float delta) {
        ArrayList<Entity> opponents = All.entityCollection.getOpponents(this.teamTag);
        if (opponents == null) {
            return;
        }
        Entity target = opponents.get(0);
        float dist = GeometryMisc.distance(this, target);
        for (Entity opponent : opponents) {
            if (GeometryMisc.distance(this, opponent) < dist) {
                dist = GeometryMisc.distance(this, opponent);
                target = opponent;
            }
        }

        Vector2 targetPosition = target.getPosition();
        Weapon w = weapon.get();
        if (w == null)
            return;

        w.aim(targetPosition);
        w.attack();
        movement.get().setDirection(targetPosition.sub(position));
    }
}
