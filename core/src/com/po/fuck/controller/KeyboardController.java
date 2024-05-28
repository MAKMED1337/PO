package com.po.fuck.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Player;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.movement.Boost;
import com.po.fuck.model.movement.Movement;

public class KeyboardController extends InputAdapter implements Updatable {
    private final Player player;

    // Prevent the situation when the buttons were pressed before the game and did
    // not get register.
    private boolean W = false, A = false, S = false, D = false;

    public KeyboardController(Player player) {
        this.player = player;
    }

    private Vector2 getDirection() {
        Vector2 result = new Vector2();
        if (W)
            result.y -= 1;
        if (A)
            result.x -= 1;
        if (S)
            result.y += 1;
        if (D)
            result.x += 1;
        return result;
    }

    private Movement getMovement(){
        return this.player.getMovement().get();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                W = true;
                break;
            case Input.Keys.A:
                A = true;
                break;
            case Input.Keys.S:
                S = true;
                break;
            case Input.Keys.D:
                D = true;
                break;
            case Input.Keys.CONTROL_LEFT:
                if (getMovement() instanceof Boost)
                    ((Boost) getMovement()).tryToUseBoost();
                break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                W = false;
                break;
            case Input.Keys.A:
                A = false;
                break;
            case Input.Keys.S:
                S = false;
                break;
            case Input.Keys.D:
                D = false;
                break;
        }

        return true;
    }

    @Override
    public void update(float delta) {
        player.getMovement().get().setDirection(getDirection());
    }
}
