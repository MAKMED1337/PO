package com.po.fuck.lifetime;

import java.util.function.Consumer;

public final class ClassData<T> {
    public Class<T> cls;
    public Consumer<T> constructor;
    public Consumer<T> destructor;

    // cls should not be null, but constructor and destructor could be
    public ClassData(Class<T> cls, Consumer<T> constructor, Consumer<T> destructor) {
        this.cls = cls;
        this.constructor = constructor;
        this.destructor = destructor;
    }
}
