package com.po.fuck.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Updatable;

import static com.po.fuck.view.DrawableMisc.createTexture;

public final class HealthBar implements Updatable {
    public final Sprite healthBarSprite;
    public final Sprite backgroundSprite;

    Entity entity;

    public HealthBar(Entity entity) {
        this.entity = entity;
        healthBarSprite = new Sprite(createTexture(100, 10, new Color(0, 255, 0, 10)));
        backgroundSprite = new Sprite(createTexture(100, 10, new Color(255, 0, 0, 10)));
        update(0);
    }

	@Override
	public void update(float delta) {
        float healthPercentage = 1.0f * entity.getHP() / entity.MAX_HEALTH_POINTS;
        int width = 100;
        int height = 10;
        healthBarSprite.setSize((float) Math.ceil(healthPercentage * width), height);
    }
}
