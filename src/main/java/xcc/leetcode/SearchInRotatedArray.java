package xcc.leetcode;

public class SearchInRotatedArray {
	public int search(int[] A, int target)
	{
		int l = 0;
		int r = A.length - 1;
		
		while(l <= r)
		{
			int m = (l + r)/2;
			
			// if m is the target
			if(A[m] == target) return m;
			
			// if the left half is sorted
			if(A[l] <= A[m])
			{
				if(A[l] <= target && target < A[m]) r = m - 1;
				else l = m + 1;
			}
			// the right half is sorted
			else
			{
				if(A[m] < target && target <= A[r]) l = m + 1;
				else r = m - 1;
			}
		}
		
		return -1;
	}
	
}
