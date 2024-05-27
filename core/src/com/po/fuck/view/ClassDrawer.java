package com.po.fuck.view;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.GameObject;
import com.po.fuck.model.Player;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.model.weapons.Bullet;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.HandedWeapon;
import com.po.fuck.model.weapons.LaserBeam;
import com.po.fuck.model.weapons.LaserGun;

import static com.po.fuck.view.DrawableMisc.createTexture;

public abstract class ClassDrawer<T> {
    public abstract void draw(CenterDrawer centerDrawerdrawer,List<Sprite> sprites, T object);

    public static void initializeDrawers() {
        initializeBulletDrawer();
        initializeHandedWeaponDrawer();
        initializeGameObjectDrawer();
        initializeHealthBarDrawer();
    }

    private static void initializeBulletDrawer() {
        ClassDrawer<Bullet> bulletDrawer = new ClassDrawer<Bullet>() {
            @Override
            public void draw(CenterDrawer centerDrawer, List<Sprite> sprites, Bullet bullet) {
                Vector2 position = bullet.getPosition();
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
            public void draw(CenterDrawer centerDrawer, List<Sprite> sprites, HandedWeapon handedWeapon) {
                Vector2 position = handedWeapon.getPosition();
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
            public void draw(CenterDrawer centerDrawer, List<Sprite> sprites, GameObject gameObject) {
                Vector2 position = gameObject.getPosition();
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
            public void draw(CenterDrawer centerDrawer, List<Sprite> sprites, HealthBar healthBar) {
                Vector2 position = healthBar.getPosition();
                for(Sprite sprite : sprites){
                    centerDrawer.draw(sprite, position);
                }
                return;
            }
        };
        Renderer.addDrawer(HealthBar.class, healthBarDrawer);
    }

    public static void initializeSprites() {
        initializeBulletSprites();
        initializeWeaponSprites();
        initializeHealthBarSprites();
        initializeEntitySprites();
    }


    private static void initializeBulletSprites() {
        initializeCosmicBulletSprites();
        initializeLaserBeamSprites(0);
    }

    private static void initializeWeaponSprites() {
        initializeGlockSprites();
        initializeLaserGunSprites();
    }

    private static void initializeEntitySprites() {
        initializeBasicEnemySprites();
        ititializePlayerSprites();
    }

    private static void initializeBasicEnemySprites() {
        List<Sprite> basicEnemySprites = new ArrayList<>();
        basicEnemySprites.add(new Sprite(new Texture("player2.png")));

        Renderer.addSprite(BasicEnemy.class, basicEnemySprites);
    }

    private static void ititializePlayerSprites() {
        List<Sprite> playerSprites = new ArrayList<>();
        playerSprites.add(new Sprite(new Texture("FUCKerWithoutHands2.png")));

        Renderer.addSprite(Player.class, playerSprites);
    }

    private static void initializeGlockSprites() {
        List<Sprite> glockSprites = new ArrayList<>();
        glockSprites.add(new Sprite(new Texture("glock.png")));

        Renderer.addSprite(Glock.class, glockSprites);
    }

    private static void initializeLaserGunSprites() {
        List<Sprite> laserGunSprites = new ArrayList<>();
        laserGunSprites.add(new Sprite(new Texture("laser_gun2.png")));

        Renderer.addSprite(LaserGun.class, laserGunSprites);
    }

    private static void initializeCosmicBulletSprites() {
        List<Sprite> cosmicBulletSprites = new ArrayList<>();
        cosmicBulletSprites.add(new Sprite(new Texture("bullet2.png")));

        Renderer.addSprite(Bullet.class, cosmicBulletSprites);
    }

    private static void initializeLaserBeamSprites(float elapsedTime) {
        List<Sprite> laserBeamSprites = new ArrayList<>();
        Animation<TextureRegion> animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("laser3.gif").read());
        laserBeamSprites.add(new Sprite(animation.getKeyFrame(elapsedTime)));

        Renderer.addOrUpdateSprite(LaserBeam.class, laserBeamSprites);
    }

    private static void initializeHealthBarSprites() {
        List<Sprite> healthBarSprites = new ArrayList<>();
        healthBarSprites.add(new Sprite(createTexture(100, 10, new Color(0, 255, 0, 10))));
        healthBarSprites.add(new Sprite(createTexture(100, 10, new Color(255, 0, 0, 10))));

        Renderer.addSprite(HealthBar.class, healthBarSprites);
    }
}
