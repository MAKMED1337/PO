package com.po.fuck.model.collections;

import java.util.ArrayList;

import com.po.fuck.model.lifetime.ClassData;
import com.po.fuck.model.lifetime.Manager;

public abstract class SimpleCollection<T> {
    protected SimpleCollection(Class<T> cls) {
        Manager.registerClass(new ClassData<T>(
                cls,
                this::add,
                this::remove));
    }

    protected final ArrayList<T> objects = new ArrayList<>();

    public void add(T object) {
        objects.add(object);
    }

    public void remove(T object) {
        objects.remove(object);
    }
}
