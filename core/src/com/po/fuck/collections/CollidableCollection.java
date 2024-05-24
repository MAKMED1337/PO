package com.po.fuck.collections;

import java.util.List;
import java.util.stream.Collectors;

import com.po.fuck.collision.Collidable;

import com.badlogic.gdx.math.Polygon;

public class CollidableCollection extends SimpleCollection<Collidable> {
    CollidableCollection() {
        super(Collidable.class);
    }

    public List<Collidable> collides(Polygon other) {
        return objects.stream().filter(x -> x.collide(other)).collect(Collectors.toList());
    }
}
