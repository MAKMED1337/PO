package com.po.fuck;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.enemies.BasicEnemy;
import com.po.fuck.updates.Initializer;

import static com.po.fuck.Constants.GAME_HEIGHT;
import static com.po.fuck.Constants.GAME_WIDTH;

public class FUCK extends ApplicationAdapter {
    public static Initializer initializer = new Initializer();
    public static Player player;

    SpriteBatch batch;
    private OrthographicCamera camera;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
        batch = new SpriteBatch();

        player = new Player(new Vector2(GAME_WIDTH / 2, GAME_HEIGHT / 2));

        new BasicEnemy(new Vector2(100, 100));
        new BasicEnemy(new Vector2(GAME_WIDTH - 100, GAME_HEIGHT - 100));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        float delta = Gdx.graphics.getDeltaTime();
        initializer.updatableCollection.update(delta);

        batch.begin();
        initializer.drawableCollection.draw(new CenterDrawer(batch));
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
