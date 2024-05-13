package com.po.fuck;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class GeometryMisc {

    public static <A extends Entity, B extends Entity> float distance(A a, B b){
        Vector2 at = new Vector2(a.position);
        Vector2 bt = new Vector2(b.position);
        return at.sub(bt).len();
    }

    public static <A extends Entity, B extends Entity> Vector2 direction(A from, B to){
        Vector2 at = new Vector2(from.position);
        Vector2 bt = new Vector2(to.position);
        return bt.sub(at);
    }

    public static <A extends C,B extends C,C extends Entity> C closest(A main, ArrayList<B> list){
        C closestEntity = null;
        for(B entity : list){
            if(closestEntity == null || distance(main, closestEntity) > distance(main, entity)){
                closestEntity = entity;
            }
        }
        return closestEntity;
    }
}
