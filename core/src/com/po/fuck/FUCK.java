package com.po.fuck;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.enemies.BasicEnemy;
import com.po.fuck.lifetime.Destructable;
import com.po.fuck.lifetime.Managed;
import com.po.fuck.lifetime.Manager;
import com.po.fuck.collections.All;

import static com.po.fuck.Constants.GAME_HEIGHT;
import static com.po.fuck.Constants.GAME_WIDTH;

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

        Manager.create(new BasicEnemy(new Vector2(-GAME_WIDTH / 2 + 150, -GAME_HEIGHT / 2 + 150)));
        Manager.create(new BasicEnemy(new Vector2(GAME_WIDTH / 2 - 150, GAME_HEIGHT / 2 - 150)));
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
