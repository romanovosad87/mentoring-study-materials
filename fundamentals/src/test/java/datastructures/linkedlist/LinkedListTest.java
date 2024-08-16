package datastructures.linkedlist;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void ofMethodShouldCreateLinkedList() {
        LinkedList<Integer> linkedList = LinkedList.of(1, 2, 3, 4, 5);
        var firstElement = linkedList.getFirst();
        var size = linkedList.size();

        Assertions.assertEquals(firstElement, 1);
        Assertions.assertEquals(size, 5);
    }

}