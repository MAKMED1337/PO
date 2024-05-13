package com.po.fuck.collision;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollidableCollection {
    private final ArrayList<Collidable> objects = new ArrayList<>();

    public void add(Collidable collidable) {
        objects.add(collidable);
    }

    public void remove(Collidable collidable) {
        objects.remove(collidable);
    }

    public List<Collidable> collides(AABB other) {
        return objects.stream().filter(x -> x.collide(other)).collect(Collectors.toList());
    }
}
