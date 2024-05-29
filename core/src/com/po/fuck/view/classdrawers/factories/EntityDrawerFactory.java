package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Constants;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Player;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.HealthBar;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ClassDrawer;

public class EntityDrawerFactory {
    
    static {
        Renderer.addDrawer(Player.class, EntityDrawerFactory.get(Player.class, new Sprite(new Texture("FUCKerWithoutHands2.png"))));
        Renderer.addDrawer(BasicEnemy.class, EntityDrawerFactory.get(BasicEnemy.class, new Sprite(new Texture("player2.png"))));
    }

    public static <T extends Entity> ClassDrawer<T> get(Class<T> clz, Sprite other_sprite){
        return new ClassDrawer<T>() {
            Sprite sprite = new Sprite(other_sprite);

            @Override
            public <Drawer extends CenterDrawer> void draw(Drawer drawer, T object) {
                Entity entity = (Entity) object;
                Vector2 position = entity.getPosition();
                
                drawer.draw(sprite, position);
                
                Vector2 healthBarPosition = position.cpy().sub(0 , sprite.getHeight() / 2 + Constants.HEALTHBAR_OFFSET);
                HealthBar healthBar = new HealthBar(entity);

                drawer.draw(healthBar.backgroundSprite, healthBarPosition);
                drawer.draw(healthBar.healthBarSprite, healthBarPosition);
            }
        };
    }
    
}
