package com.po.fuck.model;

import static com.po.fuck.model.Constants.GAME_BORDER;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.lifetime.Destructable;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.GeometryData;

public class Core implements Updatable {
    public Managed<Player> player;
    public static Managed<Coins> coinsCounter;
    public static Managed<ObjectFollower> objectFollower;

    public static void initialize() {
        Destructable.register();
        All.initialize();

        objectFollower = Manager.create(new ObjectFollower());
        coinsCounter = Manager.create(new Coins());
    }

    public Core() {
        player = Manager.create(new Player(new GeometryData(new Vector2(),
                new Sprite(new Texture("FUCKerWithoutHands2.png")).getWidth(),
                new Sprite(new Texture("FUCKerWithoutHands2.png")).getHeight(), 0)));

        Manager.create(new Room(new Vector2(0, 0),
                new Sprite(new Texture("island2.png")).getWidth(),
                new Sprite(new Texture("island2.png")).getHeight()));
        Manager.create(new Room(new Vector2(1, 0),
                new Sprite(new Texture("island2.png")).getWidth(),
                new Sprite(new Texture("island2.png")).getHeight()));

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
