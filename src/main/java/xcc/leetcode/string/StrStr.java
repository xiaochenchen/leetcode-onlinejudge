package xcc.leetcode.string;

/**
 *
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack,
 * or null if needle is not part of haystack.
 *
 * Created by lightsaber on 3/27/14.
 */
public class StrStr
{
    public String strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); ++i)
        {
            if(haystack.substring(i, i + needle.length()).equals(needle))
            {
                return haystack.substring(i);
            }
        }

        return null;
    }
}
