package xcc.leetcode;

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
     * Define P[ i, j ] ??? true if the substring Si ??? Sj is a palindrome, otherwise false.
     * P[ i, j ] ??? ( P[ i+1, j-1 ] and Si == Sj )
     *
     * base cases (1 and 2 letters):
     * P[ i, i ] ??? true
     * P[ i, i+1 ] ??? ( Si == Si+1 )
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
    
    /**
     * A palindrome mirrors around its center.
	 * Therefore a palindrome can be expanded from its center.
	 * 
	 * The center could be a letter or between two letters.
	 * There are in total 2N - 1 such centers.	=> O(N)
	 * 
	 * Expand from each center and find the longest panlindrome.	=> O(n)
	 * 
	 * O(n^2)
	 *  
	 * @param s
	 * @return
	 */
	public String longestPalindromeExpandAroundCenter(String s)
	{
        int startIndex = 0, maxLen = 0;
        
        for(int i = 0; i < s.length(); ++i)
        {
            // let i be the center of the palindrome
            int l = i, r = i;
            while(l > 0 && r < s.length() - 1)
            {
                if(s.charAt(l-1) != s.charAt(r+1))
                {
                    break;
                }
                else
                {
                    --l;
                    ++r;
                }
            }
            int curLen = r - l + 1;
            if(curLen > maxLen)
            {
                startIndex = l;
                maxLen = curLen;
            }
            
            // let i+0.5 be the center of the palindrome
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length())
            {
                if(s.charAt(l) == s.charAt(r))
                {
                    curLen = r - l + 1;
                    if(curLen > maxLen)
                    {
                        startIndex = l;
                        maxLen = curLen;
                    }
                }
                else
                {
                   break; 
                }
                l -= 1;
                r += 1;
            }
        }
        
        return s.substring(startIndex, startIndex + maxLen);
	}

    /**
     * http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
     *
     * @param s
     * @return
     */
    public String longestPalindromeManacher(String s)
    {
        String T = preProcessing(s);

        if(T == null || T.trim().isEmpty())
        {
            return T;
        }

        int[] P = new int[T.length()];

        int C = 0, R = 0;

        for(int i = 0; i < T.length(); ++i)
        {
            int i_mirror = C - (i - C);

            if(R > i)
            {
                if(P[i_mirror] <= R - i)
                {
                    P[i] = P[i_mirror];
                }else
                {
                    P[i] = R - i;
                }
            }
            else
            {
                P[i] = 0;
            }

            // attemp to expand palindrome centered at i
            while( i-P[i] > 0 && i+P[i] < T.length()-1 && T.charAt(i+P[i]+1) == T.charAt(i-P[i]-1))
            {
                P[i]++;
            }

            // if palindrome centered at i expand past R
            // adjust center based on expanded palindrome
            if(i + P[i] > R)
            {
                C = i;
                R = i + P[i];
            }
        }

        int maxLen = 0, centerIndex = 0;
        for(int i = 0; i < P.length; ++i)
        {
            if(P[i] > maxLen)
            {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        return s.substring((centerIndex - maxLen)/2, (centerIndex + maxLen)/2);
    }

    private String preProcessing(String s)
    {
        if(s == null || s.trim().isEmpty())
        {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray())
        {
            sb.append("#").append(c);
        }
        sb.append("#");

        return sb.toString();
    }
}
