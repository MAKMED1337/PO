package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.po.fuck.Assets;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.Misc;
import com.po.fuck.view.classdrawers.ObjectDrawer;
import com.po.fuck.model.Room;

public class RoomDrawerFactory {
    
    static {
        Renderer.addDrawer(Room.class, 
        RoomDrawerFactory.get(Room.class, Misc.getAnimation(Assets.getInfo("island").getString("path"))));
    }

    public static <T extends Room> ObjectDrawer<T> get(Class<T> clz, Animation<TextureRegion> animation){
        return new ObjectDrawer<T>() {
            @Override
            public void draw(CenterDrawer drawer, T object) {
                drawer.draw(new Sprite(animation.getKeyFrame(object.getElapsedTime())), object.getPosition());
            }
        };
    }
    
}
