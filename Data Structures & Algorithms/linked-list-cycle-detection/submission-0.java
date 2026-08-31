/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        // use slow, fast pointer
        ListNode slow, fast;
        slow = head;fast=head;

        while(slow != null && fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null)fast = fast.next;

            if(slow != null && fast != null && slow == fast)return true;
        }

        return false;
    }
}
