package com.po.fuck;

import static com.po.fuck.Constants.BACKGROUND_LAYER;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.lifetime.Managed;
import com.po.fuck.lifetime.Manager;
import com.po.fuck.updates.Drawable;

public final class Room implements Drawable {
    public Vector2 tilling_position;
    protected Sprite sprite = new Sprite(new Texture("island2.png"));

    @SuppressWarnings("unchecked")
    protected Managed<InvisibleWall> walls[] = new Managed[4];

    Room(Vector2 tilling_position) {
        this.tilling_position = tilling_position;

        float h = sprite.getHeight(), w = sprite.getWidth();
        walls[0] = Manager.create(
                new InvisibleWall(getPosition().sub(0, h / 2), InvisibleWall.Type.HORIZONTAL, w));
        walls[2] = Manager.create(
                new InvisibleWall(getPosition().add(0, h / 2), InvisibleWall.Type.HORIZONTAL, w));

        walls[1] = Manager.create(
                new InvisibleWall(getPosition().add(w / 2, 0), InvisibleWall.Type.VERTICAL, h));
        walls[3] = Manager.create(
                new InvisibleWall(getPosition().sub(w / 2, 0), InvisibleWall.Type.VERTICAL, h));

    }

    @Override
    public int get_z() {
        return BACKGROUND_LAYER;
    }

    protected Vector2 getPosition() {
        return new Vector2(sprite.getWidth() * tilling_position.x, sprite.getHeight() * tilling_position.y);
    }

    void clear() {
        for(Managed<InvisibleWall> wall : walls)
            wall.destroy();
    }

    @Override
    public void draw(CenterDrawer drawer) {
        drawer.draw(sprite, getPosition());
    }
}
