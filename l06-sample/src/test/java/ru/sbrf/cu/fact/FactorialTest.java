//package ru.sbrf.cu.fact;
//
//import com.sun.javaws.exceptions.InvalidArgumentException;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@DisplayName("Проверяем факториал")
//public class FactorialTest {
//    Factorial factorial = new Factorial();
//    // 0, 1, -5, 10, слишком большой
//
//    @DisplayName("от 0 равен 1")
//    @Test
//    public void testZero() {
//        assertEquals( 1, factorial.calc( 0 ) );
//    }
//
//    @DisplayName("от 1 равен 1")
//    @Test
//    public void testOne() {
//        assertEquals( 1, factorial.calc( 1 ) );
//    }
//
//    @DisplayName("от 5 равен 120")
//    @Test
//    public void testFive() {
//        assertEquals( 120, factorial.calc( 5 ) );
//    }
//
//    @DisplayName("ошибка если отрицательное значение")
//    @Test
//    public void testNegative() {
//        assertThrows( FactorialNegativeException.class, () ->
//                factorial.calc( -5 )
//        );
//    }
//
//    @DisplayName("ошибка если результат не влезает в Integer")
//    @Test
//    public void testTooBig() {
//        assertThrows( FactorialException.class, () ->
//                factorial.calc( 90 )
//        );
//    }
//}
