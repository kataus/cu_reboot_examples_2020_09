package ru.sbrf.cu.figures.impl;

import ru.sbrf.cu.figures.Figure;
import ru.sbrf.cu.figures.FigureNames;

public class Rectangle implements Figure {
    private final Integer length;
    private final Integer width;

    public Rectangle( Integer length, Integer width ) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String getName() {
        return FigureNames.RECTANGLE.getName();
    }

    @Override
    public Integer getPerimeter() {
        return length + width;
    }

    @Override
    public Integer getArea() {
        return length * width;
    }
}
