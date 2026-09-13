package p004;

public class Solution {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (slow.val == fast.val) {
                // Skip the duplicate node
                fast = fast.next;
                slow.next = fast;
            } else {
                // Move both pointers forward
                slow = slow.next;
                fast = fast.next;
            }
        }

        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        /*
         * Input: 1 -> 1 -> 2 -> 3 -> 3
         * Output: 1 -> 2 -> 3
         */

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.print("Original List: ");
        printList(head);

        head = deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(head);
    }
}