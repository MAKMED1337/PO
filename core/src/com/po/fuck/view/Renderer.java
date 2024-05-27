package com.po.fuck.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.model.Constants;
import com.po.fuck.model.collections.DrawableCollection;

/**
 * Class responsible for rendering game objects.
 */
public class Renderer {
    SpriteBatch batch;

    private OrthographicCamera camera;

    static Map<Class<?>, ClassDrawer<?> > drawers = new HashMap<>();
    static Map<Class<?>, List<Sprite>> sprites = new HashMap<>();

    static {
        ClassDrawer.initializeDrawers();
        ClassDrawer.initializeSprites();
    }

    public Renderer(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        batch = new SpriteBatch();
    }

    float timeElapsed = 0;

    /**
     * Renders the provided DrawableCollection.
     *
     * @param drawableCollection the collection of drawable objects to render
     */
    public void render(float delta, DrawableCollection drawableCollection){
        timeElapsed += delta;

        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        ClassDrawer.initializeLaserBeamSprites(timeElapsed);

        batch.begin();
        CenterDrawer centerDrawer = new CenterDrawer(batch);
        for(Drawable object : drawableCollection){
            List<Sprite> spriteList = getSprite(object.getClass());
            
            @SuppressWarnings("unchecked")
            ClassDrawer<Drawable> classDrawer = (ClassDrawer<Drawable>) getDrawer(object.getClass());

            classDrawer.draw(centerDrawer, spriteList, object.getClass().cast(object));
        }
        batch.end();
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
        ClassDrawer<T> drawer = (ClassDrawer<T>) drawers.get(clazz);
        if(drawer == null){
            Class<?> superClass = clazz;
            while(superClass != Object.class){
                superClass = superClass.getSuperclass();
                drawer = (ClassDrawer<T>) drawers.get(superClass);
                if(drawer != null){
                    break;
                }
            }
            if(drawer == null){
                throw new RuntimeException("No ClassDrawer found for " + clazz.toString() + " or any of its superclasses.");
            }
        }
        return drawer;
    }

    public static <T> void addDrawer(Class<T> cls, ClassDrawer<T> classDrawer){
        if(drawers.containsKey(cls)){
            throw new RuntimeException("ClassDrawer was added twice for " + cls.toString());
        }
        drawers.put(cls,classDrawer);
        return;
    }

    public static <T> void addSprite(Class<T> cls, List<Sprite> spriteList){
        if(sprites.containsKey(cls)){
            throw new RuntimeException("Sprite was added twice for " + cls.toString());
        }
        sprites.put(cls,spriteList);
        return;
    }

    public static <T> void addOrUpdateSprite(Class<T> cls, List<Sprite> spriteList){
        sprites.put(cls,spriteList);
        return;
    }

    public static <T> List<Sprite> getSprite(Class<T> cls){
        System.err.println(cls.toString());
        return sprites.get(cls);
    }
}
