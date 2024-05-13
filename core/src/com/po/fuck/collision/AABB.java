package com.po.fuck.collision;

import com.badlogic.gdx.math.Vector2;

public class AABB {
    Vector2 min, max;

    public AABB(Vector2 p1, Vector2 p2) {
        min = new Vector2(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
        max = new Vector2(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y));
    }

    public boolean lies(Vector2 point) {
        return min.x <= point.x && point.x <= max.x && min.y <= point.y && point.y <= max.y;
    }

    public boolean intersects(AABB other) {
        Vector2 mn = new Vector2(Math.max(min.x, other.min.x), Math.max(min.y, other.min.y));
        Vector2 mx = new Vector2(Math.min(max.x, other.max.x), Math.min(max.y, other.max.y));

        return mn.x <= mx.x && mn.y <= mx.y;
    }
}
