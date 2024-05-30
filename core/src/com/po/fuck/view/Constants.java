package com.po.fuck.view;

import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final int GAME_WIDTH = 1920;
    public static final int GAME_HEIGHT = 1080;

    /* health bar */
    public static final float HEALTHBAR_OFFSET = 5;
    public static final int HEALTHBAR_WIDTH = 100;
    public static final int HEALTHBAR_HEIGHT = 10;

    /* coins */
    public static final Vector2 COIN_SPRITE_POSITION = new Vector2(80, 45);
    public static final Vector2 COINS_COUNTER_POSITION = new Vector2(35, GAME_HEIGHT - 30);
    public static final float WIDTH_OF_THE_COIN_COUNTER_DIGIT = 17;
    public static final float COINS_COUNTER_TEXT_SCALE = 1.5f;
}
