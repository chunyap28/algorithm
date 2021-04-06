package linkedlist;

public class ReorderLinkedList {

    private ListNode left;
    private boolean stop;

    //reorder l0, ln, l1, ln-1, l2, ...
    public ListNode reorder(ListNode head) {
        left = head;
        return recursive(head);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;

            current = next;
        }

        return prev;
    }

    private ListNode recursive(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tail = recursive(head.next);


        if( !stop ) {
            System.out.printf("Left: %d, Right: %d\n", left.val, head.val);
            ListNode temp = left.next;
            if (tail != null) {
                tail.next = left;
            }
            tail = left;

            if (head != left) {
                tail.next = head;
                tail = head;
            }

            left = temp;
        }

        if( !stop && (left == head || head.next == left) ) {
            System.out.printf("Stopped at Left: %d, Right: %d, Right.next: %d\n", left.val, head.val, head.next.val);
            tail.next = null;
            stop = true;
        }

        return head;
    }
}
