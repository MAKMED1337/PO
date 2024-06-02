package com.po.fuck.model.collections;

import com.po.fuck.model.Drawable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
        objects[drawable.get_z()].add(drawable);
    }

    @Override
    public void remove(Drawable drawable) {
        objects[drawable.get_z()].remove(drawable);
    }
    @Override
    public Iterator<Drawable> iterator() {
        return new Iterator<Drawable>() {
            private int current_z = 0; // Start at the first z-index
            private Iterator<Drawable> it = objects[current_z].iterator(); // Start at the first object in the z-index
            // Represents the next object to be drawn.
            // If the current z-index has no more objects to draw, move to the next z-index

            private void moveIterator(){
                while(current_z < MAX_Z && !it.hasNext()){
                    current_z++; // Move to the next z-index
                    if(current_z < MAX_Z)
                        it = objects[current_z].iterator();
                }
            }

            @Override
            public boolean hasNext() {
                // Skip z-indexes where there are no more objects to draw
                moveIterator();
                if(current_z == MAX_Z) return false; // No more objects to draw
                return true;
            }

            @Override
            public Drawable next() {
                if(!hasNext()) throw new NoSuchElementException();
                Drawable drawable = it.next(); // Get the next object
                if(!it.hasNext()){ // If there are no more objects in the current z-index
                    moveIterator();
                }
                return drawable;
            }
        };
    }
}
