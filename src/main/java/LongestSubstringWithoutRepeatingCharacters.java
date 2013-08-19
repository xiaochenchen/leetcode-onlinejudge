import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/6/13
 * Time: 10:59 PM
 */

/**
 * Problem Description:
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringBruteForce(String s) {
        int longestLen = 0;
        for(int i = 0; i < s.length(); ++i)
        {
            Set<Character> charSet = new HashSet<Character>();
            charSet.add(s.charAt(i));
            int curLen = 1;
            for(int j = i + 1; j < s.length(); ++j)
            {
                if(!charSet.contains(s.charAt(j)))
                {
                    charSet.add(s.charAt(j));
                    if(j - i + 1 > curLen)
                        curLen = j - i + 1;
                }
                else
                    break;
            }
            if(curLen > longestLen)
            {
                longestLen = curLen;
            }
        }
        return longestLen;
    }

    public int lengthOfLongestSubstringFast(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] exists = new int[26];
        Arrays.fill(exists, -1);

        // scan one character at a time
        // track the head and length of current longest substring without repeating characters(clswrc)
        // if the next scanned character exists in the current clswrc
        // move head to the first character after the former occurence of the repeating character
        int maxLen = 0, curHead = 0, curLen;
        for(int i = 0; i < s.length(); ++i)
        {
            // calculate the current length
            curLen = i - curHead + 1;

            // if the current character is a repeating character
            // reduce (nullify) the current length, move the current head to the character after first occurence of the repeating character
            if(exists[s.charAt(i) - 'a'] != -1 && exists[s.charAt(i) - 'a'] >= curHead)
            {
            	curLen -= 1;
            	curHead = exists[s.charAt(i) - 'a'] + 1;
            }

            // update the index (to latest) of the current character
            exists[s.charAt(i) - 'a'] = i;

            // update maxLen if curLen is greater than maxLen
            if(curLen > maxLen)
            {
            	maxLen = curLen;
            }
        }
        
        return maxLen;
    }

}
