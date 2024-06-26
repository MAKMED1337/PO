package com.po.fuck.model;

import static com.po.fuck.assetsManagement.SpriteLoaders.basicSpriteLoader;
import static com.po.fuck.model.constants.TagsConstants.ENEMY_TEAM_TAG;

import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.collision.Collidable;
import com.po.fuck.model.drawables.PositionDrawable;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.model.enemies.Spawner;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.position.PositionData;
import com.po.fuck.model.sprites.BasicSpriteInfo;

public class Room implements PositionDrawable, Updatable {
    public Vector2 tillingPosition;
    protected GeometryData geometryData;
    protected Spawner spawner;

    private enum State {
        NOT_ENTERED,
        FIGHT,
        FINISHED,
    }

    State state = State.NOT_ENTERED;

    @SuppressWarnings("unchecked")
    protected Managed<InvisibleWall> walls[] = new Managed[4];

    public Room(Vector2 tillingPosition, Spawner spawner) {
        this.tillingPosition = tillingPosition;
        this.spawner = spawner;

        BasicSpriteInfo info = basicSpriteLoader.getSpriteInfo(this.getClass());
        this.geometryData = new GeometryData(new PositionData(
                new Vector2(info.getWidth() * tillingPosition.x, info.getHeight() * tillingPosition.y)),
                info.getSize());
    }

    protected void spawnEnemies() {
        Vector2 center = getPosition();

        // Magic numbers are here, because this room is an example
        Vector2 offset = new Vector2(geometryData.getWidth() - 200, geometryData.getHeight() - 300);

        // top left
        spawner.spawn(new BasicEnemy(new PositionData(center.cpy().mulAdd(offset, -0.5f), 0)));

        // bottom right
        spawner.spawn(new BasicEnemy(new PositionData(center.cpy().mulAdd(offset, 0.5f), 0)));
    }

    public Vector2 getPosition() {
        return geometryData.getPosition();
    }

    protected void clear() {
        state = State.FINISHED;

        for (Managed<InvisibleWall> wall : walls)
            wall.destroy();
    }

    // returns raw walls, simply for inner collisions check
    protected InvisibleWall[] getWalls() {
        float height = geometryData.getHeight();
        float width = geometryData.getWidth();
        return new InvisibleWall[] {
                new InvisibleWall(getPosition().sub(0, height / 2), InvisibleWall.Type.HORIZONTAL, width),
                new InvisibleWall(getPosition().add(width / 2, 0), InvisibleWall.Type.VERTICAL, height),

                new InvisibleWall(getPosition().add(0, height / 2), InvisibleWall.Type.HORIZONTAL, width),
                new InvisibleWall(getPosition().sub(width / 2, 0), InvisibleWall.Type.VERTICAL, height),
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
    public void update(float delta) {
        // If we have finished this room, nothing to update.
        if (state == State.FINISHED)
            return;

        // List of all the entities inside this room.
        List<Collidable> inside = All.collidableCollection
                .collides(GeometryMisc.createRectangle(
                        new GeometryData(getPosition(), geometryData.getWidth(), geometryData.getHeight(), 0)));

        if (state == State.NOT_ENTERED) {
            // If the player has not entered before this time, we need to check if he has
            // entered now, and change the state to `FIGHT` if so.

            List<Collidable> players = inside.stream().filter(x -> x instanceof Player).toList();
            if (players.isEmpty())
                return;

            if (players.size() != 1)
                throw new AssertionError("Only one player may exist");

            Player player = (Player) players.get(0);

            // Check if the player collides with any of the walls, if so then we can not
            // start a fight in this room, because he will be stuck.
            boolean collide = false;
            for (InvisibleWall wall : getWalls())
                collide |= player.collide(wall.getCollision());

            if (!collide)
                start();
            return;
        } else if (state == State.FIGHT) {
            // If we are already fighting, we need to check if every enemy is dead to stop
            // the fight.

            if (!inside.stream().anyMatch(x -> x instanceof Entity entity && entity.getTeamTag() == ENEMY_TEAM_TAG))
                clear();
            return;
        } else {
            // Unreachable state (we only have 3 states for now), just in case if something
            // change in the future.
            throw new AssertionError("Unknown state");
        }
    }

    @Override
    public GeometryData getGeometryData() {
        return new GeometryData(geometryData);
    }
}
