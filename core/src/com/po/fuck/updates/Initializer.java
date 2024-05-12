package com.po.fuck.updates;

public class Initializer {
    public UpdatableCollection updatableCollection = new UpdatableCollection();
    public DrawableCollection drawableCollection = new DrawableCollection();

    public void init(Object object) {
        if (object instanceof Updatable)
            updatableCollection.add((Updatable) object);
        if (object instanceof Drawable)
            drawableCollection.add((Drawable) object);
    }

    public void dispose(Object object) {
        if (object instanceof Updatable)
            updatableCollection.remove((Updatable) object);
        if (object instanceof Drawable)
            drawableCollection.remove((Drawable) object);
    }
}
