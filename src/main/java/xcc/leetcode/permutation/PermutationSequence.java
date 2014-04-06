package xcc.leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * Created by lightsaber on 4/6/14.
 */
public class PermutationSequence
{
    public String getPermutation(int n, int k)
    {
        List<Character> inputs = new ArrayList<Character>();

        int count = 1;
        for(int i = 1; i <= n; ++i)
        {
            inputs.add(Character.forDigit(i, 10));
            count *= i;
        }

        k = k - 1;  // make k a start from 0 based index
        StringBuilder result = new StringBuilder();

        for(int i = n; i > 0; --i)
        {
            count = count / i;
            int a = k / count;
            result.append(inputs.remove(a));
            k = k % count;
        }

        return result.toString();
    }
}
