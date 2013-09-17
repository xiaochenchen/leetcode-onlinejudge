import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 9/16/13
 * Time: 10:58 PM
 */
public class ThreeSumClosest
{
    public int threeSumClosest(int[] num, int target)
    {
        // assume length of num is always greater than 2
        assert(num.length > 2);

        Arrays.sort(num);

        int threeSumClosest = num[0] + num[1] + num[2];

        for(int i = 0; i < num.length; ++i)
        {
            int left = i + 1;
            int right = num.length - 1;

            while(left < right)
            {
                int threeSum = num[i] + num[left] + num[right];

                if( Math.abs(threeSumClosest - target) > Math.abs(threeSum - target) )
                {
                    threeSumClosest = threeSum;
                }

                if(threeSum >= target)
                {
                    --right;
                }
                else
                {
                    ++left;
                }
            }
        }

        return threeSumClosest;
    }
}
