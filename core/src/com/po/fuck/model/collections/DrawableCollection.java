package com.po.fuck.model.collections;

import com.po.fuck.view.CenterDrawer;
import com.po.fuck.view.Drawable;

import java.util.ArrayList;

public class DrawableCollection extends SimpleCollection<Drawable> implements Drawable {
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
    public void draw(CenterDrawer drawer) {
        for (int z = 0; z < MAX_Z; ++z)
            for (Drawable drawable : new ArrayList<>(objects[z]))
                drawable.draw(drawer);
    }

    @Override
    public void add(Drawable drawable) {
        objects[drawable.get_z()].add(drawable);
    }

    @Override
    public void remove(Drawable drawable) {
        objects[drawable.get_z()].remove(drawable);
    }
}
