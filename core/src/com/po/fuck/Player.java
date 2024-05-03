package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class Player implements Disposable {
    private final Vector2 position = new Vector2();
    private final InputController input_controller = new InputController(position);

    private final Vector2 size = Constants.PLAYER_SIZE;

    private final Texture sprite = new Texture("player.png");


    Player() {
        Gdx.input.setInputProcessor(input_controller);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(sprite, position.x, position.y, size.x, size.y);
    }

    public void update(float delta) {
        input_controller.update(delta);
    }

    @Override
    public void dispose() {
        sprite.dispose();
    }
}
