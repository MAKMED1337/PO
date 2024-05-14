package com.po.fuck.updates;

import com.po.fuck.collision.Collidable;
import com.po.fuck.collision.CollidableCollection;

import java.util.HashSet;

/**
 * Class responsible for initializing and disposing objects, managing their inclusion in appropriate collections.
 * Adds objects to active objects of the game upon initialization and removes them when disposed.
 */
public final class Initializer {
    public UpdatableCollection updatableCollection = new UpdatableCollection();
    public DrawableCollection drawableCollection = new DrawableCollection();
    public CollidableCollection collidableCollection = new CollidableCollection();

    private final HashSet<Object> objects = new HashSet<>();

    /**
     * Initializes the given object by adding it to appropriate collections and active entities of the game.
     * 
     * @param object The object to initialize.
     */
    public void init(Object object) {
        if (object instanceof Updatable)
            updatableCollection.add((Updatable) object);
        if (object instanceof Drawable)
            drawableCollection.add((Drawable) object);
        if (object instanceof Collidable)
            collidableCollection.add((Collidable) object);

        if (objects.contains(object))
            throw new RuntimeException("Object " + object + " was initialized twice");
        objects.add(object);
    }

    /**
     * Disposes the given object by removing it from appropriate collections and active entities of the game.
     * 
     * @param object The object to dispose.
     */
    public void dispose(Object object) {
        if (object instanceof Updatable)
            updatableCollection.remove((Updatable) object);
        if (object instanceof Drawable)
            drawableCollection.remove((Drawable) object);
        if (object instanceof Collidable)
            collidableCollection.remove((Collidable) object);

        boolean initialized = objects.remove(object);
        if (!initialized)
            throw new RuntimeException("Object " + object + " was not initialized before dispose");
    }
}
