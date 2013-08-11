/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/11/13
 * Time: 1:23 PM
 *
 * Problem description:
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Solution: reverse the integer and compare (reverse integer already implemented in earlier exercise)
 */
public class PalindromeNumber
{
    public boolean isPalindrome(int x)
    {
        // leetcode onlinejudge test cases output fasle for -2147447412
        // false for all negative numbers?
        // I guess this is more like an implementation choice
        if(x < 0)
        {
            return false;
        }

        long reversed = reverseInteger(x);

        if(x == reversed)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public long reverseInteger(int x)
    {
        long result = 0;
        while(x != 0)
        {
            // in C derived lauguages, negative num % base will yield a negative remainder
            // while laugnages like Python and Ruby will yield a positive one
            int remainder = x % 10;
            result = result * 10 + remainder;
            x = x / 10;
        }

        return result;
    }
}
