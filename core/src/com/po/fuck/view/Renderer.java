package com.po.fuck.view;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.model.Coins;
import com.po.fuck.model.ObjectFollower;
import com.po.fuck.model.Player;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.model.weapons.CosmicBullet;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.LaserBeam;
import com.po.fuck.model.weapons.LaserGun;
import com.po.fuck.view.classdrawers.ObjectDrawer;
import com.po.fuck.view.classdrawers.factories.BulletDrawerFactory;
import com.po.fuck.view.classdrawers.factories.CoinDrawerFactory;
import com.po.fuck.view.classdrawers.factories.EntityDrawerFactory;
import com.po.fuck.view.classdrawers.factories.GameObjectDrawerFactory;
import com.po.fuck.view.classdrawers.factories.HandedWeaponDrawerFactory;
import com.po.fuck.view.classdrawers.factories.RoomDrawerFactory;

import static com.po.fuck.model.Core.forceInit;
import static com.po.fuck.view.Constants.GAME_HEIGHT;
import static com.po.fuck.view.Constants.GAME_WIDTH;

/**
 * Class responsible for rendering game objects.
 */
public class Renderer {
    static private Map<Class<?>, ObjectDrawer<?> > drawers = new HashMap<>();
    
    static { // TODO: remove this
        forceInit(BulletDrawerFactory.class);
        forceInit(EntityDrawerFactory.class);
        forceInit(GameObjectDrawerFactory.class);
        forceInit(HandedWeaponDrawerFactory.class);
        forceInit(RoomDrawerFactory.class);
        forceInit(CoinDrawerFactory.class);
    }

    private OrthographicCamera camera;
    private FollowingDrawer followingDrawer;

    public Renderer(ObjectFollower objectFollower){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
        followingDrawer = new FollowingDrawer(new SpriteBatch(), objectFollower);
    }


    /**
     * Renders the provided DrawableCollection.
     *
     * @param drawableCollection the collection of drawable objects to render
     */
    public void render(DrawableCollection drawableCollection){

        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        followingDrawer.batch.setProjectionMatrix(camera.combined);

        followingDrawer.batch.begin();
        for(Object object : drawableCollection){
            
            @SuppressWarnings("unchecked")
            ObjectDrawer<Object> classDrawer = (ObjectDrawer<Object>) getDrawer(object.getClass());
            if(classDrawer == null){
                throw new RuntimeException("No ClassDrawer found for " + object.getClass().toString());
            }
            
            classDrawer.draw(followingDrawer, object.getClass().cast(object));
        }
        followingDrawer.batch.end();
    }

    /**
     * Retrieves the ClassDrawer instance for a specific class type. If there is no ClassDrawer instance for the provided
     * class type, the method will attempt to find a ClassDrawer instance for a superclass of the provided class type.
     *
     * @param clazz the class type
     * @param <T>   the type of the class
     * @return the ClassDrawer instance
     */
    @SuppressWarnings("unchecked")
    public static <T> ObjectDrawer<T> getDrawer(Class<T> clazz) {
        Class<?> cls = clazz;
        while (cls != null) {
            ObjectDrawer<T> drawer = (ObjectDrawer<T>) drawers.get(cls);
            if (drawer != null)
                return drawer;

            cls = cls.getSuperclass();
        }
        return null;
    }

    public static <T> void addDrawer(Class<T> cls, ObjectDrawer<T> classDrawer){
        if(drawers.containsKey(cls)){
            throw new RuntimeException("ClassDrawer was added twice for " + cls.toString());
        }
        drawers.put(cls, classDrawer);
    }

}
