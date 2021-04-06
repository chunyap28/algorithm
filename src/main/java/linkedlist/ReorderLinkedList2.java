package linkedlist;

public class ReorderLinkedList2 {

    //reorder l0, ln, l1, ln-1, l2, ...
    public ListNode reorder(ListNode head) {

        //cut into half
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;


        //reverse l2
        ListNode newHead = l2;
        ListNode newTail = l2;
        while(newTail.next != null) {
            ListNode nextNode = newTail.next;
            newTail.next = nextNode.next;
            nextNode.next = newHead;
            newHead = nextNode;
        }
        l2 = newHead;

        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;
        while(l1 != null && l2 != null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;

            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }

        return dummyHead.next;
    }
}
