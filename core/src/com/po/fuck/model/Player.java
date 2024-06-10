package com.po.fuck.model;

import static com.po.fuck.model.Constants.DEFAULT_SPEED;
import static com.po.fuck.model.Constants.PLAYERS_HEALTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.po.fuck.controller.KeyboardController;
import com.po.fuck.controller.MouseController;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.movement.BasicMovement;
import com.po.fuck.model.movement.Boost;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.weapons.Glock;
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

    // Controllers
    private final Managed<KeyboardController> keyboardController = Manager.create(new KeyboardController(this));
    private final Managed<MouseController> mouseController = Manager.create(new MouseController(this));

    Player(GeometryData geometryData) {
        super(geometryData, PLAYERS_HEALTH);

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
