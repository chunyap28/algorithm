package linkedlist;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReorderLinkedListTest {

    @Test
    public void testReverseLinkedList() {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        ReorderLinkedList reorderLinkedList = new ReorderLinkedList();
        head = reorderLinkedList.reverse(head);
        Assert.assertEquals(head.toString(), "5->4->3->2->1->");
    }

    @Test
    public void testReorderLinkedList() {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 2; i <= 9; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        ReorderLinkedList2 reorderLinkedList = new ReorderLinkedList2();
        head = reorderLinkedList.reorder(head);
        Assert.assertEquals(head.toString(), "1->9->2->8->3->7->4->6->5->");
    }

    @Test
    public void testReorderLinkedList_EvenNode() {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 2; i <= 10; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        ReorderLinkedList2 reorderLinkedList = new ReorderLinkedList2();
        head = reorderLinkedList.reorder(head);
        Assert.assertEquals(head.toString(), "1->10->2->9->3->8->4->7->5->6->");
    }
}