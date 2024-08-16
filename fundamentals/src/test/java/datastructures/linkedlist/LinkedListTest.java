package datastructures.linkedlist;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void ofMethodShouldCreateLinkedList() {
        // given
        LinkedList<Integer> linkedList = LinkedList.of(1, 2, 3, 4, 5);

        // when
        var size = linkedList.size();

        // then
        Assertions.assertEquals(size, 5);
    }

}