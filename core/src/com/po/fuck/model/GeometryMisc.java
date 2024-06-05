package com.po.fuck.model;

import java.util.List;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.position.GeometryData;

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
        return to.getPosition().sub(from.getPosition());
    }

    /**
     * Finds the closest {@link Entity} to the specified main entity from a list of entities.
     *
     * @param <A> the type of the main entity, extending {@link Entity}
     * @param main the main entity from which distances are measured
     * @param list a list of entities to compare against the main entity
     * @return the {@link Entity} that is closest to the main entity, or {@code null} if the list is empty
     */
    public static<A extends Entity> Entity closest(A main, List<? extends Entity> list) {
        Entity closestEntity = null;
        for (Entity entity : list) {
            if (closestEntity == null || distance(main, closestEntity) > distance(main, entity))
                closestEntity = entity;
        }
        return closestEntity;
    }

    /**
     * Creates a rectangular {@link Polygon} based on the provided position and sprite.
     * Rotates the rectangle based on the given rotation.
     *
     * <p>The rectangle will be centered on the provided position, with its size
     * determined by the given width and height.</p>
     * 
     * @param geometryData the data of the rectangle
     * @param geometryData.position the center position of the rectangle, represented as a {@link Vector2}
     * @param geometryData.width the width of the rectangle
     * @param geometryData.height the height of the rectangle
     * @param geometryData.rotation the rotation of the rectangle (in degress); 0 is facing right
     * @return a {@link Polygon} representing the rectangle
     */
    public static Polygon createRectangle(GeometryData geometryData){
        Vector2 size = geometryData.getSize();
        size.scl(0.5f);

        Polygon polygon = new Polygon();
        polygon.setPosition(geometryData.getPosition().x, geometryData.getPosition().y);
        polygon.setRotation(geometryData.getRotationRad());
        polygon.setVertices(new float[] {
                size.x, size.y,
                -size.x, size.y,
                -size.x, -size.y,
                size.x, -size.y
        });
        return polygon;
    }
}
