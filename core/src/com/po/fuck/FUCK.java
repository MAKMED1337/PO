package com.po.fuck;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.collision.CollidableCollection;
import com.po.fuck.enemies.BasicEnemy;
import com.po.fuck.lifetime.Destructable;
import com.po.fuck.lifetime.Managed;
import com.po.fuck.lifetime.Manager;
import com.po.fuck.updates.UpdatableCollection;
import com.po.fuck.updates.DrawableCollection;

import static com.po.fuck.Constants.GAME_HEIGHT;
import static com.po.fuck.Constants.GAME_WIDTH;

public class FUCK extends ApplicationAdapter {
    static {
        forceInit(UpdatableCollection.class);
        forceInit(DrawableCollection.class);
        forceInit(CollidableCollection.class);
        forceInit(Destructable.class);
    }
    public static Managed<Player> player;

    SpriteBatch batch;
    private OrthographicCamera camera;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
        batch = new SpriteBatch();

        player = Manager.create(new Player(new Vector2(GAME_WIDTH / 2, GAME_HEIGHT / 2)));

        Manager.create(new BasicEnemy(new Vector2(100, 100)));
        Manager.create(new BasicEnemy(new Vector2(GAME_WIDTH - 100, GAME_HEIGHT - 100)));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        float delta = Gdx.graphics.getDeltaTime();
        UpdatableCollection.update(delta);

        batch.begin();
        DrawableCollection.draw(new CenterDrawer(batch));
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    // https://stackoverflow.com/questions/3560103/how-to-force-a-class-to-be-initialised
    public static <T> Class<T> forceInit(Class<T> klass) {
        try {
            Class.forName(klass.getName(), true, klass.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);  // Can't happen
        }
        return klass;
    }
}
