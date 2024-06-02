package com.po.fuck.view.classdrawers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.JsonValue;
import com.po.fuck.Assets;
import com.po.fuck.model.Core;

public class Misc {
    public static Animation<TextureRegion> getAnimation(String internalPath){
        return new Animation<TextureRegion>(1f, new Sprite(new Texture(internalPath)));
    }

    public static Animation<TextureRegion> getComplixAnimation(String name) {
        JsonValue info = Assets.getInfo(name);
        Texture animatedTexture = Core.assets.manager.get(info.getString("path"));
        int totalWidth = info.getInt("totalWidth");
        int totalHeight = info.getInt("totalHeight");
        int frameWidth = info.getInt("frameWidth");
        int frameHeight = info.getInt("frameHeight");
        TextureRegion[][] frames = TextureRegion.split(animatedTexture, frameWidth, frameHeight);
        TextureRegion[] frames1 = new TextureRegion[(totalWidth/frameWidth) * (totalHeight/frameHeight)];

        int id = 0;
        for (int i = 0; i < totalHeight/frameHeight; i++) {
            for (int j = 0; j < totalWidth/frameWidth; j++) {
                frames1[id++] = frames[i][j];
            }
        }
        Animation<TextureRegion> X =  new Animation<TextureRegion>(0.025f, frames1);
        X.setPlayMode(Animation.PlayMode.LOOP);
        return X;
    }
}
