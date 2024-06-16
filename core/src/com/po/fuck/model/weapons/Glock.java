package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;
import com.po.fuck.AssetsManagement.SpriteInfo;
import com.po.fuck.view.Sprites.BasicSpriteInfo;

import static com.po.fuck.model.Constants.GLOCK_COOLDOWN;

public final class Glock extends Gun {
    {
        cooldown = GLOCK_COOLDOWN;
        BasicSpriteInfo thisInfo = SpriteInfo.getBasicSpriteInfo(this.getClass());
        geometryData.setHeight(thisInfo.getFrameHeight());
        geometryData.setWidth(thisInfo.getFrameWidth());
    }
    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new CosmicBullet(muzzlePosition, direction, owner.getTeamTag());
    }
}
