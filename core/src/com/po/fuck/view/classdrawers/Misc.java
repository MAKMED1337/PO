package com.po.fuck.view.classdrawers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.AssetsManagement.Assets;
import com.po.fuck.AssetsManagement.BasicSpriteData;
import com.po.fuck.view.Sprites.BasicSpriteInfo;

public class Misc {

    public static  Animation<TextureRegion> getAnimation(BasicSpriteInfo info) {
        Texture animatedTexture = Assets.manager.get(info.path);
        int frameWidth = (int) info.getFrameSize().y;
        int frameHeight = (int) info.getFrameSize().x;
        TextureRegion[][] frames = TextureRegion.split(animatedTexture, frameWidth, frameHeight);
        int height = (int) info.getHeight();
        int width = (int) info.getWidth();
        if (width % frameWidth != 0 || height % frameHeight != 0) {
            throw new RuntimeException(info.path + " has wrong frames configuration");
        }
        int frameRowsCount = height / frameHeight;
        int frameColumnsCount = width / frameWidth;
        TextureRegion[] framesOneDimension = new TextureRegion[frameRowsCount * frameColumnsCount];

        int id = 0;
        for (int i = 0; i < frameRowsCount; i++) {
            for (int j = 0; j < frameColumnsCount; j++) framesOneDimension[id++] = frames[i][j];
        }

        Animation<TextureRegion> animation = new Animation<>((float) info.frameDuration, framesOneDimension);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        return animation;
    }
}
