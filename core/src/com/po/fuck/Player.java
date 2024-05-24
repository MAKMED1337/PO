package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.movement.BasicMovement;
import com.po.fuck.movement.Boost;
import com.po.fuck.weapons.Glock;

import static com.po.fuck.Constants.DEFAULT_SPEED;

/**
 * Class representing the player entity in the game.
 * Inherits from the Entity class and adds functionality specific to the player.
 */
public class Player extends Entity {
    {
        sprite = new Sprite(FUCK.assets.manager.get(Assets.playerTexture));
        weapon = new Glock(this);
        health_points = 10;
        movement = new Boost(
                new BasicMovement(this, DEFAULT_SPEED),
                Constants.BOOST_DISTANCE, Constants.BOOST_DURATION, Constants.BOOST_COOLDOWN
        );
    }

    // Controllers
    private final KeyboardController keyboardController = new KeyboardController(this);
    private final MouseController mouseController = new MouseController(this);

    Player(Vector2 position) {
        super(position,10);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(keyboardController);
        multiplexer.addProcessor(mouseController);
        Gdx.input.setInputProcessor(multiplexer);
    }
}
