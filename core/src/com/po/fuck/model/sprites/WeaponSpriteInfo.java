package com.po.fuck.model.sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;

public class WeaponSpriteInfo extends BasicSpriteInfo {
    public final Vector2 muzzlePosition;

    public final Vector2 holdingPosition;
/*
    * muzzlePositionX/Y - the X/Y coordinate on the frame of the muzzle
    * holdingPositionX/Y - the X/Y coordinate on the frame of the holding position (the position of hands)
*/
    public WeaponSpriteInfo(JsonValue info) {
        super(info);
        muzzlePosition = new Vector2(info.getInt("muzzlePositionX"),
                info.getInt("muzzlePositionY"));
        muzzlePosition.sub(new Vector2(getWidth(), getHeight()/2));

        holdingPosition = new Vector2(info.getInt("holdingPositionX"),
                info.getInt("holdingPositionY"));
    }
}
