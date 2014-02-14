package xcc.leetcode;

public class CountAndSay 
{
    public String countAndSay(int n) {
        if(n <= 0) return null;
        
        String s = "1";
        
        for(int i = 2; i <= n; i++)
        {
        	s = next(s);
        }
        
        return s;
    }
    
    private String next(String s)
    {
    	StringBuilder sb = new StringBuilder();
    	int count = 1;
    	char curChar = s.charAt(0);
    	for(int i = 1; i < s.length(); ++i)
    	{
			if(s.charAt(i) != curChar)
			{
				sb.append(count).append(curChar);
				curChar = s.charAt(i);
				count = 1;
			}
			else
			{
				count++;
			}
    	}
    	sb.append(count).append(curChar);
    	return sb.toString();
    }
}
