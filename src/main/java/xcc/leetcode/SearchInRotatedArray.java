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

//    Challenge with an extended problem
//
//    Implement the following function, FindSortedArrayRotation,
//    which takes as its input an array of unique integers that has been sorted in ascending order,
//    then rotated by an unknown amount X where 0 <= X <= (arrayLength - 1).
//    An array rotation by amount X moves every element array[i] to array[(i + X) % arrayLength].
//    FindSortedArrayRotation discovers and returns X by examining the array.

    public int findSortedArrayRotation(int[] A)
    {
        int l = 0, r = A.length - 1;

        // if the array is sorted, will return immediately
        while(A[l] > A[r])
        {
            int m = (l + r) / 2;

            // check the right half first, if right half is not sorted, set l = m + 1
            if(A[m] > A[r])
            {
                l = m + 1;
            }
            // else continue check left half
            else
            {
                r = m;
            }
        }

        return l;
    }
	
}
