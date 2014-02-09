package xcc.leetcode;

import java.util.ArrayList;

public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> results = new ArrayList<String>();
    	generate(n,n,"",results);
    	return results;
    }
    
    private void generate(int lc, int rc, String result, ArrayList<String> results)
    {
    	if(lc == 0 && rc == 0)
    	{
    		// finished generating, add to results
    		results.add(result);
    		return;
    	}
    	
    	if(lc != 0)
    	{
    		if(lc == rc)
    		{
    			// add left only
    			generate(lc-1, rc, result+"(", results);
    		}
    		else if(lc < rc)
    		{
    			// can add both left and right
    			generate(lc-1, rc, result+"(", results);
    			generate(lc, rc-1, result+")", results);
    		}
    	}
    	else
    	{
    		// lc is 0, only add right
    		generate(lc, rc-1, result+")", results);
    	}
    }
}
