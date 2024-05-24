package com.po.fuck.lifetime;

import java.util.function.Consumer;

public final class ClassData<T> {
    public Class<T> cls;
    public Consumer<T> constructor;
    public Consumer<T> destructor;

    /**
     * Constructs a class data for a `Manager`
     *
     * @param cls         class for which this data is applied to, should not be
     *                    null
     * @param constructor can be null
     * @param destructor  can be null
     */
    public ClassData(Class<T> cls, Consumer<T> constructor, Consumer<T> destructor) {
        if (this.cls == null)
            throw new NullPointerException("Cls can not be null");

        this.cls = cls;
        this.constructor = constructor;
        this.destructor = destructor;
    }
}
