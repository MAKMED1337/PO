package com.po.fuck;

import static com.po.fuck.Constants.DEFAULT_SPEED;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.po.fuck.movement.BasicMovement;

public class Enemy extends Entity {

    protected Player aggriedPlayer = null;
    protected BasicMovement basicMovement;

	Enemy(Sprite sprite) {
		super(sprite);
        this.speed = DEFAULT_SPEED / 20;

        basicMovement = new BasicMovement(this.position, this.speed);
	}

	public <SuperPlayer extends Player> void passPlayerPositions(ArrayList<SuperPlayer> list) {
        // Possibly add some more ifs whether to change player enemy is aggried to
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
