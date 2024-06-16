package com.po.fuck.model.weapons;

import static com.po.fuck.model.constants.BalanceConstants.GLOCK_COOLDOWN;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.Entity;

public final class Glock extends Gun {
    {
        cooldown = GLOCK_COOLDOWN;
        geometryData.setHeight(new Sprite(new Texture("glock3.png")).getHeight());
        geometryData.setWidth(new Sprite(new Texture("glock3.png")).getWidth());
    }

    public Glock(Entity owner) {
        super(owner);
    }

    @Override
    protected Bullet shoot(Vector2 muzzlePosition, Vector2 direction) {
        return new CosmicBullet(muzzlePosition, direction, owner.getTeamTag());
    }
}
