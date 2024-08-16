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
        throw new RuntimeException("The method is not completed");
    }

    /**
     * method inserts element into the Binary Search Tree
     * @param element element of type T
     * @param root the root node
     */
    public static <T extends Comparable<? super T>> void insert(T element, Node<T> root) {
        throw new RuntimeException("The method is not completed");
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
