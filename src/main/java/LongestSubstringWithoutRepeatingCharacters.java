import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/6/13
 * Time: 10:59 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Character,ArrayList<Integer>> indexListMap = new HashMap<Character, ArrayList<Integer>>();

        for(int i = 0; i < s.length(); ++i)
        {
            if(indexListMap.get(s.charAt(i)) == null)
            {
                ArrayList<Integer> indexList = new ArrayList<Integer>();
                indexList.add(i);
                indexListMap.put(s.charAt(i), indexList);
            }
            else
            {
                indexListMap.get(s.charAt(i)).add(i);
            }
        }

        int max_len = 0;
        for(Character ch : indexListMap.keySet())
        {
            ArrayList<Integer> indexList = indexListMap.get(ch);
            for(int i = 1; i < indexList.size(); ++i)
            {
                int len = indexList.get(i) - indexList.get(i-1) - 1;
                if(len > max_len)
                {
                    max_len = len;
                }
            }
        }

        return max_len;
    }

}
