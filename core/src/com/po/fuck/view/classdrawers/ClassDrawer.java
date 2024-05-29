package com.po.fuck.view.classdrawers;

import com.po.fuck.view.CenterDrawer;

public abstract class ClassDrawer<T> {
    
    public abstract <Drawer extends CenterDrawer> void draw(Drawer drawer, T object);
}
