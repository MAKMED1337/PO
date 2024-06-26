package com.po.fuck.view.classdrawers.factories;

import static com.po.fuck.assetsManagement.SpriteLoaders.weaponSpriteLoader;
import static com.po.fuck.model.constants.LayeringConstants.WEAPON;
import static com.po.fuck.view.classdrawers.Misc.getAnimation;

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

public class HandedWeaponDrawerFactory {
    public static void initialize() {
        Renderer.addDrawer(Glock.class, HandedWeaponDrawerFactory.get(Glock.class));
        Renderer.addDrawer(LaserGun.class, HandedWeaponDrawerFactory.get(LaserGun.class));
    }

    public static <T extends HandedWeapon> ObjectDrawer<T> get(Class<T> clz) {
        Animation<TextureRegion> animation = getAnimation(weaponSpriteLoader.getSpriteInfo(clz));
        return new ObjectDrawer<T>() {
            @Override
            public int getZ() {
                return WEAPON;
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
