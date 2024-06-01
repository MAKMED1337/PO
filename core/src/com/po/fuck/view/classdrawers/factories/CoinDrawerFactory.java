package com.po.fuck.view.classdrawers.factories;

import static com.po.fuck.view.Constants.WIDTH_OF_THE_COIN_COUNTER_DIGIT;
import static com.po.fuck.view.Constants.COINS_COUNTER_TEXT_SCALE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.model.Coins;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ObjectDrawer;

public class CoinDrawerFactory {
    
    static {
        Renderer.addDrawer(Coins.class, CoinDrawerFactory.get(Coins.class, new Sprite(new Texture("coin3.png"))));
    }

    public static <T extends Coins> ObjectDrawer<T> get(Class<T> clz, Sprite sprite){
        return new ObjectDrawer<T>() {
            Sprite coinSprite = new Sprite(sprite);

            @Override
            public void draw(CenterDrawer drawer, T object) {
                BitmapFont font = new BitmapFont();

                font.setColor(Color.YELLOW);
                font.getData().scale(COINS_COUNTER_TEXT_SCALE);
                
                String text = Integer.toString(object.getCoins());
                drawer.drawText(text, font, object.getCounterPosition());
                
                float len = text.length();
                drawer.drawGlobal(coinSprite, object.getPosition().add(WIDTH_OF_THE_COIN_COUNTER_DIGIT * len, 0));
            }
        };
    }
    
}
