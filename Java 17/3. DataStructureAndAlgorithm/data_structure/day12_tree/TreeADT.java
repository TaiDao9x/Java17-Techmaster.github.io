package day12_tree;

import java.util.Comparator;
import java.util.Iterator;

public interface TreeADT<T> extends Comparator<T> {
    boolean isEmpty();

    int size();

    int height();

    boolean contains(T elem);

    boolean add(T elem);

    boolean remove(T elem);

    Iterator<T> traverse(TreeTaverseType type);
}
