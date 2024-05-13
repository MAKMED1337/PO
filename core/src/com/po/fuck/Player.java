package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.weapons.LaserGun;
import com.po.fuck.weapons.Weapon;

/**
 * Class representing the player entity in the game.
 * Inherits from the Entity class and adds functionality specific to the player.
 */
public class Player extends Entity {
    
    protected final Weapon weapon = new LaserGun(this);

    // Controllers
    private final KeyboardController keyboardController = new KeyboardController(this);
    private final MouseController mouseController = new MouseController(this);

    /**
     * Constructs a Player object with the given sprite.
     * Sets up input processors for keyboard and mouse controllers.
     * 
     * @param sprite The sprite representing the visual appearance of the player.
     */
    Player(Sprite sprite) {
        super(sprite);
        health_points = 10;
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(keyboardController);
        multiplexer.addProcessor(mouseController);
        Gdx.input.setInputProcessor(multiplexer);
    }
}
