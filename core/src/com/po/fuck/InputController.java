package com.po.fuck;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.movement.Boost;
import com.po.fuck.movement.Movement;

public class InputController extends InputAdapter {
    private final Vector2 direction = new Vector2(0, 0);
    Boost movement;

    InputController(Vector2 position) {
        movement = new Boost(
                new Movement(position, Constants.SPEED),
                Constants.BOOST_DISTANCE, Constants.BOOST_DURATION, Constants.BOOST_COOLDOWN
        );
    }

    public void update(float delta) {
        movement.update(delta);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                direction.y += 1;
                break;
            case Input.Keys.A:
                direction.x -= 1;
                break;
            case Input.Keys.S:
                direction.y -= 1;
                break;
            case Input.Keys.D:
                direction.x += 1;
                break;
            case Input.Keys.CONTROL_LEFT:
                movement.try_to_use_boost();
                break;
        }

        movement.setDirection(direction);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                direction.y -= 1;
                break;
            case Input.Keys.A:
                direction.x += 1;
                break;
            case Input.Keys.S:
                direction.y += 1;
                break;
            case Input.Keys.D:
                direction.x -= 1;
                break;
        }

        movement.setDirection(direction);
        return true;
    }
}
