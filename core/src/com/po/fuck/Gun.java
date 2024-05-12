package com.po.fuck;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Drawable;

import static com.po.fuck.Constants.DISTANCE_FACTOR;
import static com.po.fuck.Constants.MAX_DISTANCE_FROM_BODY;

public class Gun implements Drawable {
    {
        FUCK.initializer.init(this);
    }

    private final Sprite sprite;
    private final Player owner;
    protected Vector2 aiming = null;

    Gun(Player owner, Sprite sprite) {
        this.sprite = sprite;
        this.owner = owner;
    }

    void aim(Vector2 pos) {
        aiming = pos;
    }

    @Override
    public void draw(CenterDrawer drawer) {
        if (aiming == null)
            return;

        Vector2 direction = aiming.cpy().sub(owner.position);
        direction.setLength(Math.min(direction.len() / DISTANCE_FACTOR, MAX_DISTANCE_FROM_BODY));

        float angle = direction.angleDeg();
        sprite.setRotation(-angle);
        sprite.setFlip(false, angle >= 90 && angle <= 270);

        Vector2 drawingPosition = owner.position.cpy().add(direction);
        drawer.draw(sprite, drawingPosition);
    }
}
