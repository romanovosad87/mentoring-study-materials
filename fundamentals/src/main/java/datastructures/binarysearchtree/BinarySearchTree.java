package datastructures.binarysearchtree;

import java.util.function.Consumer;

public class BinarySearchTree {

    public static void main(String[] args) {
        Node<Integer> root = createBinarySearchTree(4, 6, 2, 5, 3, 1, 7);
        inOrderTraversal(root, System.out::println);
    }

    /**
     * method creates the Binary Search Tree and returns the root. To implement this method
     * the {@link #insert} should be used
     * @param elements array of elements of type T
     * @return the root of the tree
     */
    public static <T extends Comparable<? super T>> Node<T> createBinarySearchTree(T... elements) {
        var root = new Node<>(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            insert(elements[i], root);
        }
        return root;
    }

    /**
     * method inserts element into the Binary Search Tree
     * @param element element of type T
     * @param root the root node
     */
    public static <T extends Comparable<? super T>> void insert(T element, Node<T> root) {
        var current = root;
        var newNode = new Node<>(element);
        if (element.compareTo(current.elememt) < 0) {
            if (current.left == null) {
                current.left = newNode;
            } else {
                insert(element, current.left);
            }
        } else if (element.compareTo(current.elememt) > 0) {
            if (current.right == null) {
                current.right = newNode;
            } else {
                insert(element, current.right);
            }
        }
    }

    public static <T> void inOrderTraversal(Node<T> root, Consumer<T> consumer) {
        if (root != null) {
            inOrderTraversal(root.left, consumer);
            consumer.accept(root.elememt);
            inOrderTraversal(root.right, consumer);
        }
    }

    static class Node<T> {
        T elememt;
        Node<T> right;
        Node<T> left;

        public Node(T elememt) {
            this.elememt = elememt;
        }
    }
}
