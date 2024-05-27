package com.po.fuck;

import static com.po.fuck.Constants.BACKGROUND_LAYER;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.collections.All;
import com.po.fuck.collision.Collidable;
import com.po.fuck.enemies.BasicEnemy;
import com.po.fuck.lifetime.Managed;
import com.po.fuck.lifetime.Manager;
import com.po.fuck.updates.Drawable;
import com.po.fuck.updates.Updatable;

public final class Room implements Drawable, Updatable {
    public Vector2 tilling_position;
    protected Sprite sprite = new Sprite(new Texture("island2.png"));

    private enum State {
        NOT_ENTERED,
        FIGHT,
        FINISHED,
    }

    State state = State.NOT_ENTERED;

    @SuppressWarnings("unchecked")
    protected Managed<InvisibleWall> walls[] = new Managed[4];

    Room(Vector2 tilling_position) {
        this.tilling_position = tilling_position;
    }

    @Override
    public int get_z() {
        return BACKGROUND_LAYER;
    }

    protected Vector2 getPosition() {
        return new Vector2(sprite.getWidth() * tilling_position.x, sprite.getHeight() * tilling_position.y);
    }

    void clear() {
        state = State.FINISHED;
        for (Managed<InvisibleWall> wall : walls)
            wall.destroy();
    }

    void start() {
        state = State.FIGHT;
        float h = sprite.getHeight(), w = sprite.getWidth();

        walls[0] = Manager.create(
                new InvisibleWall(getPosition().sub(0, h / 2), InvisibleWall.Type.HORIZONTAL, w));
        walls[2] = Manager.create(
                new InvisibleWall(getPosition().add(0, h / 2), InvisibleWall.Type.HORIZONTAL, w));

        walls[1] = Manager.create(
                new InvisibleWall(getPosition().add(w / 2, 0), InvisibleWall.Type.VERTICAL, h));
        walls[3] = Manager.create(
                new InvisibleWall(getPosition().sub(w / 2, 0), InvisibleWall.Type.VERTICAL, h));
    }

    @Override
    public void draw(CenterDrawer drawer) {
        drawer.draw(sprite, getPosition());
    }

    @Override
    public void update(float delta) {
        if (state == State.FINISHED)
            return;

        List<Collidable> inside = All.collidableCollection
                .collides(GeometryMisc.createRectangle(getPosition(), sprite));

        if (state == State.NOT_ENTERED) {
            if (inside.stream().anyMatch(x -> x instanceof Player))
                start();
            return;
        } else if (state == State.FIGHT) {
            if (!inside.stream().anyMatch(x -> x instanceof BasicEnemy))
                clear();
            return;
        } else
            throw new AssertionError("Unknow state");
    }
}
