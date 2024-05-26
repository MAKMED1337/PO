package com.po.fuck.model;

import static com.po.fuck.model.Constants.GAME_HEIGHT;
import static com.po.fuck.model.Constants.GAME_WIDTH;

import com.badlogic.gdx.math.Vector2;
import com.po.fuck.model.collections.All;
import com.po.fuck.model.collections.DrawableCollection;
import com.po.fuck.model.enemies.BasicEnemy;
import com.po.fuck.model.lifetime.Destructable;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;

public class Core implements Updatable{
    static {
       forceInit(Destructable.class);
       forceInit(All.class);
    }
    
    public static Managed<Player> player;

    public void initialize() {
        player = Manager.create(new Player(new Vector2(GAME_WIDTH / 2, GAME_HEIGHT / 2)));

        Manager.create(new BasicEnemy(new Vector2(100, 100)));
        Manager.create(new BasicEnemy(new Vector2(GAME_WIDTH - 100, GAME_HEIGHT - 100)));
    }

    @Override
    public void update(float delta) {
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
