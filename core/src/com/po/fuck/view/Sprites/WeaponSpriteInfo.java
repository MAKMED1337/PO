package com.po.fuck.view.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.AssetsManagment.Assets;

public class WeaponSpriteInfo extends BasicSpriteInfo {
    public Vector2 muzzlePosition;

    public Vector2 holdingPosition;
/*
    * muzzlePositionX/Y - the X/Y coordinate on the frame of the muzzle
    * holdingPositionX/Y - the X/Y coordinate on the frame of the holding position (the position of hands)
*/
    public WeaponSpriteInfo(String name) {
        super(name);
        JsonValue jsonValue = Assets.jsonData.get(name);
        muzzlePosition = new Vector2(jsonValue.getInt("muzzlePositionX"),
                jsonValue.getInt("muzzlePositionY"));

        holdingPosition = new Vector2(jsonValue.getInt("holdingPositionX"),
                jsonValue.getInt("holdingPositionY"));
    }
}
