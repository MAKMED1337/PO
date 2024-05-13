package com.po.fuck.updates;

import com.po.fuck.Entity;
import com.po.fuck.FUCK;

/**
 * Class responsible for initializing and disposing objects, managing their inclusion in appropriate collections.
 * Adds objects to active objects of the game upon initialization and removes them when disposed.
 */
public class Initializer {
    public UpdatableCollection updatableCollection = new UpdatableCollection();
    public DrawableCollection drawableCollection = new DrawableCollection();

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
        if (object instanceof Entity)
            FUCK.entityHandler.addEntity( (Entity) object);
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
        if (object instanceof Entity)
            FUCK.entityHandler.removeEntity((Entity) object);
    }
}
