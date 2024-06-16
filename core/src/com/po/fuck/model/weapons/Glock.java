package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.AssetsLoader.assetsDataFactory.WeaponLoader;
import com.po.fuck.model.Entity;
import com.po.fuck.AssetsManagment.SpriteInfo;
import com.po.fuck.view.Sprites.BasicSpriteInfo;

import static com.po.fuck.model.Constants.GLOCK_COOLDOWN;

public final class Glock extends Gun {
    {
        cooldown = GLOCK_COOLDOWN;
        BasicSpriteInfo thisInfo = SpriteInfo.getBasicAssetInfo(this.getClass());
        geometryData.setHeight(thisInfo.getHeight());
        geometryData.setWidth(thisInfo.getWidth());
    }
    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new CosmicBullet(muzzlePosition, direction, owner.getTeamTag());
    }
}
