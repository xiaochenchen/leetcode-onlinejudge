import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/6/13
 * Time: 10:59 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringSlow(String s) {
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

        int maxLen = 0, curHead = 0, curLen = 0;
        for(int i = 0; i < s.length(); ++i)
        {
            curLen = i - curHead + 1;
            
            if(exists[s.charAt(i) - 'a'] != -1 && exists[s.charAt(i) - 'a'] >= curHead)
            {
            	curLen -= 1;
            	curHead = exists[s.charAt(i) - 'a'] + 1;
            }

            exists[s.charAt(i) - 'a'] = i;
            
            if(curLen > maxLen)
            {
            	maxLen = curLen;
            }
        }
        
        return maxLen;
    }

}
