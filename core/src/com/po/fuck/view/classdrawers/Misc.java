package com.po.fuck.view.classdrawers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Misc {
    public static Animation<TextureRegion> getAnimation(String internalPath){
        // 0f is a dummy value. It denotes the duration of each frame. As we have 1 frame, it does not really matter.
        return new Animation<TextureRegion>(0f, new Sprite(new Texture(internalPath)));
    }
}
