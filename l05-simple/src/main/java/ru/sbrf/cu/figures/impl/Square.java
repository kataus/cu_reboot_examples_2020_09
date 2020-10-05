package ru.sbrf.cu.figures.impl;

import ru.sbrf.cu.figures.Figure;
import ru.sbrf.cu.figures.FigureNames;

public class Square implements Figure {
    private final Integer length;

    public Square( Integer length ) {
        this.length = length;
    }

    @Override
    public String getName() {
        return FigureNames.SQUARE.getName();
    }

    @Override
    public Integer getPerimeter() {
        return length * 4;
    }

    @Override
    public Integer getArea() {
        return (int) Math.pow( length, 2 );
    }

    public Integer getLength() {
        return length;
    }
}
