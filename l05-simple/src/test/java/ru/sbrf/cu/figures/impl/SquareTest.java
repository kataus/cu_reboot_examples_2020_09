package ru.sbrf.cu.figures.impl;

import org.junit.jupiter.api.Test;
import ru.sbrf.cu.figures.FigureNames;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {

    @Test
    public void testCreate() {
        Square square = new Square( 5 );
        assertEquals( 5, (int) square.getLength() );
        assertEquals( FigureNames.SQUARE.getName(), square.getName() );
    }

    @Test
    public void testPerimeter() {
        Square square = new Square( 5 );
        assertEquals( 20, (int) square.getPerimeter() );
    }

    @Test
    public void testArea() {
        Square square = new Square( 5 );
        assertEquals( 25, (int) square.getArea() );
    }

//    @Test
//    public void createNegative(){
//        Square square = new Square( -5 );
//    }

}