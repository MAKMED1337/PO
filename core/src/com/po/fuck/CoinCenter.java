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
    private static Sprite sprite = new Sprite(new Texture("coin3.png"));
    private final float spritePositionX = 80;
    private final float spritePositionY = 45f;
    private final float numberPosX = 35;
    private final float WidthOfNumber = 17;
    private final float numberPosY = GAME_HEIGHT - 30;
    @Override
    public void draw(CenterDrawer drawer) {
        BitmapFont font = new BitmapFont();
        font.setColor(Color.YELLOW);
        font.getData().scale(1.5f);
        drawer.drawText(((Integer)coins).toString(), font, numberPosX, numberPosY);
        float len = ((Integer) coins).toString().length();
        drawer.draw(sprite, new Vector2(spritePositionX + WidthOfNumber*len, spritePositionY));
    }
}
