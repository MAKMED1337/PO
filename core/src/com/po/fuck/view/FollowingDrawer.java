package com.po.fuck.view;

import static com.po.fuck.view.RenderConstants.HEIGHT;
import static com.po.fuck.view.RenderConstants.WIDTH;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.ObjectFollower;

public class FollowingDrawer extends CenterDrawer {

    private ObjectFollower objectFollower;

    public FollowingDrawer(SpriteBatch batch, ObjectFollower objectFollowing) {
        super(batch);
        this.objectFollower = objectFollowing;
    }

    @Override
    public void draw(Sprite sprite, Vector2 position) {
        super.draw(sprite,
                position.cpy()
                        // Calculating relative position by subtracting the position of the object being
                        // followed
                        .sub(this.objectFollower.getPosition())
                        // Centering the sprite on the screen by adding half the game width and height
                        .add(WIDTH / 2, HEIGHT / 2));
    }

    @Override
    public void drawGlobal(Sprite sprite, Vector2 globalPosition) {
        super.draw(sprite, globalPosition);
    }
}
