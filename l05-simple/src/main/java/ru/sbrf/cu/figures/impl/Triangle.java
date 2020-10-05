package ru.sbrf.cu.figures.impl;

import ru.sbrf.cu.figures.Figure;
import ru.sbrf.cu.figures.FigureNames;

public class Triangle implements Figure {
    private final Integer length1;
    private final Integer length2;
    private final Integer length3;

    public Triangle( Integer length1, Integer length2, Integer length3 ) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
    }

    @Override
    public String getName() {
        return FigureNames.TRIANGLE.getName();
    }

    @Override
    public Integer getPerimeter() {
        return length1 + length2 + length3;
    }

    @Override
    public Integer getArea() {
        return length1 * length2 * length3;
    }
}
