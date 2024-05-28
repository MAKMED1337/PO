package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.model.Coins;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ClassDrawer;
import com.po.fuck.model.Room;

public class RoomDrawerFactory {
    
    static {
        Renderer.addDrawer(Room.class, RoomDrawerFactory.get(Room.class, new Sprite(new Texture("island2.png"))));
    }

    @SuppressWarnings("all")
    public static <T extends Room> ClassDrawer<T> get(Class<T> clz, Sprite other_sprite){
        return new ClassDrawer<T>() {
            Sprite sprite = new Sprite(other_sprite);

            @Override
            public void draw(CenterDrawer centerDrawer, T object) {
                Room room = (Room) object;
                centerDrawer.draw(sprite, room.getPosition());
            }
        };
    }
    
}
