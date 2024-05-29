package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.GameObject;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.classdrawers.ClassDrawer;

public class GameObjectDrawerFactory {

    public static <T extends GameObject> ClassDrawer<T> get(Class<T> clz, Sprite sprite){
        return new ClassDrawer<T>() {
            Sprite gameObjectSprite = new Sprite(sprite);

            @Override
            public <Drawer extends CenterDrawer> void draw(Drawer drawer, T object) {
                Vector2 position = object.getPosition();
                drawer.draw(gameObjectSprite, position);
            }
        };
    }

}
