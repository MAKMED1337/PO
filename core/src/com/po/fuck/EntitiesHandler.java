package com.po.fuck;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.po.fuck.updates.Updatable;

public class EntitiesHandler implements Updatable {

    {
        FUCK.initializer.init(this);
    }

    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();

    // Issue: if we are going to introduce PvP mode this would cause some refactoring in this part of code

    float deltaLastEnemyCreated = 0;

    public void createEnemy(){
        deltaLastEnemyCreated = 0;
        Enemy enemy = new Enemy(new Sprite(new Texture("player2.png")));
        enemies.add(enemy);
        return;
    }

    public <E extends Entity> void addEntity(E entity){
        if(entity instanceof Player)
            players.add((Player) entity);
        if(entity instanceof Enemy)
            enemies.add((Enemy) entity);
    }

    public <E extends Entity> void removeEntity(E entity){
        if(entity instanceof Player)
            players.remove((Player) entity);
        if(entity instanceof Enemy)
            enemies.remove((Enemy) entity);
    }

    private void notifyEnemiesPlayersPositions(){
        for(Enemy enemy : enemies){
            enemy.passPlayerPositions(players);
        }
        return;
    }

    private void updateEnemiesPositions(float delta){
        for(Enemy enemy : enemies){
            enemy.updatePosition(delta);
        }
        return;
    }

	@Override
	public void update(float delta) {
        deltaLastEnemyCreated += delta;
        notifyEnemiesPlayersPositions();
        updateEnemiesPositions(delta);
        if(deltaLastEnemyCreated > Constants.SPAWN_RATE)
            createEnemy();
	}
}
