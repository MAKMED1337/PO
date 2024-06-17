package com.po.fuck.model;

import static com.po.fuck.model.Constants.GAME_BORDER;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.enemies.Spawner;
import com.po.fuck.model.lifetime.Destructable;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.GeometryData;

public final class Core implements Updatable {
    private Managed<Player> player;
    private Managed<Coins> coinsCounter;
    private Spawner spawner;
    public static Managed<ObjectFollower> objectFollower;

    public static void initialize() {
        Destructable.register();
        All.initialize();

        objectFollower = Manager.create(new ObjectFollower());
    }

    public Core() {
        player = Manager.create(new Player(new GeometryData(new Vector2(),
                new Sprite(new Texture("FUCKerWithoutHands2.png")).getWidth(),
                new Sprite(new Texture("FUCKerWithoutHands2.png")).getHeight(), 0)));

        coinsCounter = Manager.create(new Coins());
        spawner = new Spawner(coinsCounter.get());

        Manager.create(new Room(new Vector2(0, 0),
                new Sprite(new Texture("island2.png")).getWidth(),
                new Sprite(new Texture("island2.png")).getHeight(),
                spawner));
        Manager.create(new Room(new Vector2(1, 0),
                new Sprite(new Texture("island2.png")).getWidth(),
                new Sprite(new Texture("island2.png")).getHeight(),
                spawner));

        // Creating some game borders to destroy the bullets that went off the map.
        // We can not use here VERTICAL/HORIZONTAL, because if something went off the
        // map, then we want to catch with a thick wall, because it can be laggy or
        // something else.
        final int HUGE = 1000, HUGE2 = 2 * HUGE, SIZE = GAME_BORDER + HUGE2;
        Manager.create(new InvisibleWall(new Vector2(-GAME_BORDER - HUGE, 0), new Vector2(HUGE2, SIZE)));
        Manager.create(new InvisibleWall(new Vector2(-GAME_BORDER + HUGE, 0), new Vector2(HUGE2, SIZE)));

        Manager.create(new InvisibleWall(new Vector2(0, -GAME_BORDER - HUGE), new Vector2(SIZE, HUGE2)));
        Manager.create(new InvisibleWall(new Vector2(0, -GAME_BORDER + HUGE), new Vector2(SIZE, HUGE2)));
    }

    public Player getPlayer() {
        return player.get();
    }

    @Override
    public void update(float delta) {
        if (player.get() == null)
            player = Manager.create(new Player(new GeometryData(new Vector2(),
                    new Sprite(new Texture("FUCKerWithoutHands2.png")).getWidth(),
                    new Sprite(new Texture("FUCKerWithoutHands2.png")).getHeight(), 0)));

        objectFollower.get().setTargetPosition(player.get().getPosition());

        All.updatableCollection.update(delta);
    }

    public DrawableCollection getDrawableCollection() {
        return All.drawableCollection;
    }
}
