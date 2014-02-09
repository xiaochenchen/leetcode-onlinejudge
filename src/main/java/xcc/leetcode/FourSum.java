package xcc.leetcode;
import java.util.ArrayList;
import java.util.Arrays;


public class FourSum {
	
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		
		if(num == null || num.length < 4)
		{
			return results;
		}
        
		// sort the array before looking for four sum
		Arrays.sort(num);		
		
		for(int i = 0; i < num.length - 3; ++i)
		{
			// skip duplicates
			if(i > 0 && num[i] == num[i-1])
			{
				continue;
			}
			for(int j = i+1; j < num.length - 2; ++j)
			{
				// skip duplicates
				if(j > i+1 && num[j] == num[j-1])
				{
					continue;
				}
				int first = j + 1;
				int last = num.length - 1;
				while(first < last)
				{
					int curSum = num[i] + num[j] + num[first] + num[last];
					if(curSum < target)
					{
						do{ ++first; } while (first < last && num[first] == num[first - 1]);
					}
					else if(curSum > target)
					{
						do{ --last; } while (first < last && num[last] == num[last + 1]);
					}
					else
					{
						// found our match
						ArrayList<Integer> result = new ArrayList<Integer>();
						result.add(num[i]);
						result.add(num[j]);
						result.add(num[first]);
						result.add(num[last]);
						results.add(result);
						do{ ++first; } while (first < last && num[first] == num[first - 1]);
						do{ --last; } while (first < last && num[last] == num[last + 1]);
					}
				}
			}
		}
		
		return results;
    }
	
}
