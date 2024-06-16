package com.po.fuck.view.classdrawers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.AssetsManagement.AssetsTextureLoader;
import com.po.fuck.model.Sprites.BasicSpriteInfo;

public class Misc {

    public static  Animation<TextureRegion> getAnimation(BasicSpriteInfo info) {

        Texture animatedTexture = AssetsTextureLoader.getTexture(info.getPath());
        int frameWidth = (int) info.getSize().y;
        int frameHeight = (int) info.getSize().x;
        int height = animatedTexture.getHeight();
        int width = animatedTexture.getWidth();
        if (width % frameWidth != 0 || height % frameHeight != 0) {
            throw new RuntimeException(info.getPath() + " has wrong frames configuration");
        }
        TextureRegion[][] frames = TextureRegion.split(animatedTexture, frameWidth, frameHeight);
        int frameRowsCount = height / frameHeight;
        int frameColumnsCount = width / frameWidth;
        TextureRegion[] framesOneDimension = new TextureRegion[frameRowsCount * frameColumnsCount];

        int id = 0;
        for (int i = 0; i < frameRowsCount; i++) {
            for (int j = 0; j < frameColumnsCount; j++) framesOneDimension[id++] = frames[i][j];
        }

        Animation<TextureRegion> animation = new Animation<>(info.getFrameDur(), framesOneDimension);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        return animation;
    }
}
