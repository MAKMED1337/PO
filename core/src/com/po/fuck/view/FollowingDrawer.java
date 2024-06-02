package com.po.fuck.view;

import static com.po.fuck.view.Constants.GAME_HEIGHT;
import static com.po.fuck.view.Constants.GAME_WIDTH;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.ObjectFollower;

public class FollowingDrawer extends CenterDrawer {

    private ObjectFollower objectFollower;

    public FollowingDrawer(SpriteBatch batch, ObjectFollower objectFollowing){
        super(batch);
        this.objectFollower = objectFollowing;
    }

    @Override
    public void draw(Sprite sprite, Vector2 position) {
        super.draw(sprite, position.cpy()
            // Subtract the position of the object being followed from the copied position
            .sub(this.objectFollower.getPosition())
            // Add half the game width and height to center the sprite on the screen
            .add(GAME_WIDTH / 2, GAME_HEIGHT / 2));
    }
    
    @Override
    public void drawGlobal(Sprite sprite, Vector2 globalPosition) {
        super.draw(sprite, globalPosition);
    }
}
