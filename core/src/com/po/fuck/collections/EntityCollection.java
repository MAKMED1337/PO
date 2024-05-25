package com.po.fuck.collections;

import com.po.fuck.Entity;

import java.util.ArrayList;

public class EntityCollection extends SimpleCollection<Entity> {
    public static int totalTeams = 0;
    EntityCollection() {super(Entity.class);}


    ArrayList<Entity> GetTeam (int teamTag) {
        ArrayList<Entity> teammates = new ArrayList<>();
        for (Entity x : objects)
            if (x.teamTag == teamTag)
                teammates.add(x);
        return teammates;
    }
    ArrayList<Entity> GetOpponents (int teamTag) {
        ArrayList<Entity> opponents = new ArrayList<>();
        for (Entity x : objects)
            if (x.teamTag != teamTag)
                opponents.add(x);
        return opponents;
    }

}
