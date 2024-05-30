package com.po.fuck.view;

import static com.po.fuck.model.Constants.GAME_HEIGHT;
import static com.po.fuck.model.Constants.GAME_WIDTH;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.model.ObjectFollower;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.view.classdrawers.ClassDrawer;
import com.po.fuck.view.classdrawers.factories.AnimatedBulletDrawerFactory;
import com.po.fuck.view.classdrawers.factories.BulletDrawerFactory;
import com.po.fuck.view.classdrawers.factories.CoinDrawerFactory;
import com.po.fuck.view.classdrawers.factories.EntityDrawerFactory;
import com.po.fuck.view.classdrawers.factories.GameObjectDrawerFactory;
import com.po.fuck.view.classdrawers.factories.HandedWeaponDrawerFactory;
import com.po.fuck.view.classdrawers.factories.RoomDrawerFactory;

import static com.po.fuck.model.Core.forceInit;

/**
 * Class responsible for rendering game objects.
 */
public class Renderer {
    static private Map<Class<?>, ClassDrawer<?> > drawers = new HashMap<>();
    
    static {
        forceInit(AnimatedBulletDrawerFactory.class);
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
        for(Drawable object : drawableCollection){
            
            @SuppressWarnings("unchecked")
            ClassDrawer<Drawable> classDrawer = (ClassDrawer<Drawable>) getDrawer(object.getClass());
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
    public static <T> ClassDrawer<T> getDrawer(Class<T> clazz) {
        Class<?> cls = clazz;
        while (cls != null) {
            ClassDrawer<T> drawer = (ClassDrawer<T>) drawers.get(cls);
            if (drawer != null)
                return drawer;

            cls = cls.getSuperclass();
        }
        return null;
    }

    public static <T> void addDrawer(Class<T> cls, ClassDrawer<T> classDrawer){
        if(drawers.containsKey(cls)){
            throw new RuntimeException("ClassDrawer was added twice for " + cls.toString());
        }
        drawers.put(cls,classDrawer);
    }
}
