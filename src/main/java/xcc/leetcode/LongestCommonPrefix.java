package xcc.leetcode;

public class LongestCommonPrefix 
{
	public String longestCommonPrefix(String[] strs)
	{	
		if(strs == null || strs.length == 0)
		{
			return "";
		}
		
		if(strs.length == 1)
		{
			return strs[0];
		}
		
		int curIndex = 0;
		char ch = '\u0000';
		boolean done = false;
		while(!done)
		{
			for(int i = 0; i < strs.length; ++i)
			{
				if(curIndex > strs[i].length() - 1)
				{
					done = true;
					break;
				}
				if(i == 0)
				{
					ch = strs[i].charAt(curIndex);
				}
				else if(strs[i].charAt(curIndex) != ch)
				{
					done = true;
					break;
				}
			}
			
			if(!done)
			{
				++curIndex;
			}						
		}
		
		return strs[0].substring(0,curIndex);
	}
}
