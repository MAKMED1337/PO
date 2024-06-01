package com.po.fuck.model;

import static com.po.fuck.model.Constants.DEFAULT_SPEED;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.controller.KeyboardController;
import com.po.fuck.controller.MouseController;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.movement.BasicMovement;
import com.po.fuck.model.movement.Boost;
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
        width = new Sprite(new Texture("FUCKerWithoutHands2.png")).getWidth();
        height = new Sprite(new Texture("FUCKerWithoutHands2.png")).getHeight();
    }

    // Controllers
    private final Managed<KeyboardController> keyboardController = Manager.create(new KeyboardController(this));
    private final Managed<MouseController> mouseController = Manager.create(new MouseController(this));

    Player(Vector2 position) {
        super(position, 100);

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
