package com.po.fuck.model.enemies;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

import com.po.fuck.model.Coins;
import com.po.fuck.model.Entity;
import com.po.fuck.model.lifetime.Manager;

/**
 * Provides a spawn method used to handle the lifetime of the entity.
 */
public class Spawner {
    private Coins counter;

    public Spawner(Coins counter) {
        this.counter = counter;
    }

    public void spawn(Entity entity) {
        Manager.create(entity);

        entity.onDeath(new Flow.Subscriber<Entity>() {
            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable arg0) {
            }

            @Override
            public void onNext(Entity entity) {
                counter.addCoins(entity.getReward());
            }

            @Override
            public void onSubscribe(Subscription subscription) {
                // There should occur only 1 death, so we are requesting only 1 event.
                subscription.request(1);
            }

        });
    }
}
