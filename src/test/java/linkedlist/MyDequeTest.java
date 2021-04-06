package linkedlist;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class MyDequeTest {

    public void testDeque_addFrontRemoveFront() {
        Deque<Integer> deque = new MyDeque<>();

        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(3);
        Assert.assertEquals(deque.removeFirst(), Integer.valueOf(3));
        Assert.assertEquals(deque.removeFirst(), Integer.valueOf(6));
        Assert.assertEquals(deque.removeFirst(), Integer.valueOf(5));
        Assert.assertEquals(deque.removeFirst(), null);
    }

    public void testDeque_addFrontRemoveLast() {
        Deque<Integer> deque = new MyDeque<>();

        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(3);
        Assert.assertEquals(deque.removeLast(), Integer.valueOf(5));
        Assert.assertEquals(deque.removeLast(), Integer.valueOf(6));
        Assert.assertEquals(deque.removeLast(), Integer.valueOf(3));
        Assert.assertEquals(deque.removeLast(), null);
    }

    public void testDeque_addBackRemoveBack() {
        Deque<Integer> deque = new MyDeque<>();

        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(3);
        Assert.assertEquals(deque.removeLast(), Integer.valueOf(3));
        Assert.assertEquals(deque.removeLast(), Integer.valueOf(6));
        Assert.assertEquals(deque.removeLast(), Integer.valueOf(5));
        Assert.assertEquals(deque.removeLast(), null);
    }

    public void testDeque_addBackRemoveFront() {
        Deque<Integer> deque = new MyDeque<>();

        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(3);
        Assert.assertEquals(deque.removeFirst(), Integer.valueOf(5));
        Assert.assertEquals(deque.removeFirst(), Integer.valueOf(6));
        Assert.assertEquals(deque.removeFirst(), Integer.valueOf(3));
        Assert.assertEquals(deque.removeFirst(), null);
    }

    public void testDeque_emptyElement() {
        Deque<Integer> deque = new MyDeque<>();

        Assert.assertEquals(deque.removeFirst(), null);
        Assert.assertEquals(deque.removeLast(), null);
    }
}