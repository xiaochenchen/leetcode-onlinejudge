import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/6/13
 * Time: 10:57 PM
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
