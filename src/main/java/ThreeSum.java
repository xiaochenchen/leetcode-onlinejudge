import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 9/8/13
 * Time: 11:04 PM
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // result to return
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        // return empty results if array length less than three
        if(num.length < 3)
        {
            return results;
        }


        // sort the array
        Arrays.sort(num);

        for(int i = 0; i < num.length; ++i)
        {
            // stop if the smallest element is greater than 0
            if(num[i] > 0)
            {
                break;
            }

            // skip duplicates
            if(i > 0 && num[i] == num[i-1])
            {
                continue;
            }

            int first = i + 1;
            int last = num.length - 1;

            while(first < last)
            {
                if(num[last] > 0 - num[i] - num[first])
                {
                    last--;
                }
                else if(num[last] < 0 - num[i] - num[first])
                {
                    first++;
                }
                else
                {
                    // find a triplet
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(num[i]);
                    result.add(num[first]);
                    result.add(num[last]);
                    results.add(result);
                    // skip duplicates if there is any
                    do { first++; } while (first < num.length && ( num[first] == num[first - 1] ) );
                    do { last--; } while (last > i && ( num[last] == num[last + 1] ) );
                }
            }
        }

        return results;
    }
}
