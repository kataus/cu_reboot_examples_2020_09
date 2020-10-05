package ru.sbrf.cu.figures.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sbrf.cu.figures.FigureNames;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Квадрат должен " )
class SquareTest {

    @DisplayName( " создаваться со стороной" )
    @Test
    public void testCreate(){
        Square square = new Square( 5 );
        assertEquals( 5, (int)square.getLength() );
        assertEquals( FigureNames.SQUARE.getName(), square.getName() );
    }

    @DisplayName( " корректно считать периметр" )
    @Test
    public void testPerimeter(){
        Square square = new Square( 5 );
        assertEquals( 20, (int)square.getPerimeter() );
    }

    @DisplayName( " корректно считать площадь" )
    @Test
    public void testArea(){
        Square square = new Square( 5 );
        assertEquals( 25, (int)square.getArea() );
    }

}