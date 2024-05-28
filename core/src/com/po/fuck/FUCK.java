package com.po.fuck;

import static com.po.fuck.Constants.GAME_BORDER;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.lifetime.Destructable;
import com.po.fuck.lifetime.Managed;
import com.po.fuck.lifetime.Manager;
import com.po.fuck.collections.All;

public class FUCK extends ApplicationAdapter {
    static {
        forceInit(Destructable.class);
        forceInit(All.class);
    }
    public static Managed<Player> player;
    public static Managed<Camera> camera;

    @Override
    public void create() {
        camera = Manager.create(new Camera());
        player = Manager.create(new Player(new Vector2()));

        Manager.create(new Room(new Vector2(0, 0)));
        Manager.create(new Room(new Vector2(1, 0)));

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
    public void render() {
        if (player.get() == null)
            player = Manager.create(new Player(new Vector2()));

        camera.get().setPosition(player.get().getPosition());

        float delta = Gdx.graphics.getDeltaTime();
        All.updatableCollection.update(delta);

        camera.get().draw_all();
    }

    // https://stackoverflow.com/questions/3560103/how-to-force-a-class-to-be-initialised
    public static <T> Class<T> forceInit(Class<T> klass) {
        try {
            Class.forName(klass.getName(), true, klass.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e); // Can't happen
        }
        return klass;
    }
}
