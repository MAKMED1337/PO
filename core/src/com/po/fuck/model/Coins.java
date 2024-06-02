package com.po.fuck.model;

public class Coins {
    private int coins = 0;

    public int getCoins(){
        return coins;
    }

    public void addCoins(int cnt) {
        coins += cnt;
    }

    // @Override
    // public int get_z() {
    //     return GUI_LAYER;
    // }

    // @Override
    // public Vector2 getPosition(){
    //     return new Vector2(COIN_SPRITE_POSITION.x, COIN_SPRITE_POSITION.y);
    // }

    // public Vector2 getCounterPosition(){
    //     return new Vector2(COINS_COUNTER_POSITION.x, COINS_COUNTER_POSITION.y);
    // }

    // @Override
    // public GeometryData getGeometryData() {
    //     return new GeometryData(geometryData);
    // }
}
