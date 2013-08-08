import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Problem Description:
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 */
public class AddTwoNumbers 
{
  public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> a, LinkedList<Integer> b)
	{
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		ListIterator<Integer> itrA = a.listIterator();
		ListIterator<Integer> itrB = b.listIterator();
		
		int carryOver = 0;
		while(itrA.hasNext() && itrB.hasNext())
		{
			int sum = itrA.next() + itrB.next() + carryOver;
			result.add(sum % 10);
			carryOver = sum / 10;
		}
		while(itrA.hasNext())
		{
			int sum = itrA.next() + carryOver;
			result.add(sum % 10);
			carryOver = sum / 10;
		}
		while(itrB.hasNext())
		{
			int sum = itrB.next() + carryOver;
			result.add(sum % 10);
			carryOver = sum / 10;
		}
		
		if(carryOver != 0)
		{
			result.add(carryOver);
		}
		
		return result;
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
        val = x;
        next = null;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		ListNode result = null;
		
		int carryOver = 0;
		ListNode curNode = null;
		while(l1 != null || l2 != null)
		{
			int sum = 0;
			if(l1 != null)
			{
				sum += l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null)
			{
				sum += l2.val;
				l2 = l2.next;
			}
			
			sum += carryOver;

			if(result == null)
			{
				result = new ListNode(sum % 10);
				curNode = result;
			}
			else
			{
				curNode.next = new ListNode(sum % 10);
				curNode = curNode.next;
			}
			
			carryOver = sum / 10;
		}
		
		if(carryOver != 0)
		{
			curNode.next = new ListNode(carryOver);
		}
		
		return result;
	}
}
