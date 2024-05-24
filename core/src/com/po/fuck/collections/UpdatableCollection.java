package com.po.fuck.collections;

import com.po.fuck.updates.Updatable;

import java.util.ArrayList;

public final class UpdatableCollection extends SimpleCollection<Updatable> implements Updatable {
    UpdatableCollection() {
        super(Updatable.class);
    }

    @Override
    public void update(float delta) {
        for (Updatable updatable : new ArrayList<>(objects))
            updatable.update(delta);
    }
}
