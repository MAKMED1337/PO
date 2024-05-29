package com.po.fuck.view.classdrawers.factories;

import static com.po.fuck.model.Constants.WIDTH_OF_THE_COIN_COUNTER_DIGIT;
import static com.po.fuck.model.Constants.COINS_COUNTER_TEXT_SCALE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.model.Coins;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ClassDrawer;

public class CoinDrawerFactory {
    
    static {
        Renderer.addDrawer(Coins.class, CoinDrawerFactory.get(Coins.class, new Sprite(new Texture("coin3.png"))));
    }

    public static <T extends Coins> ClassDrawer<T> get(Class<T> clz, Sprite other_sprite){
        return new ClassDrawer<T>() {
            Sprite sprite = new Sprite(other_sprite);

            @Override
            public <Drawer extends CenterDrawer> void draw(Drawer centerDrawer, T object) {
                Coins coins = (Coins) object;
                
                BitmapFont font = new BitmapFont();

                font.setColor(Color.YELLOW);
                font.getData().scale(COINS_COUNTER_TEXT_SCALE);
                
                String text = Integer.toString(coins.getCoins());
                centerDrawer.drawText(text, font, coins.getCounterPosition());
                
                float len = text.length();
                centerDrawer.drawGlobal(sprite, coins.getPosition().add(WIDTH_OF_THE_COIN_COUNTER_DIGIT * len, 0));
            }
        };
    }
    
}
