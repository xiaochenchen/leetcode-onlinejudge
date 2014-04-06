package xcc.leetcode.linkedlist;

import java.util.List;

/**
 * Given a list, rotate the list to the right by k places,
 * where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * Created by lightsaber on 4/6/14.
 */
public class RotateList
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

    public ListNode rotateRight(ListNode head, int n)
    {
        if(head == null) return null;

        ListNode curr = head;
        ListNode tail = null;
        int len = 0;
        while(curr != null)
        {
            if(curr.next == null) tail = curr;
            curr = curr.next;
            len++;
        }

        tail.next = head;

        int countFromBegin = len - n % len;

        curr = head;
        for(int i = 1; i < countFromBegin; ++i)
        {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }

}
