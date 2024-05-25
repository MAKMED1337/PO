package com.po.fuck.view;

import static com.po.fuck.model.Constants.GAME_HEIGHT;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class CenterDrawer {
    private final SpriteBatch batch;

    public CenterDrawer(SpriteBatch batch) {
        this.batch = batch;
    }

    public void draw(Sprite sprite, Vector2 position) {
        Vector2 pos = position.cpy();
        pos.sub(sprite.getWidth() / 2, -sprite.getHeight() / 2);
        pos.y = GAME_HEIGHT - pos.y;

        sprite.setPosition(pos.x, pos.y);
        sprite.draw(batch);
    }
}
