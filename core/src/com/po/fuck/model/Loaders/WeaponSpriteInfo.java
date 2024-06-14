package com.po.fuck.model.Loaders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;
import com.po.fuck.model.Loaders.BasicSpriteInfo;

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
