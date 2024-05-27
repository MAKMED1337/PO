package com.po.fuck;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Drawable;
import static com.po.fuck.Constants.GAME_HEIGHT;

public class CoinCenter implements Drawable {
    public static int coins = 0;
    private static Sprite sprite = new Sprite(new Texture("coin2.png"));
    BitmapFont font;
    private final Vector2 spritePosition = new Vector2(100, 55);
    private final float numberPosX = 30;
    private final float numberPosY = GAME_HEIGHT - 30;
    @Override
    public void draw(CenterDrawer drawer) {
        font = new BitmapFont();
        font.setColor(Color.YELLOW);
        font.getData().scale(3);
        drawer.drawText(((Integer)coins).toString(), font, numberPosX, numberPosY);
        drawer.draw(sprite, spritePosition);
    }
}
