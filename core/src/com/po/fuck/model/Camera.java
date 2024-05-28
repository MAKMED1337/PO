package com.po.fuck.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.view.CenterDrawer;
import static com.po.fuck.model.Constants.GAME_HEIGHT;
import static com.po.fuck.model.Constants.GAME_WIDTH;
import static com.po.fuck.model.Constants.CAMERA_SPEED;

public final class Camera extends CenterDrawer implements Updatable {
    public OrthographicCamera camera = new OrthographicCamera();
    private Vector2 position = new Vector2();
    private Vector2 target = new Vector2();

    public Camera() {
        super(new SpriteBatch());
        camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
    }

    @Override
    public void update(float delta) {
        // https://lisyarus.github.io/blog/posts/exponential-smoothing.html
        float factor = 1 - (float) Math.exp(-delta * CAMERA_SPEED);
        position.add(target.cpy().sub(position).scl(factor));
    }

    public Vector2 getPosition() {
        return position.cpy();
    }

    public void setPosition(Vector2 position) {
        target = position;
    }

    @Override
    public void draw(Sprite sprite, Vector2 position) {
        super.draw(sprite, position.cpy().sub(this.position).add(GAME_WIDTH / 2, GAME_HEIGHT / 2));
    }
    
    @Override
    public void drawGlobal(Sprite sprite, Vector2 global_position) {
        super.draw(sprite, global_position);
    }
}
