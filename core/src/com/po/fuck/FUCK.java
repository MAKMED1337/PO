package com.po.fuck;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.updates.Initializer;

import static com.po.fuck.Constants.GAME_HEIGHT;
import static com.po.fuck.Constants.GAME_WIDTH;

public class FUCK extends ApplicationAdapter {
    SpriteBatch batch;
    Player player;
    private OrthographicCamera camera;

    public static Initializer initializer = new Initializer();
    public static EntityHandler entityHandler = new EntityHandler();

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
        batch = new SpriteBatch();
        player = new Player(new Sprite(new Texture("FUCKerWithoutHands2.png")));
//        entityHandler.createEnemy();
        entityHandler.createEnemy();
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
