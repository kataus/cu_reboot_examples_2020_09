package ru.sbrf.cu.figures.impl;

import ru.sbrf.cu.figures.Figure;
import ru.sbrf.cu.figures.FigureNames;

public class RightTriangle implements Figure {
    private final Integer сathetus1;
    private final Integer cathetus2;


    public RightTriangle( Integer сathetus1, Integer cathetus2 ) {
        this.сathetus1 = сathetus1;
        this.cathetus2 = cathetus2;
    }

    @Override
    public String getName() {
        return FigureNames.RIGHT_TRIANGLE.getName();
    }

    @Override
    public Integer getPerimeter() {
        return сathetus1 + cathetus2;
    }

    @Override
    public Integer getArea() {
        return сathetus1 * cathetus2 / 2;
    }
}
