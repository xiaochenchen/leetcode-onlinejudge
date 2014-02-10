package xcc.leetcode;

import java.util.Stack;

public class LongestValidParentheses 
{
	public int longestValidParenthesesStack(String s) {
		int maxLen = 0;
		int lastRight = -1;
		
		Stack<Integer> lefts = new Stack<Integer>();
		
		for(int i = 0; i < s.length(); ++i)
		{
			if(s.charAt(i) == '(')
			{
				lefts.push(i);
			}
			else
			{
				if(lefts.isEmpty())
				{
					lastRight = i;
				}
				else
				{
					lefts.pop();
					if(lefts.isEmpty())
					{
						maxLen = Math.max(maxLen, i - lastRight);
					}
					else
					{
						maxLen = Math.max(maxLen, i - lefts.peek());
					}
				}
			}
		}
		
		return maxLen;
	}
    public int longestValidParenthesesDP(String s) {
    	// will implement this when i get time ....
    	return 0;
    }
}
