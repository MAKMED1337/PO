package com.po.fuck.collections;

import com.po.fuck.Entity;

import java.util.ArrayList;

public class EntityCollection extends SimpleCollection<Entity> {
    EntityCollection() {super(Entity.class);}

    public ArrayList<Entity> getTeam (int teamTag) {
        ArrayList<Entity> teammates = new ArrayList<>();
        for (Entity x : objects)
            if (x.getTeamTag() == teamTag)
                teammates.add(x);
        return teammates;
    }

    public ArrayList<Entity> getOpponents (int teamTag) {
        ArrayList<Entity> opponents = new ArrayList<>();
        for (Entity x : objects)
            if (x.getTeamTag() != teamTag)
                opponents.add(x);
        return opponents;
    }
}
