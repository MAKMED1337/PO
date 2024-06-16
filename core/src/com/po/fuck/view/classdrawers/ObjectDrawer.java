package com.po.fuck.view.classdrawers;

import static com.po.fuck.model.constants.LayeringConstants.BACKGROUND;

import com.po.fuck.view.CenterDrawer;

public abstract class ObjectDrawer<T> {

    public abstract void draw(CenterDrawer drawer, T object);

    public int getZ() {
        return BACKGROUND;
    }
}
