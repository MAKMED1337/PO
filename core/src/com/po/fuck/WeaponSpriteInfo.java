package com.po.fuck;

public class WeaponSpriteInfo extends BasicSpriteInfo {
    public int muzzlePositionX;

    public int muzzlePositionY;

    public int holdingPositionX;

    public int holdingPositionY;
    public WeaponSpriteInfo(String name) {
        super(name);
        muzzlePositionX = Assets.jsonData.get(name).getInt("muzzlePositionX");
        muzzlePositionY = Assets.jsonData.get(name).getInt("muzzlePositionY");

        holdingPositionX = Assets.jsonData.get(name).getInt("holdingPositionX");
        holdingPositionY = Assets.jsonData.get(name).getInt("holdingPositionY");
    }
}
