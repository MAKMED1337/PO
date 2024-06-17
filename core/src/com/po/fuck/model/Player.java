package com.po.fuck.model;

import static com.po.fuck.model.Constants.DEFAULT_SPEED;
import static com.po.fuck.model.Constants.PLAYERS_HEALTH;

import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.movement.BasicMovement;
import com.po.fuck.model.movement.Boost;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.weapons.LaserGun;

/**
 * Class representing the player entity in the game.
 * Inherits from the Entity class and adds functionality specific to the player.
 */
public class Player extends Entity {
    {
        weapon = Manager.create(new LaserGun(this));
        movement = Manager.create(
                new Boost(
                        new BasicMovement(this, DEFAULT_SPEED),
                        Constants.BOOST_DISTANCE, Constants.BOOST_DURATION, Constants.BOOST_COOLDOWN));
        teamTag = Constants.PLAYER_TEAM_TAG;
    }

    Player(GeometryData geometryData) {
        super(geometryData, PLAYERS_HEALTH);
    }
}
