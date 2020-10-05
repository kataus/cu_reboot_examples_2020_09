package ru.sbrf.cu.figures;

public enum FigureNames {
    SQUARE("Квадрат"),
    TRIANGLE("Треугольник"),
    RIGHT_TRIANGLE("Прямоугольный треугольник"),
    RECTANGLE("Прямоугольник")
    ;

    private String name;

    FigureNames( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
