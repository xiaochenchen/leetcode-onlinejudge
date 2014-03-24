package xcc.leetcode.stack;

import java.util.Stack;

/**
 * Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. The brackets must close in the correct order,
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Created by lightsaber on 3/23/14.
 */
public class ValidParentheses
{
    public boolean isValid(String s) {
        Stack<Character> leftParentheses = new Stack<Character>();
        for(char c : s.toCharArray())
        {
            // if left parenthesis, push into stack, continue to next char
            if(c == '(' || c == '[' || c == '{')
            {
                leftParentheses.push(c);
                continue;
            }

            // if stack empty, return false
            if(leftParentheses.isEmpty())
            {
                return false;
            }

            // check if the top of stack matches with current char
            char topOfStack = leftParentheses.pop();
            if( !((c == ')' && topOfStack == '(')
                    || (c == ']') && topOfStack == '['
                    || (c == '}') && topOfStack == '{') )
            {
                return false;
            }
        }

        // if nothing left in the stack, return true
        if(leftParentheses.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
