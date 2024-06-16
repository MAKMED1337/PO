package com.po.fuck.model.collections;

import com.po.fuck.model.Entity;

import java.util.List;
import java.util.stream.Collectors;

public final class EntityCollection extends SimpleCollection<Entity> {
    EntityCollection() {
        super(Entity.class);
    }

    public List<Entity> getTeam(int teamTag) {
        return objects.stream().filter(o -> o.getTeamTag() == teamTag).collect(Collectors.toList());
    }

    public List<Entity> getOpponents(int teamTag) {
        return objects.stream().filter(o -> o.getTeamTag() != teamTag).collect(Collectors.toList());
    }
}
