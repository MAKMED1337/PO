package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Updatable;

import static com.po.fuck.Constants.GAME_HEIGHT;
import static com.po.fuck.Constants.GAME_WIDTH;

public class MouseController extends InputAdapter implements Updatable {
    private boolean pressed = false;

    Player player;

    {
        FUCK.initializer.init(this);
    }

    MouseController(Player player) {
        this.player = player;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        player.weapon.aim(new Vector2((float) (screenX * GAME_WIDTH) / Gdx.graphics.getWidth(), (float) (screenY * GAME_HEIGHT) / Gdx.graphics.getHeight()));
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return mouseMoved(screenX, screenY);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        pressed = true;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        pressed = false;
        return true;
    }

    @Override
    public void update(float delta) {
        if (pressed)
            player.weapon.attack();
    }
}
