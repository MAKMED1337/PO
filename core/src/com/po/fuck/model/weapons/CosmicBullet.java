package com.po.fuck.model.weapons;

import static com.po.fuck.model.constants.BalanceConstants.COSMIC_BULLET_DAMAGE;
import static com.po.fuck.model.constants.BalanceConstants.COSMIC_BULLET_LIFE_TIME;
import static com.po.fuck.model.constants.BalanceConstants.COSMIC_BULLET_SPEED;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.AssetsManagement.BasicSpriteManager;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.Sprites.BasicSpriteInfo;

public final class CosmicBullet extends Bullet {
    {
        damage = COSMIC_BULLET_DAMAGE;
        lifeTime = COSMIC_BULLET_LIFE_TIME;
        geometryData = new GeometryData();
        BasicSpriteInfo info = BasicSpriteManager.getBasicSpriteInfo(this.getClass());
        geometryData.setSize(new Vector2(info.getWidth(), info.getHeight()));

    }

    CosmicBullet(Vector2 muzzlePosition, Vector2 direction, int teamTag) {
        geometryData.setPosition(muzzlePosition.cpy().add(direction.cpy().setLength(geometryData.getWidth() / 2)));
        this.teamTag = teamTag;
        this.velocity = direction.cpy().setLength(COSMIC_BULLET_SPEED); // speed
    }
}
