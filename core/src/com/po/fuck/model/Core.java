package com.po.fuck.model;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.enemies.Spawner;
import com.po.fuck.model.lifetime.Destructable;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.PositionData;

public final class Core implements Updatable {
    private Managed<Player> player;
    private Managed<Coins> coinsCounter;
    private Spawner spawner;
    public Managed<ObjectFollower> objectFollower;

    public static void initialize() {
        Destructable.register();
        All.initialize();
    }

    public Core() {
        player = Manager.create(new Player(new PositionData()));

        coinsCounter = Manager.create(new Coins());
        spawner = new Spawner(coinsCounter.get());
        objectFollower = Manager.create(new ObjectFollower());

        Manager.create(new Room(new Vector2(0, 0), spawner));
        Manager.create(new Room(new Vector2(1, 0), spawner));
    }

    public Player getPlayer() {
        return player.get();
    }

    public ObjectFollower getObjectFollower() {
        return objectFollower.get();
    }

    @Override
    public void update(float delta) {
        if (player.get() == null)
            player = Manager.create(new Player(new PositionData()));

        objectFollower.get().setTargetPosition(player.get().getPosition());

        All.updatableCollection.update(delta);
    }

    public DrawableCollection getDrawableCollection() {
        return All.drawableCollection;
    }
}
