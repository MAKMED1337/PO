package com.po.fuck.view;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.GameObject;
import com.po.fuck.model.weapons.Bullet;
import com.po.fuck.model.weapons.HandedWeapon;

public abstract class ClassDrawer<T> {
    public abstract void draw(CenterDrawer centerDrawerdrawer,List<Sprite> sprites, T object, Vector2 position);

    public static void initialize() {
        initializeBulletDrawer();
        initializeHandedWeaponDrawer();
        initializeGameObjectDrawer();
        initializeHealthBarDrawer();
    }

    private static void initializeBulletDrawer() {
        ClassDrawer<Bullet> bulletDrawer = new ClassDrawer<Bullet>() {
            @Override
            public void draw(CenterDrawer centerDrawer, List<Sprite> sprites, Bullet bullet, Vector2 position) {
                for(Sprite sprite : sprites){
                    sprite.setRotation(-bullet.getVelocity().angleDeg());
                    centerDrawer.draw(sprite, position);
                }
                return;
            }
        };
        Renderer.addDrawer(Bullet.class, bulletDrawer);
    }

    private static void initializeHandedWeaponDrawer(){
        ClassDrawer<HandedWeapon> handedWeaponDrawer = new ClassDrawer<HandedWeapon>() {
            @Override
            public void draw(CenterDrawer centerDrawer, List<Sprite> sprites, HandedWeapon handedWeapon, Vector2 position) {
                for(Sprite sprite : sprites){
                    if (handedWeapon.getAimPosition() != null){
                        Vector2 direction = handedWeapon.getDirection();
                        float angle = direction.angleDeg();
                        sprite.setRotation(-angle);
                        sprite.setFlip(false, angle >= 90 && angle <= 270);
                    }
                    centerDrawer.draw(sprite, position);
                }
                return;
            }
        };
        Renderer.addDrawer(HandedWeapon.class, handedWeaponDrawer);
    }

    private static void initializeGameObjectDrawer(){
        ClassDrawer<GameObject> gameObjectDrawer = new ClassDrawer<GameObject>() {
            @Override
            public void draw(CenterDrawer centerDrawer, List<Sprite> sprites, GameObject gameObject, Vector2 position) {
                for(Sprite sprite : sprites){
                    centerDrawer.draw(sprite, position);
                }
                return;
            }
        };
        Renderer.addDrawer(GameObject.class, gameObjectDrawer);
    }


    private static void initializeHealthBarDrawer() {
        ClassDrawer<HealthBar> healthBarDrawer = new ClassDrawer<HealthBar>() {
            @Override
            public void draw(CenterDrawer centerDrawer, List<Sprite> sprites, HealthBar healthBar, Vector2 position) {
                for(Sprite sprite : sprites){
                    centerDrawer.draw(sprite, position);
                }
                return;
            }
        };
        Renderer.addDrawer(HealthBar.class, healthBarDrawer);
    }
}
