package com.po.fuck.model.enemies;

import static com.po.fuck.model.Constants.BASIC_ENEMY_SPEED;
import static com.po.fuck.model.Constants.BASIC_ENEMY_HEALTH;
import static com.po.fuck.model.Constants.BASIC_ENEMY_REWARD;
import static com.po.fuck.model.Constants.ENEMY_TEAM_TAG;

import com.po.fuck.AssetsManagement.SpriteInfoManager;
import com.po.fuck.model.Entity;
import com.po.fuck.model.GeometryMisc;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.movement.BasicMovement;
import com.po.fuck.model.position.GeometryData;
import com.po.fuck.model.weapons.Glock;
import com.po.fuck.model.weapons.Weapon;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.view.Sprites.BasicSpriteInfo;

/**
 * Class representing an enemy entity in the game.
 * Inherits from the Entity class and adds functionality specific to enemies.
 */
public final class BasicEnemy extends Entity implements Updatable {
    {
        weapon = Manager.create(new Glock(this));
        movement = Manager.create(new BasicMovement(this, BASIC_ENEMY_SPEED));
        teamTag = ENEMY_TEAM_TAG;
        reward = BASIC_ENEMY_REWARD;
        BasicSpriteInfo info = SpriteInfoManager.getBasicSpriteInfo(this.getClass());
        geometryData.setHeight(info.getFrameHeight());
        geometryData.setWidth(info.getFrameWidth());
    }

    public BasicEnemy(GeometryData geometryData) {
        super(geometryData, BASIC_ENEMY_HEALTH);
    }

    @Override
    public void update(float delta) {
        Entity target = GeometryMisc.closest(this, All.entityCollection.getOpponents(this.teamTag));
        if (target == null) return;
        Vector2 targetPosition = target.getPosition();
        Weapon actualWeapon = weapon.get();
        if (actualWeapon == null) return;

        actualWeapon.aim(targetPosition);
        actualWeapon.attack();
        movement.get().setDirection(targetPosition.sub(getPosition()));
    }

}
