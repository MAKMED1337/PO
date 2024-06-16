package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.AssetsManagment.SpriteInfo;

import static com.po.fuck.model.Constants.COSMIC_BULLET_DAMAGE;
import static com.po.fuck.model.Constants.COSMIC_BULLET_LIFE_TIME;
import static com.po.fuck.model.Constants.COSMIC_BULLET_SPEED;

public final class CosmicBullet extends Bullet {
    {
        damage = COSMIC_BULLET_DAMAGE;
        lifeTime = COSMIC_BULLET_LIFE_TIME;
        geometryData = new GeometryData();
        geometryData.setWidth(SpriteInfo.getBasicAssetInfo(this.getClass()).getWidth());
        geometryData.setHeight(SpriteInfo.getBasicAssetInfo(this.getClass()).getHeight());
    }

    CosmicBullet(Vector2 muzzlePosition, Vector2 direction, int teamTag) {
        geometryData.setPosition(muzzlePosition.cpy().add(direction.cpy().setLength(geometryData.getWidth() / 2)));
        this.teamTag = teamTag;
        this.velocity = direction.cpy().setLength(COSMIC_BULLET_SPEED); // speed
    }
}
