package reflection.generics;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public static<T> LinkedList<T> create(T[] array) {
        LinkedList<T> list = new LinkedList<>();
        for (var value : array) {
            list.add(value);
        }
        return list;
    }


    public void add(T value) {
        var newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            var current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }


    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
