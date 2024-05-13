package com.po.fuck.updates;

import com.po.fuck.Entity;
import com.po.fuck.FUCK;

public class Initializer {
    public UpdatableCollection updatableCollection = new UpdatableCollection();
    public DrawableCollection drawableCollection = new DrawableCollection();

    public void init(Object object) {
        if (object instanceof Updatable)
            updatableCollection.add((Updatable) object);
        if (object instanceof Drawable)
            drawableCollection.add((Drawable) object);
        if (object instanceof Entity)
            FUCK.entitiesHandler.addEntity( (Entity) object);
    }

    public void dispose(Object object) {
        if (object instanceof Updatable)
            updatableCollection.remove((Updatable) object);
        if (object instanceof Drawable)
            drawableCollection.remove((Drawable) object);
        if (object instanceof Entity)
            FUCK.entitiesHandler.removeEntity((Entity) object);
    }
}
