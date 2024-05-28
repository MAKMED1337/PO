package com.po.fuck;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.po.fuck.view.Renderer;
import com.po.fuck.view.classdrawers.factories.AnimatedBulletDrawerFactory;
import com.po.fuck.view.classdrawers.factories.BulletDrawerFactory;
import com.po.fuck.view.classdrawers.factories.EntityDrawerFactory;
import com.po.fuck.view.classdrawers.factories.GameObjectDrawerFactory;
import com.po.fuck.view.classdrawers.factories.HandedWeaponDrawerFactory;
import com.po.fuck.model.Core;

public class FUCK extends ApplicationAdapter {

    Core core;
    Renderer renderer;

    @Override
    public void create() {
        core = new Core();
        renderer = new Renderer();
        core.initialize();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        core.update(delta);
        renderer.render(delta, core.getDrawableCollection());
    }

    @Override
    public void dispose() {
        
    }
}
