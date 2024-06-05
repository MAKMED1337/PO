package com.po.fuck.model;

public class Coins {
    private int coins = 0;

    public int getCoins(){
        return coins;
    }

    public void addCoins(int cnt) {
        coins += cnt;
    }
}
