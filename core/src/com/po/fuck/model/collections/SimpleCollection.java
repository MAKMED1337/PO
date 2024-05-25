package com.po.fuck.model.collections;

import java.util.ArrayList;

import com.po.fuck.model.lifetime.ClassData;
import com.po.fuck.model.lifetime.Manager;

public class SimpleCollection<T> {
    protected SimpleCollection(Class<T> cls) {
        Manager.register_class(new ClassData<T>(
                cls,
                object -> this.add(object),
                object -> this.remove(object)));
    }

    protected final ArrayList<T> objects = new ArrayList<>();

    public void add(T object) {
        objects.add(object);
    }

    public void remove(T object) {
        objects.remove(object);
    }
}
