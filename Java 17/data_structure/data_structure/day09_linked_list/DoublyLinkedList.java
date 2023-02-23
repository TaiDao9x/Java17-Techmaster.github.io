package day09_linked_list;

public interface DoublyLinkedList<T> extends Iterable<T> {

    // O(n)
    void clear();

    // Constant
    int size();

    // Constant
    boolean isEmpty();

    // O(1)
    void add(T element);

    // O(1)
    void addFirst(T element);

    // O(1)
    void addLast(T element);

    // O(1)
    T peakFirst();

    // O(1)
    T peakLast();

    // O(1)
    T removeLast();

    // O(1)
    T removeFirst();

    // O(1)
    T remove(Node<T> node);

    boolean remove(Object object);

    T removeAt(int index);

    int indexOf(Object object);

    boolean contain(Object object);

}
