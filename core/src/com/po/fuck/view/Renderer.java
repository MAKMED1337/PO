package com.po.fuck.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.po.fuck.model.Constants;
import com.po.fuck.model.collections.DrawableCollection;

public class Renderer {
    SpriteBatch batch;

    private OrthographicCamera camera;

    public Renderer(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        batch = new SpriteBatch();
    }

    public void render(DrawableCollection drawableCollection){
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        drawableCollection.draw(new CenterDrawer(batch));
        batch.end();
    }

    public void dispose(){
        batch.dispose();
    }
}
