package com.po.fuck.updates;

import com.po.fuck.lifetime.Manager;
import com.po.fuck.lifetime.ClassData;

import java.util.ArrayList;

public final class UpdatableCollection {
    static {
        Manager.register_class(new ClassData<Updatable>(
                Updatable.class,
                object -> UpdatableCollection.add(object),
                object -> UpdatableCollection.remove(object)));
    }

    static private final ArrayList<Updatable> objects = new ArrayList<>();

    static public void add(Updatable updatable) {
        objects.add(updatable);
    }

    static public void remove(Updatable updatable) {
        objects.remove(updatable);
    }

    static public void update(float delta) {
        for (Updatable updatable : new ArrayList<>(objects))
            updatable.update(delta);
    }
}
