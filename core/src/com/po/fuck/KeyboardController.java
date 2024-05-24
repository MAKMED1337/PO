package com.po.fuck;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.movement.Boost;

public class KeyboardController extends InputAdapter {
    private final Vector2 direction = new Vector2(0, 0);
    private final Player player;

    KeyboardController(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                direction.y -= 1;
                break;
            case Input.Keys.A:
                direction.x -= 1;
                break;
            case Input.Keys.S:
                direction.y += 1;
                break;
            case Input.Keys.D:
                direction.x += 1;
                break;
            case Input.Keys.CONTROL_LEFT:
                if (player.movement.get() instanceof Boost)
                    ((Boost) player.movement.get()).tryToUseBoost();
                break;
        }

        player.movement.get().setDirection(direction);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                direction.y += 1;
                break;
            case Input.Keys.A:
                direction.x += 1;
                break;
            case Input.Keys.S:
                direction.y -= 1;
                break;
            case Input.Keys.D:
                direction.x -= 1;
                break;
        }

        player.movement.get().setDirection(direction);
        return true;
    }
}
