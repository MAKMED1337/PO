package com.po.fuck.model;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.AssetsManagement.AssetsTextureLoader;
import com.po.fuck.AssetsManagement.AssetsDataLoader;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.lifetime.Destructable;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.model.position.PositionData;

public class Core implements Updatable {

    static { // TODO: remove
        forceInit(Destructable.class);
        forceInit(All.class);
    }

    public static Managed<Player> player;
    public static Managed<Coins> coinsCounter;
    public static Managed<ObjectFollower> objectFollower;

    public static void initialize() {
        AssetsTextureLoader.preloadTextures();
        AssetsDataLoader.loadAssets();

        objectFollower = Manager.create(new ObjectFollower());
        player = Manager.create(new Player(new PositionData(new Vector2(), 0)));
        coinsCounter = Manager.create(new Coins());

        Manager.create(new Room(new Vector2(0, 0)));
        Manager.create(new Room(new Vector2(1, 0)));
        // Creating some game borders to destroy the bullets that went off the map.
        // We can not use here VERTICAL/HORIZONTAL, because if something went off the
        // map, then we want to catch with a thick wall, because it can be laggy or
        // something else.
    }

    @Override
    public void update(float delta) {
        if (player.get() == null)
                player = Manager.create(new Player(new PositionData(new Vector2(), 0)));

        objectFollower.get().setTargetPosition(player.get().getPosition());

        All.updatableCollection.update(delta);
    }

    public DrawableCollection getDrawableCollection(){
        return All.drawableCollection;
    }

    // https://stackoverflow.com/questions/3560103/how-to-force-a-class-to-be-initialised
    public static <T> Class<T> forceInit(Class<T> klass) {
        try {
            Class.forName(klass.getName(), true, klass.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);  // Can't happen
        }
        return klass;
    }
}
