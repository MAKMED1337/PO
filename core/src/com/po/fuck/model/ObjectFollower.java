package com.po.fuck.model;

import com.badlogic.gdx.math.Vector2;

import static com.po.fuck.model.Constants.CAMERA_SPEED;

public final class ObjectFollower implements Updatable {
    private Vector2 position = new Vector2();
    private Vector2 target = new Vector2();

    @Override
    public void update(float delta) {
        // https://lisyarus.github.io/blog/posts/exponential-smoothing.html
        float factor = 1 - (float) Math.exp(-delta * CAMERA_SPEED);
        position.add(target.cpy().sub(position).scl(factor));
    }

    public Vector2 getPosition() {
        return position.cpy();
    }

    public void setTargetPosition(Vector2 position) {
        target = position;
    }
}
