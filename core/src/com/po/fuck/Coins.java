package com.po.fuck;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Drawable;

import static com.po.fuck.Constants.COINS_COUNTER_POSITION;
import static com.po.fuck.Constants.COIN_SPRITE_POSITION;
import static com.po.fuck.Constants.WIDTH_OF_THE_COIN_COUNTER_DIGIT;
import static com.po.fuck.Constants.COINS_COUNTER_TEXT_SCALE;

public class Coins implements Drawable {
    private int coins = 0;
    private static Sprite sprite = new Sprite(new Texture("coin3.png"));

    public void addCoins(int cnt) {
        coins += cnt;
    }

    @Override
    public void draw(CenterDrawer drawer) {
        BitmapFont font = new BitmapFont();
        font.setColor(Color.YELLOW);
        font.getData().scale(COINS_COUNTER_TEXT_SCALE);
        String text = Integer.toString(coins);
        drawer.drawText(text, font, new Vector2(COINS_COUNTER_POSITION.x, COINS_COUNTER_POSITION.y));
        float len = text.length();
        drawer.draw(sprite, new Vector2(COIN_SPRITE_POSITION.x + WIDTH_OF_THE_COIN_COUNTER_DIGIT * len, COIN_SPRITE_POSITION.y));
    }
}
