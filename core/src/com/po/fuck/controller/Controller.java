package com.po.fuck.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.po.fuck.model.Core;
import com.po.fuck.model.lifetime.Managed;
import com.po.fuck.model.lifetime.Manager;

public final class Controller {
    private final Managed<PlayersMouseController> mouseController;
    private final Managed<PlayersKeyboardController> keyboardController;
    private InputMultiplexer multiplexer = new InputMultiplexer();

    public Controller(Core core) {
        mouseController = Manager.create(new PlayersMouseController(core::getPlayer,
                local -> core.getObjectFollower().getPosition().add(local)));

        keyboardController = Manager.create(new PlayersKeyboardController(core::getPlayer));
        multiplexer.addProcessor(keyboardController.get());
        multiplexer.addProcessor(mouseController.get());
        Gdx.input.setInputProcessor(multiplexer);
    }
}
