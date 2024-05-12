package com.po.fuck.updates;

import java.util.ArrayList;

public final class UpdatableCollection implements Updatable {
    private final ArrayList<Updatable> objects = new ArrayList<>();

    public void add(Updatable updatable) {
        objects.add(updatable);
    }

    public void remove(Updatable updatable) {
        objects.remove(updatable);
    }

    @Override
    public void update(float delta) {
        for (Updatable updatable : new ArrayList<>(objects))
            updatable.update(delta);
    }
}
