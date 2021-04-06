package linkedlist;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public String toString() {
        ListNode node = this;
        String output = "";
        Set<ListNode> visited = new HashSet<>();
        while( node != null ) {
            output += node.val + "->";
            if( visited.contains(node) ) {
                output += "cycled";
                break;
            }

            visited.add(node);
            node = node.next;
        }
        return output;
    }
}
