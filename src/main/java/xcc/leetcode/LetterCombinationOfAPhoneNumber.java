package xcc.leetcode;
import java.util.ArrayList;

public class LetterCombinationOfAPhoneNumber 
{	
    public ArrayList<String> letterCombinations(String digits) {
    	
        ArrayList<String> combinations = new ArrayList<String>();
        
        parseDigits(combinations, "", digits);
        
        return combinations;
    }
    
    private void parseDigits(ArrayList<String> results, String prefix, String remianingDigits)
    {
    	if(remianingDigits.length() == 0)
    	{
    		results.add(prefix);
    		return;
    	}
    	
    	for(String s: mapDigit(remianingDigits.substring(0,1)))
    	{
    		parseDigits(results, prefix.trim() + s.trim(), remianingDigits.substring(1));
    	}
    	
    }
    
    private String[] mapDigit(String digit)
    {
    	if(digit.equals("2"))
    	{
    		return new String[] {"a","b","c"};
    	}
    	else if(digit.equals("3"))
    	{
    		return new String[] {"d","e","f"};
    	}
    	else if(digit.equals("4"))
    	{
    		return new String[] {"g","h","i"};
    	}
    	else if(digit.equals("5"))
    	{
    		return new String[] {"j","k","l"};
    	}
    	else if(digit.equals("6"))
    	{
    		return new String[] {"m","n","o"};
    	}
    	else if(digit.equals("7"))
    	{
    		return new String[] {"p","q","r","s"};
    	}
    	else if(digit.equals("8"))
    	{
    		return new String[] {"t","u","v"};
    	}
    	else if(digit.equals("9"))
    	{
    		return new String[] {"w","x","y", "z"};
    	}
    	else
    	{
    		return new String[] {};
    	}
    }
}
