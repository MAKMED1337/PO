package com.po.fuck;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Drawable;

import static com.po.fuck.Constants.coinNumberPosX;
import static com.po.fuck.Constants.coinNumberPosY;
import static com.po.fuck.Constants.spriteCoinPositionY;
import static com.po.fuck.Constants.spriteCoinPositionX;
import static com.po.fuck.Constants.widthOfCoinNumber;


public class Coins implements Drawable {
    private int coins = 0;
    private static Sprite sprite = new Sprite(new Texture("coin3.png"));

    void addCoins(int cnt) {
        coins += cnt;
    }

    @Override
    public void draw(CenterDrawer drawer) {
        BitmapFont font = new BitmapFont();
        font.setColor(Color.YELLOW);
        font.getData().scale(1.5f);
        String text = ((Integer)coins).toString();
        drawer.drawText(text, font, new Vector2(coinNumberPosX, coinNumberPosY));
        float len = text.length();
        drawer.draw(sprite, new Vector2(spriteCoinPositionX + widthOfCoinNumber * len, spriteCoinPositionY));
    }
}
