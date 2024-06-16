package com.po.fuck.model.collections;

import java.util.ArrayList;

import com.po.fuck.model.drawables.Drawable;

public class DrawableCollection extends SimpleCollection<Drawable> {
    private final ArrayList<Drawable> objects = new ArrayList<Drawable>();

    DrawableCollection() {
        super(Drawable.class);
    }
}
