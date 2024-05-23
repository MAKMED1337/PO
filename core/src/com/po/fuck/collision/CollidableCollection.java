package com.po.fuck.collision;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.po.fuck.lifetime.Manager;
import com.po.fuck.lifetime.ClassData;

import com.badlogic.gdx.math.Polygon;

public class CollidableCollection {
    static {
        Manager.register_class(new ClassData<Collidable>(
                Collidable.class,
                object -> CollidableCollection.add(object),
                object -> CollidableCollection.remove(object)));
    }

    static private final ArrayList<Collidable> objects = new ArrayList<>();

    static public void add(Collidable collidable) {
        objects.add(collidable);
    }

    static public void remove(Collidable collidable) {
        objects.remove(collidable);
    }

    static public List<Collidable> collides(Polygon other) {
        return objects.stream().filter(x -> x.collide(other)).collect(Collectors.toList());
    }
}
