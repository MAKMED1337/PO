package com.po.fuck.view;

public interface Drawable {
    default int get_z() {
        return 0;
    }

    void draw(CenterDrawer drawer);
}

