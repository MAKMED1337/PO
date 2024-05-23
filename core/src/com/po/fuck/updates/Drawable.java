package com.po.fuck.updates;

import com.po.fuck.CenterDrawer;

public interface Drawable {
    default int get_z() {
        return 0;
    }

    void draw(CenterDrawer drawer);
}

