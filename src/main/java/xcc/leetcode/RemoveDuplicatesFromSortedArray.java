package xcc.leetcode;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A)
	{		
		int curIndex = -1;
		
		for(int i = 0; i < A.length; i++)
		{
			if(i == 0)
			{
				curIndex = 0;
				continue;
			}
			
			while(i < A.length && A[i] == A[i-1]) 
			{
				i++;
			}
			
			if(i == A.length)
			{
				break;
			}
			
			// found the first non duplicates
			A[++curIndex] = A[i];
		}
		
		return curIndex + 1;
	}
}