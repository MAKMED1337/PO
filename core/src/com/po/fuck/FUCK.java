package com.po.fuck;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.po.fuck.controller.Controller;
import com.po.fuck.model.Core;
import com.po.fuck.view.Renderer;

public class FUCK extends ApplicationAdapter {
    private Core core;
    private Renderer renderer;
    @SuppressWarnings("unused")
    private Controller controller;

    @Override
    public void create() {
        Core.initialize();
        Renderer.initialize();

        core = new Core();
        controller = new Controller(core);
        renderer = new Renderer(Core.objectFollower.get());
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        core.update(delta);
        renderer.render(core.getDrawableCollection());
    }
}
