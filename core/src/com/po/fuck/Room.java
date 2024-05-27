package com.po.fuck;

import static com.po.fuck.Constants.BACKGROUND_LAYER;
import static com.po.fuck.Constants.ENEMY_TEAM_TAG;

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

    protected void spawnEnemies() {
        Vector2 center = getPosition();
        Vector2 offset = new Vector2(sprite.getWidth() - 200, sprite.getHeight() - 300);

        // top left
        Manager.create(new BasicEnemy(center.cpy().mulAdd(offset, -0.5f)));

        // bottom right
        Manager.create(new BasicEnemy(center.cpy().mulAdd(offset, 0.5f)));
    }

    protected Vector2 getPosition() {
        return new Vector2(sprite.getWidth() * tilling_position.x, sprite.getHeight() * tilling_position.y);
    }

    protected void clear() {
        state = State.FINISHED;

        for (Managed<InvisibleWall> wall : walls)
            wall.destroy();
    }

    // returns raw walls, simply for inner collisions check
    protected InvisibleWall[] getWalls() {
        float h = sprite.getHeight(), w = sprite.getWidth();
        return new InvisibleWall[] {
                new InvisibleWall(getPosition().sub(0, h / 2), InvisibleWall.Type.HORIZONTAL, w),
                new InvisibleWall(getPosition().add(w / 2, 0), InvisibleWall.Type.VERTICAL, h),

                new InvisibleWall(getPosition().add(0, h / 2), InvisibleWall.Type.HORIZONTAL, w),
                new InvisibleWall(getPosition().sub(w / 2, 0), InvisibleWall.Type.VERTICAL, h),
        };
    }

    protected void start() {
        state = State.FIGHT;

        InvisibleWall[] rawWalls = getWalls();
        for (int i = 0; i < 4; ++i)
            walls[i] = Manager.create(rawWalls[i]);

        spawnEnemies();
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
            List<Collidable> players = inside.stream().filter(x -> x instanceof Player).toList();
            if (players.isEmpty())
                return;

            if (players.size() != 1)
                throw new AssertionError("Only one player should exist");

            Player player = (Player) players.get(0);

            boolean collide = false;
            for (InvisibleWall wall : getWalls())
                collide |= player.collide(wall.getCollision());

            if (!collide)
                start();
            return;
        } else if (state == State.FIGHT) {
            if (!inside.stream().anyMatch(x -> x instanceof Entity && ((Entity) x).getTeamTag() == ENEMY_TEAM_TAG))
                clear();
            return;
        } else
            throw new AssertionError("Unknow state");
    }
}
