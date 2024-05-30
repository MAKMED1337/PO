package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Player;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.HealthBar;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ClassDrawer;

import static com.po.fuck.view.Constants.HEALTHBAR_OFFSET;

public class EntityDrawerFactory {
    
    static {
        Renderer.addDrawer(Player.class, EntityDrawerFactory.get(Player.class, new Sprite(new Texture("FUCKerWithoutHands2.png"))));
        Renderer.addDrawer(BasicEnemy.class, EntityDrawerFactory.get(BasicEnemy.class, new Sprite(new Texture("player2.png"))));
    }

    public static <T extends Entity> ClassDrawer<T> get(Class<T> clz, Sprite sprite){
        return new ClassDrawer<T>() {
            Sprite entitySprite = new Sprite(sprite);

            @Override
            public void draw(CenterDrawer drawer, T object) {
                Vector2 position = object.getPosition();
                
                drawer.draw(entitySprite, position);
                
                Vector2 healthBarPosition = position.cpy().sub(0 , entitySprite.getHeight() / 2 + HEALTHBAR_OFFSET);
                HealthBar healthBar = new HealthBar(object);
                healthBar.draw(drawer, healthBarPosition);
            }
        };
    }
    
}
