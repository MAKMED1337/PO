package com.po.fuck.view;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.model.Constants;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.weapons.Bullet;
import com.po.fuck.model.weapons.HandedWeapon;

public class Renderer {
    SpriteBatch batch;

    private OrthographicCamera camera;

    public Renderer(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        batch = new SpriteBatch();
    }

    public void render(DrawableCollection drawableCollection){
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        CenterDrawer centerDrawer = new CenterDrawer(batch);
        for(Drawable object : drawableCollection){
            ArrayList<Sprite> spriteList = object.getSpriteList();
            Vector2 position = object.getPosition();
        
            for(Sprite sprite : spriteList){

                // make it more beatiful
                if(object instanceof Bullet){
                    Bullet bullet = (Bullet) object;
                    sprite.setRotation(-bullet.getVelocity().angleDeg());
                }
                
                if(object instanceof HandedWeapon){
                    HandedWeapon weapon = (HandedWeapon) object;
                    if (weapon.getAimPosition() == null)
                        return;

                    Vector2 direction = weapon.getDirection();
                    float angle = direction.angleDeg();
                    sprite.setRotation(-angle);
                    sprite.setFlip(false, angle >= 90 && angle <= 270);
                }

                centerDrawer.draw(sprite, position);
            }
        }
        batch.end();
    }
}
