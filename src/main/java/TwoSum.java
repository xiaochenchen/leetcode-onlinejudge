import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/6/13
 * Time: 10:57 PM
 */

/**
 * Problem Description:
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 */

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = null;

        Map<Integer,Integer> existingNums = new HashMap<Integer,Integer>();

        int i;
        for( i = 0; i < numbers.length; ++i )
        {
            existingNums.put(numbers[i], i);
        }
        for( i = 0; i < numbers.length; ++i )
        {
            int remainder = target - numbers[i];
            if(existingNums.get(remainder) != null)
            {
                result = new int[2];
                result[0] = i + 1;
                result[1] = existingNums.get(remainder) + 1;
                break;
            }
        }

        return result;
    }

}
