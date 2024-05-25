package com.po.fuck.model.lifetime;

// analogous to C++ shared_ptr
public final class Managed<T> {
    T object = null;

    public T get() {
        return object;
    }

    // convenient way to destroy shared object
    public void destroy() {
        if (object != null)
            Manager.destroy_raw(object);
        object = null;
    }
}
