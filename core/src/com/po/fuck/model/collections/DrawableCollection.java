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
            int cur_z = 0;
            int ptr = 0;

            @Override
            public boolean hasNext() {
                while(cur_z < MAX_Z && ptr == objects[cur_z].size()){
                    cur_z++;
                    ptr = 0;
                }
                if(cur_z == MAX_Z) return false;
                return true;
            }

            @Override
            public Drawable next() {
                return objects[cur_z].get(ptr++);
            }
        };
    }
}
