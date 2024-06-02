package com.po.fuck.model.lifetime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public final class Manager {
    private static final ArrayList<ClassData<?>> classes = new ArrayList<>();
    private static HashMap<Object, Managed<? extends Object>> objects = new HashMap<>();

    public static <T> void register_class(ClassData<T> data) {
        classes.add(data);
    }

    // initializes object with constructors through implements
    @SuppressWarnings("unchecked")
    private static void construct(Object object) {
        for (ClassData<?> lifetime : classes)
            if (lifetime.constructor != null && lifetime.cls.isInstance(object))
                ((Consumer<Object>) lifetime.constructor).accept(object);
    }

    // Try to avoid, destroys the actual object, not the managed one
    @SuppressWarnings("unchecked")
    public static void destroy_raw(Object object) {
        if (!objects.containsKey(object))
            throw new RuntimeException("Object " + object + " was not initialized before destroy");
        objects.remove(object).object = null;

        for (ClassData<?> lifetime : classes)
            if (lifetime.destructor != null && lifetime.cls.isInstance(object))
                ((Consumer<Object>) lifetime.destructor).accept(object);
    }

    public static <T> Managed<T> create(T object) {
        if (objects.containsKey(object))
            throw new RuntimeException("Object " + object + " was initialized twice");

        construct(object);
        Managed<T> managed = new Managed<>();
        managed.object = object;
        objects.put(object, managed);

        return managed;
    }
}
