package com.po.fuck.view;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.model.Camera;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.view.classdrawers.ClassDrawer;

/**
 * Class responsible for rendering game objects.
 */
public class Renderer {
    private Camera camera;

    static Map<Class<?>, ClassDrawer<?> > drawers = new HashMap<>();
    static Map<Class<?>, Sprite> sprites = new HashMap<>();

    public Renderer(Camera camera){
        this.camera = camera;
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
        camera.camera.update();
        camera.batch.setProjectionMatrix(camera.camera.combined);

        camera.batch.begin();
        for(Drawable object : drawableCollection){
            
            @SuppressWarnings("unchecked")
            ClassDrawer<Drawable> classDrawer = (ClassDrawer<Drawable>) getDrawer(object.getClass());

            classDrawer.draw(camera, object.getClass().cast(object));
        }
        camera.batch.end();
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
        ClassDrawer<T> drawer = null;
        Class<?> superClass = clazz;
        while(drawer == null && superClass != Object.class){
            drawer = (ClassDrawer<T>) drawers.get(superClass);
            superClass = superClass.getSuperclass();
        }
        if(drawer == null){
            throw new RuntimeException("No ClassDrawer found for " + clazz.toString());
        }
        return drawer;
    }

    public static <T> void addDrawer(Class<T> cls, ClassDrawer<T> classDrawer){
        if(drawers.containsKey(cls)){
            throw new RuntimeException("ClassDrawer was added twice for " + cls.toString());
        }
        drawers.put(cls,classDrawer);
    }

    public static <T> void addSprite(Class<T> cls, Sprite sprite){
        if(sprites.containsKey(cls)){
            throw new RuntimeException("Sprite was added twice for " + cls.toString());
        }
        sprites.put(cls,sprite);
    }

    public static <T> void addOrUpdateSprite(Class<T> cls, Sprite sprite){
        sprites.put(cls,sprite);
    }

    public static <T> Sprite getSprite(Class<T> cls){
        return sprites.get(cls);
    }
}
