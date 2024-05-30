package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.HandedWeapon;
import com.po.fuck.model.weapons.LaserGun;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ClassDrawer;

public class HandedWeaponDrawerFactory {
    
    static {
        Renderer.addDrawer(Glock.class, HandedWeaponDrawerFactory.get(Glock.class, new Sprite(new Texture("glock3.png"))));
        Renderer.addDrawer(LaserGun.class, HandedWeaponDrawerFactory.get(LaserGun.class, new Sprite(new Texture("laser_gun2.png"))));
    }

    public static <T extends HandedWeapon> ClassDrawer<T> get(Class<T> clz, Sprite sprite){
        
        return new ClassDrawer<T>() {
            Sprite handedWeaponSprite = new Sprite(sprite);
            
            @Override
            public void draw(CenterDrawer drawer, T weapon) {
                Vector2 position = weapon.getPosition();
                if (weapon.getAimPosition() != null){
                    Vector2 direction = weapon.getDirection();
                    float angle = direction.angleDeg();
                    handedWeaponSprite.setRotation(-angle);
                    handedWeaponSprite.setFlip(false, angle >= 90 && angle <= 270);
                }
                drawer.draw(handedWeaponSprite, position);
            }
        };
    }
    
}
