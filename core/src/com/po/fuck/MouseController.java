package com.po.fuck;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

import static com.po.fuck.Constants.GAME_HEIGHT;
import static com.po.fuck.Constants.GAME_WIDTH;

public class MouseController extends InputAdapter {
    Player player;

    MouseController(Player player) {
        this.player = player;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        player.weapon.aim(new Vector2((float) (screenX * GAME_WIDTH) / Gdx.graphics.getWidth(), (float) (screenY * GAME_HEIGHT) / Gdx.graphics.getHeight()));
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // ignore position, should be handled as a move event
        player.weapon.attack();
        return true;
    }
}
