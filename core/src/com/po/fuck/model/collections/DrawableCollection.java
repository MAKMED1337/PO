package com.po.fuck.model.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.po.fuck.model.drawables.BasicDrawable;

public class DrawableCollection extends SimpleCollection<BasicDrawable> implements Iterable<BasicDrawable> {
    public static final int MAX_Z = 20;
    @SuppressWarnings("unchecked")
    private final ArrayList<BasicDrawable>[] objects = new ArrayList[MAX_Z];

    {
        for (int i = 0; i < MAX_Z; ++i)
            objects[i] = new ArrayList<>();
    }

    DrawableCollection() {
        super(BasicDrawable.class);
    }

    @Override
    public void add(BasicDrawable drawable) {
        objects[drawable.get_z()].add(drawable);
    }

    @Override
    public void remove(BasicDrawable drawable) {
        objects[drawable.get_z()].remove(drawable);
    }
    
    @Override
    public Iterator<BasicDrawable> iterator() {
        return new DrawableCollectionIterator();
    }

    private class DrawableCollectionIterator implements Iterator<BasicDrawable> {
        private int currentZ = 0;
        private Iterator<BasicDrawable> currentIterator = objects[currentZ].iterator();

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
        public BasicDrawable next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return currentIterator.next();
        }
    }
}
