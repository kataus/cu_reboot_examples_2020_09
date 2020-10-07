package ru.sbrf.cu.list;

public interface MyList<T> {
    // Добавить новый элемент в конец списка
    void add(T item);

    // Количество элеметов в списке
    int size();

    // Получить элемент по индексу
    T get(int index);

    // Удалить элемент по совпадению. Если не найден - то false
    boolean remove(T item);
}
