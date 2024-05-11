package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player {
    protected final Vector2 position = new Vector2();
    protected final Gun gun = new Gun(this, new Sprite(new Texture("glock2.png")));

    private final Sprite sprite = new Sprite(new Texture("player2.png"));

    // controllers
    private final KeyboardController keyboardController = new KeyboardController(this);
    private final MouseController mouseController = new MouseController(this);


    Player() {
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(keyboardController);
        multiplexer.addProcessor(mouseController);
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void draw(CenterDrawer drawer) {
        drawer.draw(sprite, position);
        gun.draw(drawer);
    }

    public void update(float delta) {
        keyboardController.update(delta);
    }
}
