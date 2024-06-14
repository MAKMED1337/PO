package com.po.fuck.view.classdrawers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.Assets;
import com.po.fuck.model.loadersAssets.BasicSpriteInfo;

public class Misc {

    public static Animation<TextureRegion> getComplexAnimation(String name) {
        BasicSpriteInfo info = Assets.getBasicAssetInfo(name);
        Texture animatedTexture = Assets.manager.get(info.path);

        TextureRegion[][] frames = TextureRegion.split(animatedTexture, info.frameWidth, info.frameHeight);
        int height = (int) info.size().x;
        int width = (int) info.size().y;
        if (width % info.frameWidth != 0 || height%info.frameHeight != 0) {
            throw new RuntimeException(info.path + "has wrong frames configuration");
        }
        int frameRowsCount = height / info.frameHeight;
        int frameColumnsCount = width / info.frameWidth;
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
