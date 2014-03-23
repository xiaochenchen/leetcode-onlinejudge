package xcc.leetcode.implementation;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *  Given linked list: 1->2->3->4->5, and n = 2.
 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Solution:
 *  Start with a A pointer from the head, once A is pointing to Nth node
 *  introduce pointer start from head, move A and B together until A gets to the end
 *  And now remove the node after B.
 *
 * Created by XCC on 3/23/14.
 */
public class RemoveNthNodeFromEndOfList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        // introduce dummy head to ignore the null list input case
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        // A pointer
        ListNode aNode = dummyHead;
        // index of the A pointer
        int aIndex = 0;

        // advance A pointer to N node away from head
        while(aIndex < n && aNode.next != null)
        {
            aNode = aNode.next;
            aIndex++;
        }

        // B pointer
        ListNode bNode = dummyHead;

        // advance A and B at the same time, until A gets the the end
        while(aNode.next != null)
        {
            aNode = aNode.next;
            bNode = bNode.next;
        }

        // remove the Node after B, which is Nth away from the end
        // only when bNode.next is not NULL
        if(bNode.next != null)
        {
            bNode.next = bNode.next.next;
        }

        return dummyHead.next;
    }

}
