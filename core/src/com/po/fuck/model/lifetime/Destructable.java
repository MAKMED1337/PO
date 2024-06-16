package com.po.fuck.model.lifetime;

public interface Destructable {
    public void destructor();

    static void register() {
        Manager.registerClass(
                new ClassData<Destructable>(Destructable.class, null, object -> object.destructor()));
    }
}
