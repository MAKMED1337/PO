package com.po.fuck.view.classdrawers.factories;

import static com.po.fuck.view.Constants.WIDTH_OF_THE_COIN_COUNTER_DIGIT;
import static com.po.fuck.view.Constants.COINS_COUNTER_POSITION;
import static com.po.fuck.view.Constants.COINS_COUNTER_TEXT_SCALE;
import static com.po.fuck.view.Constants.COIN_SPRITE_POSITION;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.AssetsManagement.BasicSpriteManager;
import com.po.fuck.model.Coins;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ObjectDrawer;

import static com.po.fuck.view.classdrawers.Misc.getAnimation;

public class CoinDrawerFactory {
    
    static {
        Renderer.addDrawer(Coins.class, CoinDrawerFactory.get(Coins.class,
                getAnimation(BasicSpriteManager.getBasicSpriteInfo(Coins.class))));
    }

    public static <T extends Coins> ObjectDrawer<T> get(Class<T> clz, Animation<TextureRegion> animation){
        return new ObjectDrawer<T>() {
            
            @Override
            public void draw(CenterDrawer drawer, T object) {
                BitmapFont font = new BitmapFont();
                Sprite coinSprite = new Sprite(animation.getKeyFrame(0));

                font.setColor(Color.YELLOW);
                font.getData().scale(COINS_COUNTER_TEXT_SCALE);
                
                String text = Integer.toString(object.getCoins());

                Vector2 counterPosition = new Vector2(COINS_COUNTER_POSITION.x, COINS_COUNTER_POSITION.y);

                drawer.drawText(text, font, counterPosition);

                Vector2 position = new Vector2(COIN_SPRITE_POSITION.x, COIN_SPRITE_POSITION.y);
                
                float len = text.length();
                drawer.drawGlobal(coinSprite, position.add(WIDTH_OF_THE_COIN_COUNTER_DIGIT * len, 0));
            }
        };
    }
    
}
