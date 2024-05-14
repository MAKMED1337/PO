package com.po.fuck;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.updates.Drawable;
import com.po.fuck.updates.Updatable;

import static com.po.fuck.Constants.HEALTHBAR_OFFSET;
import static com.po.fuck.DrawableMisc.createTexture;

public class HealthBar implements Drawable, Updatable {
    {
        FUCK.initializer.init(this);
    }

    private final Sprite healthBarSprite;
    private final Sprite backgroundSprite;

    private final Texture healthBarTexture;
    private final Texture backgroundTexture;

    Entity entity;

    HealthBar(Entity entity){
        this.entity = entity;
        healthBarTexture = createTexture(100,10,new Color(0,255,0,10));
        backgroundTexture = createTexture(100, 10, new Color(255,0,0,10));
        healthBarSprite = new Sprite(healthBarTexture);
        backgroundSprite = new Sprite(backgroundTexture);
    }

	@Override
	public void draw(CenterDrawer drawer) {
        Vector2 drawingPosition = entity.position.cpy().mulAdd(HEALTHBAR_OFFSET, -(entity.sprite.getHeight()/2f)).sub(HEALTHBAR_OFFSET);
        drawer.draw(backgroundSprite, drawingPosition);
        drawer.draw(healthBarSprite, drawingPosition);
	}

	@Override
	public void update(float delta) {
        // System.out.println(this.toString() + ", health_points: " + this.entity.health_points);
        float healthPercentage = 1.0f * entity.health_points / entity.MAX_HEALTH_POINTS;
        int width = 100;
        int height = 10;
        healthBarSprite.setSize((float)Math.ceil(healthPercentage * width), height);
	}

}
