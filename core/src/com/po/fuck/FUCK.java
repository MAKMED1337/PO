package com.po.fuck;

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
        renderer.render(core.getDrawableCollection());
    }

    @Override
    public void dispose() {
        
    }
}
