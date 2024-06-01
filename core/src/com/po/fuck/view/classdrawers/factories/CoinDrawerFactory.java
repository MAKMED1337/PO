package com.po.fuck.view.classdrawers.factories;

import static com.po.fuck.view.Constants.WIDTH_OF_THE_COIN_COUNTER_DIGIT;
import static com.po.fuck.view.Constants.COINS_COUNTER_TEXT_SCALE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.model.Coins;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ObjectDrawer;

import static com.po.fuck.view.classdrawers.Misc.getAnimation;

public class CoinDrawerFactory {
    
    static {
        Renderer.addDrawer(Coins.class, CoinDrawerFactory.get(Coins.class, getAnimation("coin3.png")));
    }

    public static <T extends Coins> ObjectDrawer<T> get(Class<T> clz, Animation<TextureRegion> animation){
        return new ObjectDrawer<T>() {

            @Override
            public void draw(CenterDrawer drawer, T object) {
                BitmapFont font = new BitmapFont();
                Sprite coinSprite = new Sprite(animation.getKeyFrame(object.getElapsedTime()));

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
