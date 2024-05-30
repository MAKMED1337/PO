package com.po.fuck.model;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.view.Drawable;

import static com.po.fuck.view.Constants.COINS_COUNTER_POSITION;
import static com.po.fuck.view.Constants.COIN_SPRITE_POSITION;
import static com.po.fuck.model.Constants.GUI_LAYER;

public class Coins implements Drawable {
    private int coins = 0;

    public int getCoins(){
        return coins;
    }

    public void addCoins(int cnt) {
        coins += cnt;
    }
    @Override
    public int get_z() {
        return GUI_LAYER;
    }

    @Override
    public Vector2 getPosition(){
        return new Vector2(COIN_SPRITE_POSITION.x, COIN_SPRITE_POSITION.y);
    }

    public Vector2 getCounterPosition(){
        return new Vector2(COINS_COUNTER_POSITION.x, COINS_COUNTER_POSITION.y);
    }
}
