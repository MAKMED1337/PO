package com.po.fuck.view.classdrawers.factories;

import static com.po.fuck.view.classdrawers.Misc.getAnimation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Player;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.HealthBar;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ObjectDrawer;

public class EntityDrawerFactory {
    
    static {
        Renderer.addDrawer(Player.class, EntityDrawerFactory.get(Player.class,
                getAnimation(Player.class)));
        Renderer.addDrawer(BasicEnemy.class, EntityDrawerFactory.get(BasicEnemy.class,
                getAnimation(BasicEnemy.class)));
    }

    public static <T extends Entity> ObjectDrawer<T> get(Class<T> clz, Animation<TextureRegion> animation){
        return new ObjectDrawer<T>() {
            @Override
            public void draw(CenterDrawer drawer, T object) {
                Vector2 position = object.getPosition();
                Sprite entitySprite = new Sprite(animation.getKeyFrame(0));
                
                drawer.draw(entitySprite, position);
                
                HealthBar healthBar = new HealthBar(object);
                healthBar.draw(drawer);
            }
        };
    }
    
}
