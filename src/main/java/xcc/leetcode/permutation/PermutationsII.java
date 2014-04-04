package xcc.leetcode.permutation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 *
 * Created by lightsaber on 4/1/14.
 */
public class PermutationsII
{
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num)
    {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];

        Arrays.sort(num);

        generate(num, results, result, visited);

        return results;
    }

    public void generate(int[] num, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, boolean[] visited)
    {
        // found a valid result
        if(result.size() == num.length)
        {
            results.add(new ArrayList<Integer>(result));
            return;
        }

        for(int i = 0; i < num.length; ++i)
        {
            if(i > 0 && num[i] == num[i - 1] && visited[i - 1] == false) continue;

            if(!visited[i])
            {
                result.add(num[i]);
                visited[i] = true;

                generate(num, results, result, visited);

                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }
}
