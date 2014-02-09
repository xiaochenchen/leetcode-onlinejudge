package xcc.leetcode;
/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/13/13
 * Time: 8:00 AM
 */
public class ContainerWithMostWater
{
    public int maxAreaBF(int[] height)
    {
        int maxArea = 0;
        for(int i = 1; i < height.length; ++i)
        {
            for(int j = i; j < height.length; ++j)
            {
                int curArea = Math.min(height[j-i],height[j]) * i;
                if(curArea > maxArea)
                {
                    maxArea = curArea;
                }
            }

        }
        return maxArea;
    }

    public int maxArea(int[] height)
    {
        int l = 0, r = height.length - 1;

        int maxArea = 0;
        while(l < r)
        {
            int curArea = Math.min(height[l],height[r]) * (r-l);
            if(curArea > maxArea)
            {
                maxArea = curArea;
            }
            if(height[l] <= height[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }

        return maxArea;
    }
}
