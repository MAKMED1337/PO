package com.po.fuck.model;

import static com.po.fuck.model.Constants.GAME_BORDER;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.lifetime.Destructable;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;
import com.po.fuck.view.classdrawers.factories.AnimatedBulletDrawerFactory;
import com.po.fuck.view.classdrawers.factories.BulletDrawerFactory;
import com.po.fuck.view.classdrawers.factories.CoinDrawerFactory;
import com.po.fuck.view.classdrawers.factories.EntityDrawerFactory;
import com.po.fuck.view.classdrawers.factories.GameObjectDrawerFactory;
import com.po.fuck.view.classdrawers.factories.HandedWeaponDrawerFactory;
import com.po.fuck.view.classdrawers.factories.RoomDrawerFactory;

public class Core implements Updatable{
    static {
        forceInit(Destructable.class);
        forceInit(All.class);
        forceInit(AnimatedBulletDrawerFactory.class);
        forceInit(BulletDrawerFactory.class);
        forceInit(EntityDrawerFactory.class);
        forceInit(GameObjectDrawerFactory.class);
        forceInit(HandedWeaponDrawerFactory.class);
        forceInit(RoomDrawerFactory.class);
        forceInit(CoinDrawerFactory.class);
    }
    
    public static Managed<Player> player;
    public static Managed<Coins> coinsCounter;
    public static Managed<Camera> camera;

    public static void initialize() {
        camera = Manager.create(new Camera());
        player = Manager.create(new Player(new Vector2()));
        coinsCounter = Manager.create(new Coins());

        Manager.create(new Room(new Vector2(0, 0)));
        Manager.create(new Room(new Vector2(1, 0)));

        // Creating some game borders to destroy the bullets that went off the map.
        // We can not use here VERTICAL/HORIZONTAL, because if something went off the
        // map, then we want to catch with a thick wall, because it can be laggy or
        // something else.
        final int HUGE = 1000, HUGE2 = 2 * HUGE, SIZE = GAME_BORDER + HUGE2;
        Manager.create(new InvisibleWall(new Vector2(-GAME_BORDER - HUGE, 0), new Vector2(HUGE2, SIZE)));
        Manager.create(new InvisibleWall(new Vector2(-GAME_BORDER + HUGE, 0), new Vector2(HUGE2, SIZE)));

        Manager.create(new InvisibleWall(new Vector2(0, -GAME_BORDER - HUGE), new Vector2(SIZE, HUGE2)));
        Manager.create(new InvisibleWall(new Vector2(0, -GAME_BORDER + HUGE), new Vector2(SIZE, HUGE2)));
    }

    @Override
    public void update(float delta) {
        if (player.get() == null)
            player = Manager.create(new Player(new Vector2()));

        camera.get().setPosition(player.get().getPosition());

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
