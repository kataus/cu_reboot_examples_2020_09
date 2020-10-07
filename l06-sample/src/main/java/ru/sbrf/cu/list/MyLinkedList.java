package ru.sbrf.cu.list;

public class MyLinkedList<T> implements MyList<T> {
    private ListItem<T> head = null;
    private ListItem<T> tail = null;
    private int size = 0;

    @Override
    public void add( T item ) {
        // Создаем новый элемент
        ListItem<T> internalItem = new ListItem<>();
        internalItem.value = item;
        //Если голова ещё не задана - то её присваиваем новому элементу
        if ( head == null ) {
            head = internalItem;
        }
        // Хвост заменяется на новый
        ListItem<T> tempTail = tail;
        tail = internalItem;
        // Связываем старый хвост и новый хвост между собой
        if ( tempTail != null ) {
            tempTail.next = tail;
        }
        tail.prev = tempTail;
        // Двигаемся по счетчику
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get( int index ) {
        return null;
    }

    @Override
    public boolean remove( T item ) {
        return false;
    }

    private class ListItem<T> {
        T value;
        ListItem<T> prev;
        ListItem<T> next;
    }
}