package day12_tree;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {
    private int nodeCount = 0;
    private Node root = null;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    @Override
    public boolean add(T elem) {
        if (contains(elem)) return false;
        root = add(root, elem);
        nodeCount++;
        return true;
    }

    @Override
    public boolean remove(T elem) {
        if (!contains(elem)) return false;
        root = remove(root, elem);
        nodeCount--;
        return false;
    }

    @Override
    public Iterator<T> traverse(TreeTaverseType type) {
        return null;
    }

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contains(Node node, T elem) {
        if (node == null) return false;
        int result = elem.compareTo((T) node.getData());
        if (result < 0) {
            return contains(node.getLeft(), elem);
        } else if (result > 0) {
            return contains(node.getRight(), elem);
        } else return true;
    }

    private Node add(Node node, T elem) {
        if (node == null) {
            node = new Node<>(elem, null, null);
        } else {
            if (elem.compareTo((T) node.getData()) > 0) {
                node.setRight(add(node.getRight(), elem));
            } else {
                node.setLeft(add(node.getLeft(), elem));
            }
        }
        return node;
    }

    private Node remove(Node node, T elem) {
        int result = elem.compareTo((T) node.getData());
        if (result > 0) {
            node.setRight(remove(node.getRight(), elem));
        } else if (result < 0) {
            node.setLeft(remove(node.getLeft(), elem));
        } else {
            if (node.getLeft() == null) {
                Node rightNode = node.getRight();
                node.setData(null);
                node = null;
                return rightNode;
            } else if (node.getRight() == null) {
                Node leftNode = node.getLeft();
                node.setData(null);
                node = null;
                return leftNode;
            } else {
                T temp = minRight(node);
                node.setData(temp);
                node.setRight(remove(node.getRight(), temp));
            }
        }
        return node;
    }

    private T minRight(Node node) {
        while (node.getLeft() != null) node = node.getLeft();
        return (T) node.getData();
    }
}
