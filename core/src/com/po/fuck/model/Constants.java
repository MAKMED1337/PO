package com.po.fuck.model;

public final class Constants {
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    /* movement */
    public static final int DEFAULT_SPEED = 500;
    public static final int BOOST_DISTANCE = 700;
    public static final float BOOST_DURATION = 0.3f;
    public static final float BOOST_COOLDOWN = 1f;

    /* physics */
    public static final int COLLISION_ITERATIONS = 3;

    /* team tags */
    public static final int ENEMY_TEAM_TAG = 0;
    public static final int PLAYER_TEAM_TAG = 1;

    /* camera */
    public static final float CAMERA_SPEED = 10;

    /* layering */
    public static final int BACKGROUND_LAYER = 0;
    public static final int ENTITY_LAYER = 1;
    public static final int WEAPON_LAYER = 2;
    public static final int GUI_LAYER = 19;

    /* borders */
    public static final int GAME_BORDER = 20000;

    /* bullets */ /* TODO: move to .properties */
	public static final float COSMIC_BULLET_LIFE_TIME = 10f;
    public static final float COSMIC_BULLET_DAMAGE = 1f;
    public static final float LASER_BEAM_DAMAGE = 3f; 
    public static final float LASER_BEAM_LIFE_TIME = 1f;
    public static final float DEFAULT_BULLET_LIFE_TIME = 60f;
}
