package com.po.fuck.updates;

import com.po.fuck.CenterDrawer;

import com.po.fuck.lifetime.Manager;
import com.po.fuck.lifetime.ClassData;
import java.util.ArrayList;

public class DrawableCollection {
    static {
        Manager.register_class(new ClassData<Drawable>(
                Drawable.class,
                object -> DrawableCollection.add(object),
                object -> DrawableCollection.remove(object)));
    }

    public static final int MAX_Z = 20;
    @SuppressWarnings("unchecked")
    static private final ArrayList<Drawable>[] objects = new ArrayList[MAX_Z];

    static {
        for (int i = 0; i < MAX_Z; ++i)
            objects[i] = new ArrayList<>();
    }

    static public void draw(CenterDrawer drawer) {
        for (int z = 0; z < MAX_Z; ++z)
            for (Drawable drawable : new ArrayList<>(objects[z]))
                drawable.draw(drawer);
    }

    static public void add(Drawable drawable) {
        objects[drawable.get_z()].add(drawable);
    }

    static public void remove(Drawable drawable) {
        objects[drawable.get_z()].remove(drawable);
    }
}
