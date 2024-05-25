package com.po.fuck.model.collections;

import java.util.ArrayList;

import com.po.fuck.model.Updatable;

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
