package com.po.fuck.view;

import static com.po.fuck.view.Constants.GAME_HEIGHT;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class CenterDrawer {
    protected final SpriteBatch batch;
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
    
    public void drawGlobal(Sprite sprite, Vector2 globalPosition) {
        draw(sprite, globalPosition);
    }

    public void drawText(String text, BitmapFont font, Vector2 position) {
        font.draw(batch, text, position.x, position.y);
    }
}
