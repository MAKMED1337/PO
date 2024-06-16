package com.po.fuck.view.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;

public class WeaponSpriteInfo extends BasicSpriteInfo {
    public Vector2 muzzlePosition;

    public Vector2 holdingPosition;
/*
    * muzzlePositionX/Y - the X/Y coordinate on the frame of the muzzle
    * holdingPositionX/Y - the X/Y coordinate on the frame of the holding position (the position of hands)
*/
    public WeaponSpriteInfo(JsonValue info) {
        super(info);
        muzzlePosition = new Vector2(info.getInt("muzzlePositionX"),
                info.getInt("muzzlePositionY"));

        holdingPosition = new Vector2(info.getInt("holdingPositionX"),
                info.getInt("holdingPositionY"));
    }
}
