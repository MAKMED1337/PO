package com.po.fuck;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class GeometryMisc {

    /**
     * Calculates the distance between two entities.
     *
     * @param <A> The type of the first entity, extending class Entity.
     * @param <B> The type of the second entity, extending class Entity.
     * @param a   The first entity.
     * @param b   The second entity.
     * @return The distance between the two entities.
     */
    public static <A extends Entity, B extends Entity> float distance(A a, B b) {
        return direction(a, b).len();
    }

    /**
     * Calculates the direction from one entity to another.
     *
     * @param <A>  The type of the entity from which the direction is calculated,
     *             extending class Entity.
     * @param <B>  The type of the entity to which the direction is calculated,
     *             extending class Entity.
     * @param from The entity from which the direction is calculated.
     * @param to   The entity to which the direction is calculated.
     * @return The direction vector from the 'from' entity to the 'to' entity.
     */
    public static <A extends Entity, B extends Entity> Vector2 direction(A from, B to) {
        return to.position.cpy().sub(from.position);
    }

    /**
     * Finds the closest entity to a given main entity from a list of other
     * entities.
     * @param main The main entity.
     * @param list The list of other entities.
     * @return The closest entity to the main entity from the list, or null if the
     *         list is empty.
     */
    public static<A extends Entity> A closest(A main, List<A> list) {
        A closestEntity = null;
        for (A entity : list) {
            if (closestEntity == null || distance(main, closestEntity) > distance(main, entity))
                closestEntity = entity;
        }
        return closestEntity;
    }

    public static Polygon createRectangle(Vector2 position, Sprite sprite) {
        Vector2 size = new Vector2(sprite.getWidth(), sprite.getHeight());
        size.scl(0.5f);

        Polygon polygon = new Polygon();
        polygon.setPosition(position.x, position.y);
        polygon.setRotation(-sprite.getRotation());
        polygon.setVertices(new float[] {
                size.x, size.y,
                -size.x, size.y,
                -size.x, -size.y,
                size.x, -size.y
        });
        return polygon;
    }
}
