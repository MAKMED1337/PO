package com.po.fuck.model;

import com.po.fuck.model.drawables.Drawable;

public class Coins implements Drawable {
    private int coins = 0;

    public int getCoins() {
        return coins;
    }

    public void addCoins(int cnt) {
        coins += cnt;
    }
}
