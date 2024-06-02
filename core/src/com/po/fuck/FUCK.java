package com.po.fuck;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.po.fuck.view.Renderer;
import com.po.fuck.model.Core;

public class FUCK extends ApplicationAdapter {
    Core core;
    Renderer renderer;

    @Override
    public void create() {
        core = new Core();
        Core.initialize();
        renderer = new Renderer(Core.objectFollower.get());
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        core.update(delta);
        ArrayList<Object> drawables = new ArrayList<>();
        for(Object obj : core.getDrawableCollection()){
            drawables.add(obj);
        }
        drawables.add(Core.coinsCounter.get());
        renderer.render(drawables);
    }

    @Override
    public void dispose() {

    }
}
