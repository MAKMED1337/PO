package com.po.fuck.model.weapons;

import com.badlogic.gdx.math.Vector2;
//<<<<<<< HEAD:core/src/com/po/fuck/weapons/Gun.java
//import com.po.fuck.Entity;
//import com.po.fuck.GeometryMisc;
//import com.po.fuck.updates.Updatable;
//=======
import com.po.fuck.model.Entity;
import com.po.fuck.model.Updatable;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.GeometryMisc;
//>>>>>>> 10-mvc:core/src/com/po/fuck/model/weapons/Gun.java

public abstract class Gun extends HandedWeapon implements Updatable {
    protected float cooldown;
    private float cooldownLeft = 0;

    protected Vector2 muzzlePosition;
    Gun(Entity owner) {
        super(owner);
    }

    // something like bullet factory
    // should not perform any checks
    protected abstract Bullet shoot(Vector2 muzzle_position, Vector2 direction);

    @Override
    public boolean attack() {
        if (aiming == null)
            return false;

        if (cooldownLeft > 0)
            return false;

        Vector2 direction = getDirection(), gunPosition = getPosition();

//<<<<<<< HEAD:core/src/com/po/fuck/weapons/Gun.java
        gunPosition.add(new Vector2(geometryData.getWidth() / 2, 0).rotateRad(direction.angleRad()));
        Vector2 realMuzzlePosition = new Vector2(muzzlePosition);
        realMuzzlePosition.x -= geometryData.getWidth();
        realMuzzlePosition.y -= geometryData.getHeight()/2;
        Vector2 finalPosition = GeometryMisc.getPointPositionOnFlippedSprite(gunPosition.cpy(), direction,
                realMuzzlePosition, direction.angleDeg() >= 90 && direction.angleDeg() <= 270);
        Manager.create(shoot(finalPosition, direction));
//=======
//        gunPosition.add(new Vector2(geometryData.getWidth() / 2, 0).rotateRad(direction.angleRad()));
//        Manager.create(shoot(gunPosition, getDirection()));
//>>>>>>> 10-mvc:core/src/com/po/fuck/model/weapons/Gun.java

        cooldownLeft = cooldown;
        return true;
    }

    @Override
    public void update(float delta) {
        cooldownLeft = Math.max(0, cooldownLeft - delta);
    }
}
