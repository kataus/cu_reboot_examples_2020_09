package ru.sbrf.cu.list;

public class MyLinkedList<T> implements MyList<T>, MyQueue<T> {
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
        // TODO Ошибка если индекс больше размера
        // TODO Если индекс > size/2 - то перебираем от tail
        int currPosition = 0;
        T result = null;
        ListItem<T> item = head;
        // Пошли перебирать элементы пока не дойдем до индекса или же не выйдем за размеры списка
        while ( result == null && currPosition < size ){
            if (index == currPosition){
                result = item.value;
            }
            item = item.next;
            currPosition++;
        }
        return result;
    }

    @Override
    public boolean remove( T item ) {
        // TODO - реализовать.
        return false;
    }

    @Override
    public T poll() {
        //TODO
        return null;
    }

    private class ListItem<T> {
        T value;
        ListItem<T> prev;
        ListItem<T> next;
    }
}