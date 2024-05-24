package com.po.fuck.lifetime;

public interface Destructable {
    public void destructor();

    public static final Lifetime lifetime = new Lifetime();

    public static class Lifetime {
        static {
            Manager.register_class(
                    new ClassData<Destructable>(Destructable.class, null, object -> object.destructor()));
        }
    }
}
