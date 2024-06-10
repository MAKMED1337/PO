package com.po.fuck.controller;

import static com.po.fuck.view.Constants.GAME_HEIGHT;
import static com.po.fuck.view.Constants.GAME_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Core;
import com.po.fuck.model.Player;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.weapons.Weapon;

public final class MouseController extends InputAdapter implements Updatable {
    private boolean pressed = false;
    private Vector2 lastLocalPosition = new Vector2();

    Player player;

    public MouseController(Player player) {
        this.player = player;
    }

    protected Weapon getWeapon() {
        return player.getWeapon().get();
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        lastLocalPosition = new Vector2((float) (screenX * GAME_WIDTH) / Gdx.graphics.getWidth(),
                (float) (screenY * GAME_HEIGHT) / Gdx.graphics.getHeight());
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
        // First, we need to calculate our aiming position relative to the center of the
        // screen.
        Vector2 centerPosition = lastLocalPosition.cpy().sub(GAME_WIDTH / 2, GAME_HEIGHT / 2);

        // Second, we need to add our relative position to the camera's position
        // (because we are both centered in the center of the screen) to obtain global
        // world's position.
        Vector2 actualPosition = centerPosition.cpy().add(Core.objectFollower.get().getPosition());

        Weapon weapon = getWeapon();
        if (weapon == null)
            return;

        weapon.aim(actualPosition);
        if (pressed)
            weapon.attack();
    }
}
