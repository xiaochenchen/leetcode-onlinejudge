import java.util.Arrays;

/**
 * Problem Description:
 *
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 */

public class LongestPalindromicSubstring
{
    /**
     * Brute force method
     * for all posible substrings (1 + 2 + 3 + ... + n) => O(n^2)
     * check if the string is palindromic => O(n)
     * start from the longest substring, stop if palindromic is found
     * @param s
     * @return
     */
    public String longestPalindromeBruteForce(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function		
        for(int i = s.length(); i > 0; --i)
        {
            for(int j = 0; j < s.length() - i + 1; ++j)
            {
                String subString = s.substring(j, j + i);
                if(isPalindromic(subString))
                {
                    return subString;
                }
            }
        }

        return null;
    }

    public boolean isPalindromic(String s)
    {
        if(s == null)
            return false;

        boolean result = true;
        int leftIndex = 0, rightIndex = s.length() - 1;
        while(rightIndex > leftIndex)
        {
            if(s.charAt(leftIndex) != s.charAt(rightIndex))
            {
                result = false;
                break;
            }
            else
            {
                leftIndex += 1;
                rightIndex -= 1;
            }
        }

        return result;
    }

    /**
     * solve the same problem with dynamic programming,
     * assuming the length of the string is less than 1000 for simplicity
     *
     * Define P[ i, j ] ← true iff the substring Si … Sj is a palindrome, otherwise false.
     * P[ i, j ] ← ( P[ i+1, j-1 ] and Si == Sj )
     *
     * base cases (1 and 2 letters):
     * P[ i, i ] ← true
     * P[ i, i+1 ] ← ( Si == Si+1 )
     *
     * @param s
     * @return
     */
    public String longestPalindromeDP(String s)
    {
        if(s == null)
        {
            return "Input String is NULL!";
        }

        if(s.length() > 1000)
        {
            return "Input String size is too large(> 1000)!";
        }

        boolean[][] P = new boolean[1000][1000];
        int startIndex = 0, maxLen = 0;

        for(int i = 0; i < s.length(); ++i)
        {
            P[i][i] = true;
        }

        maxLen = 1;

        for(int i = 0; i < s.length() - 1; ++i)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                P[i][i+1] = true;
                startIndex = i;
                maxLen = 2;
            }
        }

        for(int len = 3; len <= s.length(); ++len)
        {
            for(int i = 0; i <= s.length() - len; ++i)
            {
                if(s.charAt(i) == s.charAt(i+len-1) && P[i+1][i+len-2])
                {
                    P[i][i+len-1] = true;
                    startIndex = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }
}
