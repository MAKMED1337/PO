package com.po.fuck.collections;

import com.po.fuck.Entity;

import java.util.ArrayList;

public class EntityCollection extends SimpleCollection<Entity> {
    public static int totalTeams = 2; ///creeps and player already added
    EntityCollection() {super(Entity.class);}


    public ArrayList<Entity> getTeam (int teamTag) {
        ArrayList<Entity> teammates = new ArrayList<>();
        for (Entity x : objects)
            if (x.teamTag == teamTag)
                teammates.add(x);
        return teammates;
    }
    public ArrayList<Entity> getOpponents (int teamTag) {
        ArrayList<Entity> opponents = new ArrayList<>();
        for (Entity x : objects)
            if (x.teamTag != teamTag)
                opponents.add(x);
        return opponents;
    }

}
