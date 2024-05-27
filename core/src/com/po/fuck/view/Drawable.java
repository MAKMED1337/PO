package com.po.fuck.view;

import com.badlogic.gdx.math.Vector2;

public interface Drawable {
    default int get_z() { // could be moved inside getPosition
        return 0;
    }

    public Vector2 getPosition();
}

