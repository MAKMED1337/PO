package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ClassDrawer;
import com.po.fuck.model.Room;

public class RoomDrawerFactory {
    
    static {
        Renderer.addDrawer(Room.class, RoomDrawerFactory.get(Room.class, new Sprite(new Texture("island2.png"))));
    }

    public static <T extends Room> ClassDrawer<T> get(Class<T> clz, Sprite sprite){
        return new ClassDrawer<T>() {
            Sprite roomSprite = new Sprite(sprite);

            @Override
            public <Drawer extends CenterDrawer> void draw(Drawer drawer, T object) {
                drawer.draw(roomSprite, object.getPosition());
            }
        };
    }
    
}
