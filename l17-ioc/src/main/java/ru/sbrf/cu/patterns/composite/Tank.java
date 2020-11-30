package ru.sbrf.cu.patterns.composite;

public class Tank implements Unit {
    @Override
    public void move() {
        System.out.println( "Tank is moving" );
    }
}
