package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.position.GeometryData;

import static com.po.fuck.model.Constants.COSMIC_BULLET_DAMAGE;
import static com.po.fuck.model.Constants.COSMIC_BULLET_LIFE_TIME;

public final class CosmicBullet extends Bullet {
    {
        damage = COSMIC_BULLET_DAMAGE;
        lifeTime = COSMIC_BULLET_LIFE_TIME;
        /* Temp solution, afterwards use AssetManager or .properties later */
        // width = new Sprite(new Texture("bullet2.png")).getWidth();
        // height = new Sprite(new Texture("bullet2.png")).getHeight();
    }

    CosmicBullet(Vector2 muzzle_position, float width, float height, Vector2 direction, int teamTag) {
        this.geometryData = new GeometryData();
        geometryData.setWidth(width);
        geometryData.setHeight(height);
        geometryData.setPosition(muzzle_position.cpy().add(direction.cpy().setLength(geometryData.getWidth() / 2)));
        this.teamTag = teamTag;
        this.velocity = direction.cpy().setLength(600); // speed
    }
}
