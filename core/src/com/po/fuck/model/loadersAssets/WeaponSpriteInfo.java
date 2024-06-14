package com.po.fuck.model.loadersAssets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;

public class WeaponSpriteInfo extends BasicSpriteInfo {
    public Vector2 muzzlePosition;

    public Vector2 holdingPosition;
    public WeaponSpriteInfo(String name) {
        super(name);
        JsonValue jsonValue = Assets.jsonData.get(name);
        muzzlePosition = new Vector2(jsonValue.getInt("muzzlePositionX"),
                jsonValue.getInt("muzzlePositionY"));

        holdingPosition = new Vector2(jsonValue.getInt("holdingPositionX"),
                jsonValue.getInt("holdingPositionY"));
    }
}
