package com.po.fuck;

public final class Constants {
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    public static final int GAME_WIDTH = 1920;
    public static final int GAME_HEIGHT = 1080;

    /* movement */
    public static final int DEFAULT_SPEED = 500;
    public static final int BOOST_DISTANCE = 700;
    public static final float BOOST_DURATION = 0.3f;
    public static final float BOOST_COOLDOWN = 1f;

    /* physics */
    public static final int COLLISION_ITERATIONS = 3;

    /* health bar */
    public static float HEALTHBAR_OFFSET = 5;

    /* team tags */
    public static final int ENEMY_TEAM_TAG = 0;
    public static final int PLAYER_TEAM_TAG = 1;

    /* coins */
    public static final float SPRITE_COIN_POSITION_X = 80;
    public static final float SPRITE_COIN_POSITION_Y = 45f;
    public static final float COIN_COUNTER_POSITION_X = 35;
    public static final float COIN_COUNTER_POSITION_Y = GAME_HEIGHT - 30;
    public static final float WIDTH_OF_COIN_COUNTER_DIGIT = 17;
    public static final float COINS_COUNTER_TEXT_SCALE = 1.5f;
}
