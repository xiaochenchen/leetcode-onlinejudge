package xcc.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an unsorted array of integers,
 * find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 *
 * Created by lightsaber on 3/27/14.
 */
public class LongestConsecutiveSequence
{
    public int longestConsecutive(int[] num)
    {
        Set<Integer> numbers = new HashSet<Integer>();
        for(int i : num)
        {
            numbers.add(i);
        }

        int longest = 0;
        for(int i : num)
        {
            if(numbers.contains(i))
            {
                int left = i, right = i;

                while(numbers.contains(left - 1))
                {
                    numbers.remove(--left);
                }

                while(numbers.contains(right + 1))
                {
                    numbers.remove(++right);
                }

                if(right - left + 1 > longest)
                {
                    longest = right - left + 1;
                }
            }
        }

        return longest;
    }
}
