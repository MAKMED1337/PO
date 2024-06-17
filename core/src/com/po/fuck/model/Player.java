package com.po.fuck.model;

import static com.po.fuck.assetsManagement.SpriteManagers.basicSpriteManager;
import static com.po.fuck.model.constants.BalanceConstants.DEFAULT_SPEED;
import static com.po.fuck.model.constants.BalanceConstants.PLAYERS_HEALTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.po.fuck.controller.KeyboardController;
import com.po.fuck.controller.MouseController;
import com.po.fuck.model.constants.BalanceConstants;
import com.po.fuck.model.constants.TagsConstants;
import com.po.fuck.model.lifetime.Managed;
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
                        BalanceConstants.BOOST_DISTANCE, BalanceConstants.BOOST_DURATION, BalanceConstants.BOOST_COOLDOWN));
        teamTag = TagsConstants.PLAYER_TEAM_TAG;
    }

    // Controllers
    private final Managed<KeyboardController> keyboardController = Manager.create(new KeyboardController(this));
    private final Managed<MouseController> mouseController = Manager.create(new MouseController(this));

    Player(PositionData positionData) {
        super(new GeometryData(positionData,
                basicSpriteManager.getBasicSpriteInfo(Player.class).getSize()),
                PLAYERS_HEALTH);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(keyboardController.get());
        multiplexer.addProcessor(mouseController.get());
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void destructor() {
        keyboardController.destroy();
        mouseController.destroy();
        super.destructor();
    }
}
