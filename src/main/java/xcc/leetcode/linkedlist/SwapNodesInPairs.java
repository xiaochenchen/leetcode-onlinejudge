package xcc.leetcode.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 *      For example,
 *      Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 *
 * Created by lightsaber on 3/26/14.
 */
public class SwapNodesInPairs
{
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head)
    {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode curr = head;

        while(curr != null && curr.next != null)
        {
            ListNode temp = curr.next.next;
            curr.next.next = curr;
            pre.next = curr.next;
            curr.next = temp;

            pre = curr;
            curr = curr.next;
        }

        return dummyHead.next;
    }
}
