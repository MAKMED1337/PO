package com.po.fuck.model.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.po.fuck.model.drawables.Drawable;

public class DrawableCollection extends SimpleCollection<Drawable> implements Iterable<Drawable> {
    public static final int MAX_Z = 20;
    @SuppressWarnings("unchecked")
    private final ArrayList<Drawable>[] objects = new ArrayList[MAX_Z];

    {
        for (int i = 0; i < MAX_Z; ++i)
            objects[i] = new ArrayList<>();
    }

    DrawableCollection() {
        super(Drawable.class);
    }

    @Override
    public void add(Drawable drawable) {
        objects[drawable.getZ()].add(drawable);
    }

    @Override
    public void remove(Drawable drawable) {
        objects[drawable.getZ()].remove(drawable);
    }

    @Override
    public Iterator<Drawable> iterator() {
        return new DrawableCollectionIterator();
    }

    private class DrawableCollectionIterator implements Iterator<Drawable> {
        private int currentZ = 0;
        private Iterator<Drawable> currentIterator = objects[currentZ].iterator();

        private void moveToNextNonEmptyList() {
            while (currentZ < MAX_Z && !currentIterator.hasNext()) {
                currentZ++;
                if (currentZ < MAX_Z) {
                    currentIterator = objects[currentZ].iterator();
                }
            }
        }

        @Override
        public boolean hasNext() {
            moveToNextNonEmptyList();
            return currentZ < MAX_Z && currentIterator.hasNext();
        }

        @Override
        public Drawable next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return currentIterator.next();
        }
    }
}
