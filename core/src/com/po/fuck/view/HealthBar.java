package com.po.fuck.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.model.Updatable;

import static com.po.fuck.model.Constants.HEALTHBAR_OFFSET;
import static com.po.fuck.view.DrawableMisc.createTexture;

import java.util.ArrayList;

public final class HealthBar implements Drawable, Updatable {
    private final Sprite healthBarSprite;
    private final Sprite backgroundSprite;

    Entity entity;

    public HealthBar(Entity entity) {
        this.entity = entity;
        healthBarSprite = new Sprite(createTexture(100, 10, new Color(0, 255, 0, 10)));
        backgroundSprite = new Sprite(createTexture(100, 10, new Color(255, 0, 0, 10)));
    }

	@Override
	public void update(float delta) {
        float healthPercentage = 1.0f * entity.getHP() / entity.MAX_HEALTH_POINTS;
        int width = 100;
        int height = 10;
        healthBarSprite.setSize((float) Math.ceil(healthPercentage * width), height);
    }

    @Override
    public Vector2 getPosition() {
        return entity.getPosition().sub(0, entity.getSpriteList().get(0).getHeight() / 2 + HEALTHBAR_OFFSET);
    }

    @Override
    public ArrayList<Sprite> getSpriteList() {
        return new ArrayList<Sprite>() {{
            add(backgroundSprite);
            add(healthBarSprite);
        }};
    }
}
