package xcc.leetcode.linkedlist;

import java.util.ArrayList;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Created by lightsaber on 3/23/14.
 */
public class MergeKSortedList
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

    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        if(lists == null || lists.size() == 0)
        {
            return null;
        }

        int listSize = lists.size();

        while(listSize > 1)
        {
            // merge two lists at a time, set into lists from the beginning
            for(int i = 0; i < listSize / 2; ++i)
            {
                ListNode listA = lists.get(2 * i);
                ListNode listB = lists.get(2 * i + 1);
                lists.set(i, mergeTwoLists(listA, listB));
            }

            // if there is one list left at last
            if(listSize % 2 != 0)
            {
                // pay attention to the index, max index = size - 1
                lists.set(listSize / 2, lists.get(listSize - 1));
            }

            // calculate list size for next iteration
            listSize = (listSize + 1) / 2;
        }

        return lists.get(0);
    }

    /**
     * merge two sorted linked list in place
     * @param listA
     * @param listB
     * @return
     */
    public ListNode mergeTwoLists(ListNode listA, ListNode listB)
    {
        // add dummy head to keep track of the start of the list
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode curTail = dummyHead;

        while(true)
        {
            // stop point of the loop
            // if we reach the end of either list
            if(listA == null)
            {
                curTail.next = listB;
                break;
            }
            else if(listB == null)
            {
                curTail.next = listA;
                break;
            }

            if(listA.val < listB.val)
            {
                curTail.next = listA;
                listA = listA.next;
            }
            else
            {
                curTail.next = listB;
                listB = listB.next;
            }

            curTail = curTail.next;
        }

        // return the node right after dummyHead
        return dummyHead.next;
    }
}
