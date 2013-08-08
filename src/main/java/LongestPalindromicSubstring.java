/**
 * Problem Description:
 *
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 */

public class LongestPalindromicSubstring
{
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
}
