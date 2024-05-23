package com.po.fuck.updates;

/**
 * Interface for objects that can be updated over time.
 * Implementing classes must provide an implementation for the {@code update}
 * method,
 * which allows them to perform actions based on the elapsed time since the last
 * update.
 */
public interface Updatable {

    /**
     * Update method to be called periodically to update the state of the object.
     *
     * @param delta The time elapsed since the last update, in seconds.
     *              This parameter allows objects to adjust their behavior based on
     *              the
     *              passage of time and ensures smooth animation and interaction.
     */
    void update(float delta);
}
