package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ObjectDrawer;
import com.po.fuck.model.Room;

import static com.po.fuck.assetsManagement.SpriteManagers.basicSpriteManager;
import static com.po.fuck.view.classdrawers.Misc.getAnimation;

public class RoomDrawerFactory {

    static {
        Renderer.addDrawer(Room.class,
                RoomDrawerFactory.get(Room.class));
    }

    public static <T extends Room> ObjectDrawer<T> get(Class<T> clz){
        Animation<TextureRegion> animation = getAnimation(basicSpriteManager.getBasicSpriteInfo(clz));
        return new ObjectDrawer<T>() {
            @Override
            public void draw(CenterDrawer drawer, T object) {
                drawer.draw(new Sprite(animation.getKeyFrame(0)), object.getPosition());
            }
        };
    }

}