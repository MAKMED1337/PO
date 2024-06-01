package com.po.fuck.view.classdrawers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Misc {
    public static Animation<TextureRegion> getAnimation(String internalPath){
        return new Animation<TextureRegion>(1f, new Sprite(new Texture(internalPath)));
    }
}
