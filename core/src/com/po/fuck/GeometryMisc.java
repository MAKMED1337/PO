package com.po.fuck;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.collections.All;

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
    public static <A extends Entity> Entity findClosestOpponent(A entity) {
        ArrayList<Entity> opponents = All.entityCollection.getOpponents(entity.teamTag);
        if (opponents.isEmpty()) {
            return null;
        }
        Entity target = opponents.get(0);
        float dist = GeometryMisc.distance(entity, target);
        for (Entity opponent : opponents) {
            if (GeometryMisc.distance(entity, opponent) < dist) {
                dist = GeometryMisc.distance(entity, opponent);
                target = opponent;
            }
        }
        return target;
    }
    /**
     * Finds the closest entity to a given main entity from a list of other
     * entities.
     *
     * @param <A>  The type of the main entity, extending class C.
     * @param <B>  The type of the other entities in the list, extending class C.
     * @param <C>  The common base class for main entity and other entities,
     *             extending class Entity.
     * @param main The main entity.
     * @param list The list of other entities.
     * @return The closest entity to the main entity from the list, or null if the
     *         list is empty.
     */
    public static <A extends C, B extends C, C extends Entity> C closest(A main, ArrayList<B> list) {
        C closestEntity = null;
        for (B entity : list) {
            if (closestEntity == null || distance(main, closestEntity) > distance(main, entity)) {
                closestEntity = entity;
            }
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
