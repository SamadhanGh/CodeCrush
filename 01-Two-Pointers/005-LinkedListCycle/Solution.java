package p005;

public class Solution {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Floyd's Cycle Detection Algorithm
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Both pointers meet inside the cycle
            if (slow == fast) {
                return true;
            }
        }

        // Fast pointer reached the end
        return false;
    }

    public static void main(String[] args) {

        // Example 1: Contains a cycle
        // 3 -> 2 -> 0 -> -4
        //      ^         |
        //      |_________|
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);

        // Creating a cycle: -4 points back to 2
        head1.next.next.next.next = head1.next;

        System.out.println("Example 1: " + hasCycle(head1));


        // Example 2: No cycle
        // 1 -> 2 -> null
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("Example 2: " + hasCycle(head2));


        // Example 3: Single node, no cycle
        // 1 -> null
        ListNode head3 = new ListNode(1);

        System.out.println("Example 3: " + hasCycle(head3));


        // Example 4: Empty list
        ListNode head4 = null;

        System.out.println("Example 4: " + hasCycle(head4));
    }
}