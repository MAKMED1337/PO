package com.po.fuck.model;

import static com.po.fuck.assetsManagement.SpriteLoaders.basicSpriteLoader;
import static com.po.fuck.model.constants.BalanceConstants.DEFAULT_SPEED;
import static com.po.fuck.model.constants.BalanceConstants.PLAYERS_HEALTH;

import com.po.fuck.model.constants.BalanceConstants;
import com.po.fuck.model.constants.TagsConstants;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.movement.BasicMovement;
import com.po.fuck.model.movement.Boost;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.position.PositionData;
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
                        BalanceConstants.BOOST_DISTANCE, BalanceConstants.BOOST_DURATION,
                        BalanceConstants.BOOST_COOLDOWN));
        teamTag = TagsConstants.PLAYER_TEAM_TAG;
    }

    Player(PositionData positionData) {
        super(new GeometryData(positionData,
                basicSpriteLoader.getSpriteInfo(Player.class).getSize()),
                PLAYERS_HEALTH);
    }
}
