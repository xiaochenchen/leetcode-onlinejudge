package xcc.leetcode.string;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 *
 * Created by lightsaber on 4/1/14.
 */
public class CountAndSay
{
    public String countAndSay(int n)
    {
        if(n == 0) return "";

        String curr = "1";
        StringBuilder next = new StringBuilder();

        for(int i = 1; i < n; ++i)
        {
            next.setLength(0);
            int count = 1;
            for(int j = 1; j < curr.length(); ++j)
            {
                if(curr.charAt(j) == curr.charAt(j - 1))
                {
                    count++;
                }
                else
                {
                    next.append(count).append(curr.charAt(j - 1));
                    count = 1;
                }
            }
            next.append(count).append(curr.charAt(curr.length() - 1));
            curr = next.toString();
        }

        return curr;
    }
}
