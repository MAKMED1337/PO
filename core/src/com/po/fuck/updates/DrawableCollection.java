package com.po.fuck.updates;

import com.po.fuck.CenterDrawer;

import java.util.ArrayList;

public class DrawableCollection implements Drawable {
    public static final int MAX_Z = 20;
    private final ArrayList<Drawable>[] objects = new ArrayList[MAX_Z];

    {
        for (int i = 0; i < MAX_Z; ++i)
            objects[i] = new ArrayList<>();
    }

    @Override
    public void draw(CenterDrawer drawer) {
        for (int z = 0; z < MAX_Z; ++z)
            for (Drawable drawable : new ArrayList<>(objects[z]))
                drawable.draw(drawer);
    }

    public void add(Drawable drawable) {
        objects[drawable.get_z()].add(drawable);
    }

    public void remove(Drawable drawable) {
        objects[drawable.get_z()].remove(drawable);
    }
}
