package com.po.fuck.view.classdrawers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.Assets;
import com.po.fuck.BasicSpriteInfo;

public class Misc {

    public static Animation<TextureRegion> getComplexAnimation(String name) {
        BasicSpriteInfo info =Assets.getAssetInfo(name);
        Texture animatedTexture = Assets.manager.get(info.path);

        TextureRegion[][] frames = TextureRegion.split(animatedTexture, info.frameWidth, info.frameHeight);
        if (info.width%info.frameWidth != 0 || info.height%info.frameHeight != 0) {
            throw new RuntimeException("info.width modulo info.frameWidth is not 0 or info.height" +
                    " modulo info.frameHeight is not 0");
        }
        TextureRegion[] frames1 = new TextureRegion[(info.width / info.frameWidth) * (info.height / info.frameHeight)];

        int id = 0;
        for (int i = 0; i < info.height/info.frameHeight; i++) {
            for (int j = 0; j < info.width/info.frameWidth; j++) frames1[id++] = frames[i][j];
        }

        Animation<TextureRegion> animation = new Animation<>((float) info.frameDuration, frames1);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        return animation;
    }
}
