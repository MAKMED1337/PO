package com.po.fuck.model.drawables;

public interface Drawable {
    default int getZ() {
        return 0;
    }
}
