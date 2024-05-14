package com.po.fuck;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Drawable;
import com.po.fuck.updates.Updatable;

import static com.po.fuck.Constants.HEALTHBAR_OFFSET;
import static com.po.fuck.DrawableMisc.createTexture;

public final class HealthBar implements Drawable, Updatable {
    {
        FUCK.initializer.init(this);
    }

    private final Sprite healthBarSprite;
    private final Sprite backgroundSprite;

    Entity entity;

    HealthBar(Entity entity) {
        this.entity = entity;
        healthBarSprite = new Sprite(createTexture(100, 10, new Color(0, 255, 0, 10)));
        backgroundSprite = new Sprite(createTexture(100, 10, new Color(255, 0, 0, 10)));
    }

	@Override
	public void draw(CenterDrawer drawer) {
        Vector2 drawingPosition = entity.getPosition().sub(0, entity.sprite.getHeight() / 2 + HEALTHBAR_OFFSET);

        drawer.draw(backgroundSprite, drawingPosition);
        drawer.draw(healthBarSprite, drawingPosition);
	}

	@Override
	public void update(float delta) {
        float healthPercentage = 1.0f * entity.health_points / entity.MAX_HEALTH_POINTS;
        int width = 100;
        int height = 10;
        healthBarSprite.setSize((float) Math.ceil(healthPercentage * width), height);
    }
}
