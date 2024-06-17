package com.po.fuck.view;

import static com.po.fuck.view.DrawableMisc.createTexture;
import static com.po.fuck.view.RenderConstants.HEALTHBAR_HEIGHT;
import static com.po.fuck.view.RenderConstants.HEALTHBAR_OFFSET;
import static com.po.fuck.view.RenderConstants.HEALTHBAR_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;

public final class HealthBar {
    protected Sprite healthBarSprite;
    protected Sprite backgroundSprite;

    private Entity entity;

    public HealthBar(Entity entity) {
        this.entity = entity;
    }

    public void draw(CenterDrawer drawer) {
        healthBarSprite = new Sprite(createTexture(HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT, Color.GREEN));
        backgroundSprite = new Sprite(createTexture(HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT, Color.RED));

        float healthPercentage = 1.0f * entity.getHP() / entity.MAX_HEALTH_POINTS;
        healthBarSprite.setSize((float) Math.ceil(healthPercentage * HEALTHBAR_WIDTH), HEALTHBAR_HEIGHT);

        Vector2 position = entity.getPosition().sub(0, entity.getGeometryData().getHeight() / 2 + HEALTHBAR_OFFSET);

        drawer.draw(backgroundSprite, position);
        drawer.draw(healthBarSprite, position);
    }
}
