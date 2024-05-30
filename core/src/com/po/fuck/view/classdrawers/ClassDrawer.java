package com.po.fuck.view.classdrawers;

import com.po.fuck.view.CenterDrawer;

public abstract class ClassDrawer<T> {
    
    public abstract void draw(CenterDrawer drawer, T object);
}
