package xcc.leetcode;

public class NextPermutation 
{
    public void nextPermutation(int[] num) 
    {
    	// start from the end, find the first ascending pair
    	int leftIdx = -1;
    	for(int i = num.length - 1; i > 0; i--)
    	{
    		if(num[i] > num[i-1])
    		{
    			leftIdx = i-1;
    			break;
    		}
    	}
    	
    	// the array is in complete descending order, reverse and return
    	if(leftIdx == -1)
    	{
    		reverse(num, 0, num.length - 1);
    		return;
    	}
    	
    	// start from leftIdex, find the first number that is 
    	int rightIdx = leftIdx;
    	for(int i = num.length - 1; i > leftIdx; i--)
    	{
    		if(num[i] > num[leftIdx])
    		{
    			rightIdx = i;
    			break;
    		}
    	}
    	
    	swap(num, leftIdx, rightIdx);
    	reverse(num, leftIdx + 1, num.length - 1);
    }
    
    private void swap(int[] num, int i, int j)
    {
    	int temp = num[j];
    	num[j] = num[i];
    	num[i] = temp;
    }
    
    private void reverse(int[] num, int start, int end)
    {
    	while(start < end)
    	{
    		swap(num, start++, end--);
    	}
    }
}
