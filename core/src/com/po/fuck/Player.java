package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.weapons.LaserGun;
import com.po.fuck.weapons.Weapon;

public class Player extends Entity {
    
    protected final Weapon weapon = new LaserGun(this);

    // controllers
    private final KeyboardController keyboardController = new KeyboardController(this);
    private final MouseController mouseController = new MouseController(this);

    Player(Sprite sprite) {
        super(sprite);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(keyboardController);
        multiplexer.addProcessor(mouseController);
        Gdx.input.setInputProcessor(multiplexer);
    }
}
