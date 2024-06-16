package com.po.fuck.model.weapons;

import static com.po.fuck.model.constants.BulletsConstants.COSMIC_BULLET_DAMAGE;
import static com.po.fuck.model.constants.BulletsConstants.COSMIC_BULLET_LIFE_TIME;
import static com.po.fuck.model.constants.BulletsConstants.COSMIC_BULLET_SPEED;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.position.GeometryData;

public final class CosmicBullet extends Bullet {
    {
        damage = COSMIC_BULLET_DAMAGE;
        lifeTime = COSMIC_BULLET_LIFE_TIME;
        geometryData = new GeometryData();
        geometryData.setWidth(new Sprite(new Texture("bullet2.png")).getWidth());
        geometryData.setHeight(new Sprite(new Texture("bullet2.png")).getHeight());
    }

    CosmicBullet(Vector2 muzzlePosition, Vector2 direction, int teamTag) {
        geometryData.setPosition(muzzlePosition.cpy().add(direction.cpy().setLength(geometryData.getWidth() / 2)));
        this.teamTag = teamTag;
        this.velocity = direction.cpy().setLength(COSMIC_BULLET_SPEED); // speed
    }
}
