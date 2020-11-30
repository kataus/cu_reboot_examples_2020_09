package ru.sbrf.cu.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Group implements Unit {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit( Unit unit ) {
        units.add( unit );
    }

    @Override
    public void move() {
        units.forEach( Unit::move );
    }
}
