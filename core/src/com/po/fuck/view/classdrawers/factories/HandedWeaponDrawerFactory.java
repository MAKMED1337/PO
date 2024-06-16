package com.po.fuck.view.classdrawers.factories;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.HandedWeapon;
import com.po.fuck.model.weapons.LaserGun;
import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.ObjectDrawer;

import static com.po.fuck.model.constants.LayeringConstants.WEAPON_LAYER;
import static com.po.fuck.view.classdrawers.Misc.getAnimation;

public class HandedWeaponDrawerFactory {
    static {
        Renderer.addDrawer(Glock.class, HandedWeaponDrawerFactory.get(Glock.class, getAnimation("glock3.png")));
        Renderer.addDrawer(LaserGun.class,
                HandedWeaponDrawerFactory.get(LaserGun.class, getAnimation("laser_gun2.png")));
    }

    public static <T extends HandedWeapon> ObjectDrawer<T> get(Class<T> clz, Animation<TextureRegion> animation) {
        return new ObjectDrawer<T>() {
            @Override
            public int getZ() {
                return WEAPON_LAYER;
            }

            @Override
            public void draw(CenterDrawer drawer, T weapon) {
                Sprite handedWeaponSprite = new Sprite(animation.getKeyFrame(0));
                Vector2 position = weapon.getPosition();
                if (weapon.getAimPosition() != null) {
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
