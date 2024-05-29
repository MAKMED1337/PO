package com.po.fuck.view;

import static com.po.fuck.model.Constants.GAME_HEIGHT;
import static com.po.fuck.model.Constants.GAME_WIDTH;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.ObjectFollower;

public class FollowingDrawer extends CenterDrawer {

    ObjectFollower objectFollowing;

    protected FollowingDrawer(SpriteBatch sprite, ObjectFollower objectFollowing){
        super(sprite);
        this.objectFollowing = objectFollowing;
    }

    @Override
    public void draw(Sprite sprite, Vector2 position) {
        super.draw(sprite, position.cpy().sub(this.objectFollowing.getPosition()).add(GAME_WIDTH / 2, GAME_HEIGHT / 2));
    }
    
    @Override
    public void drawGlobal(Sprite sprite, Vector2 global_position) {
        super.draw(sprite, global_position);
    }
}
