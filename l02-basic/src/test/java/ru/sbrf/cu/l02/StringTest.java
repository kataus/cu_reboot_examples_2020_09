package ru.sbrf.cu.l02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Пробуем операции над строками")
public class StringTest {

    @Test
    @DisplayName("конкатенация")
    public void testConcat(){
        assertEquals("", "Hello " + "World");
    }

    @Test
    @DisplayName("подстроки")
    public void testSubString(){
        assertEquals("", "Hello World".substring(6));
        assertEquals("", "Hello World".substring(0,5));
    }

    @Test
    @DisplayName("индекс")
    public void testIndex(){
        assertEquals("", "Hello World".indexOf("o"));
        assertEquals("", "Hello World".indexOf("O"));
        assertEquals("", "Hello World".lastIndexOf("o"));
        assertEquals("", "Hello World".indexOf("o",6));
    }

    @Test
    @DisplayName("замена")
    public void testReplace(){
        assertEquals("", "Hello. I'm Java. I like you.".replace("l", "L") );
        assertEquals("", "Hello. I'm Java. I like you.".replaceAll("l", "L") );
        assertEquals("", "Hello. I'm Java. I like you.".replaceAll(".", "!") );
    }
}


