package com.po.fuck.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.model.Entity;

import static com.po.fuck.model.Constants.HEALTHBAR_HEIGHT;
import static com.po.fuck.model.Constants.HEALTHBAR_WIDTH;
import static com.po.fuck.view.DrawableMisc.createTexture;

public final class HealthBar {
    public final Sprite healthBarSprite;
    public final Sprite backgroundSprite;

    Entity entity;

    public HealthBar(Entity entity) {
        this.entity = entity;
        healthBarSprite = new Sprite(createTexture(HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT, new Color(0, 255, 0, 10)));
        backgroundSprite = new Sprite(createTexture(HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT, new Color(255, 0, 0, 10)));
        
        float healthPercentage = 1.0f * entity.getHP() / entity.MAX_HEALTH_POINTS;
        healthBarSprite.setSize((float) Math.ceil(healthPercentage * HEALTHBAR_WIDTH), HEALTHBAR_HEIGHT);
    }
}
