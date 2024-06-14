package com.po.fuck.model;

import static com.po.fuck.model.Constants.GUI_LAYER;

import com.po.fuck.model.drawables.Drawable;

public class Coins implements Drawable {
    private int coins = 0;

    public int getCoins(){
        return coins;
    }

    public void addCoins(int cnt) {
        coins += cnt;
    }

    @Override
    public int getZ(){
        return GUI_LAYER;
    }
}
