package com.po.fuck;

import static com.po.fuck.Constants.DEFAULT_SPEED;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.movement.BasicMovement;

/**
 * Class representing an enemy entity in the game.
 * Inherits from the Entity class and adds functionality specific to enemies.
 */
public class Enemy extends Entity {

    // The player the enemy is currently targeting/aggressed towards
    protected Player aggriedPlayer = null;
    protected BasicMovement basicMovement;

    /**
     * Constructs an Enemy object with the given sprite.
     * Initializes default speed and sets up basic movement behavior.
     * 
     * @param sprite The sprite representing the visual appearance of the enemy.
     */
	Enemy(Sprite sprite) {
		super(sprite);
        this.speed = DEFAULT_SPEED / 20;

        basicMovement = new BasicMovement(this.position, this.speed);
	}

    /**
     * Updates the target player of the enemy based on the positions of other players.
     * Sets the movement direction towards the closest player.
     * 
     * @param list List of player entities whose positions are considered for targeting.
     */

	public <SuperPlayer extends Player> void updateAggriedPlayer(ArrayList<SuperPlayer> list) {
        // Possibly add some more logic whether to change player enemy is aggried to
        this.aggriedPlayer = null;
        for(Player player : list){
            if(!player.isAlive()) continue;
            if(this.aggriedPlayer == null || 
                GeometryMisc.distance(this,player) < GeometryMisc.distance(this,this.aggriedPlayer))
                this.aggriedPlayer = player;
        }
        if(this.aggriedPlayer == null)
            this.basicMovement.setDirection(new Vector2());
        else
            this.basicMovement.setDirection(GeometryMisc.direction(this, this.aggriedPlayer));
        return;
	}

    public void updatePosition(float delta){
        basicMovement.update(delta);
    }

    public void setPosition(Vector2 position){
        this.position.set(position);
    }
    
}
