package com.po.fuck.model.collections;

import com.po.fuck.view.Drawable;

import java.util.ArrayList;
import java.util.Iterator;

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
            int current_z = 0; // Start at the first z-index
            int ptr = 0; // Start at the first object in the z-index
            // Represents the next object to be drew.
            // If the current z-index has no more objects to draw, move to the next z-index

            @Override
            public boolean hasNext() {
                // Skip z-indexes where there are no more objects to draw
                while(current_z < MAX_Z && ptr == objects[current_z].size()){
                    current_z++; // Move to the next z-index
                    ptr = 0; // Reset the pointer
                }
                if(current_z == MAX_Z) return false; // No more objects to draw
                return true;
            }

            @Override
            public Drawable next() {
                Drawable drawable = objects[current_z].get(ptr++); // Get the next object
                if(ptr == objects[current_z].size()){ // If there are no more objects in the current z-index
                    current_z++; // Move to the next z-index
                    ptr = 0; // Reset the pointer
                }
                return drawable;
            }
        };
    }
}
