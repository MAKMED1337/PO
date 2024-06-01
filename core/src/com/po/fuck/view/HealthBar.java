package com.po.fuck.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;

import static com.po.fuck.view.Constants.HEALTHBAR_HEIGHT;
import static com.po.fuck.view.Constants.HEALTHBAR_WIDTH;
import static com.po.fuck.view.Constants.HEALTHBAR_OFFSET;
import static com.po.fuck.view.DrawableMisc.createTexture;

public final class HealthBar {
    protected Sprite healthBarSprite;
    protected Sprite backgroundSprite;

    private Entity entity;

    public HealthBar(Entity entity) {
        this.entity = entity;
    }

    public <Drawer extends CenterDrawer> void draw(Drawer drawer, float entityHeight){
        healthBarSprite = new Sprite(createTexture(HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT, Color.GREEN));
        backgroundSprite = new Sprite(createTexture(HEALTHBAR_WIDTH, HEALTHBAR_HEIGHT, Color.RED));
        
        float healthPercentage = 1.0f * entity.getHP() / entity.MAX_HEALTH_POINTS;
        healthBarSprite.setSize((float) Math.ceil(healthPercentage * HEALTHBAR_WIDTH), HEALTHBAR_HEIGHT);

        Vector2 position = entity.getPosition().sub(0 , spriteHeight / 2 + HEALTHBAR_OFFSET);

        drawer.draw(backgroundSprite, position);
        drawer.draw(healthBarSprite, position);
    }
}
