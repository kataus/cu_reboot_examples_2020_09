package ru.sbrf.cu.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Реализация MyList должна" )
class MyListTest {
    MyList<Integer> list;

    @BeforeEach
    public void beforeAll(){
        list = new MyLinkedList<>(); //TODO подставить свою реализацию
        list.add( 1 );
        list.add( 2 );
        list.add( 10 );
    }

    @DisplayName( "добавлять элементы и корректно давать размер" )
    @Test
    public void testAdd(){
        assertEquals( 3, list.size() );
    }

    @DisplayName( "находить элемент по индексу" )
    @Test
    public void testGet(){
        assertEquals( Integer.valueOf( 2 ), list.get( 1 ) );
    }

    @DisplayName( "находить удалять по элемент по совпадению" )
    @Test
    public void testRemoveFirst(){
        list.add( 2 );
        boolean result = list.remove( 2 );
        assertTrue( result );
        assertEquals( Integer.valueOf( 2 ), list.get( 10 ) );
        assertEquals( 3, list.size() );
    }

    @DisplayName( "возвращать false если удаление по элементу не удалось" )
    @Test
    public void testRemoveFalse(){
        boolean result = list.remove( 3 );
        assertFalse( result );
        assertEquals( 3, list.size() );
    }
}