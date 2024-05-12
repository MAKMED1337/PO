package com.po.fuck.weapons;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.FUCK;
import com.po.fuck.Player;
import com.po.fuck.updates.Drawable;

public abstract class Weapon implements Drawable {
    protected final Player owner;

    {
        FUCK.initializer.init(this);
    }

    Weapon(Player owner) {
        this.owner = owner;
    }

    public abstract void aim(Vector2 position);

    public abstract boolean attack();
}
