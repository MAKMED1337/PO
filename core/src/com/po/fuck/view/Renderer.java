package com.po.fuck.view;

import static com.po.fuck.view.RenderConstants.HEIGHT;
import static com.po.fuck.view.RenderConstants.WIDTH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.model.ObjectFollower;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.drawables.Drawable;
import com.po.fuck.view.classdrawers.ObjectDrawer;
import com.po.fuck.view.classdrawers.factories.BulletDrawerFactory;
import com.po.fuck.view.classdrawers.factories.CoinDrawerFactory;
import com.po.fuck.view.classdrawers.factories.EntityDrawerFactory;
import com.po.fuck.view.classdrawers.factories.HandedWeaponDrawerFactory;
import com.po.fuck.view.classdrawers.factories.RoomDrawerFactory;

/**
 * Class responsible for rendering game objects.
 */
public class Renderer {
    static private Map<Class<?>, ObjectDrawer<?>> drawers = new HashMap<>();

    public static void initialize() {
        BulletDrawerFactory.initialize();
        EntityDrawerFactory.initialize();
        HandedWeaponDrawerFactory.initialize();
        RoomDrawerFactory.initialize();
        CoinDrawerFactory.initialize();
    }

    private OrthographicCamera camera;
    private FollowingDrawer followingDrawer;

    public Renderer(ObjectFollower objectFollower) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
        followingDrawer = new FollowingDrawer(new SpriteBatch(), objectFollower);
    }

    /**
     * Splits drawables into their respective layers
     */
    protected TreeMap<Integer, ArrayList<Drawable>> getLayers(DrawableCollection drawableCollection) {
        TreeMap<Integer, ArrayList<Drawable>> layers = new TreeMap<>();

        for (Drawable drawable : drawableCollection) {
            @SuppressWarnings("unchecked")
            ObjectDrawer<Drawable> classDrawer = (ObjectDrawer<Drawable>) getDrawer(drawable.getClass());
            if (classDrawer == null) {
                throw new RuntimeException("No ClassDrawer found for " + drawable.getClass().toString());
            }

            layers.computeIfAbsent(classDrawer.getZ(), x -> new ArrayList<>()).add(drawable);
        }
        return layers;
    }

    /**
     * Renders the provided DrawableCollection.
     *
     * @param drawableCollection the collection of drawable objects to render
     */
    public void render(DrawableCollection drawableCollection) {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        followingDrawer.batch.setProjectionMatrix(camera.combined);

        followingDrawer.batch.begin();

        for (ArrayList<Drawable> layer : getLayers(drawableCollection).values()) {
            for (Drawable drawable : layer) {
                @SuppressWarnings("unchecked")
                ObjectDrawer<Drawable> classDrawer = (ObjectDrawer<Drawable>) getDrawer(drawable.getClass());
                classDrawer.draw(followingDrawer, drawable);
            }
        }

        followingDrawer.batch.end();
    }

    /**
     * Retrieves the ClassDrawer instance for a specific class type. If there is no
     * ClassDrawer instance for the provided
     * class type, the method will attempt to find a ClassDrawer instance for a
     * superclass of the provided class type.
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

    public static <T> void addDrawer(Class<T> cls, ObjectDrawer<T> classDrawer) {
        if (drawers.containsKey(cls)) {
            throw new RuntimeException("ClassDrawer was added twice for " + cls.toString());
        }
        drawers.put(cls, classDrawer);
    }
}
