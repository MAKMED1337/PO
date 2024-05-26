package com.po.fuck.collections;

import java.util.ArrayList;

import com.po.fuck.Entity;
import com.po.fuck.lifetime.Manager;
import com.po.fuck.lifetime.ClassData;

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
