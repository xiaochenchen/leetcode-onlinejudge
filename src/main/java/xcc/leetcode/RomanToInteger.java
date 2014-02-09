package xcc.leetcode;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger 
{
	public int romanToInt(String s)
	{
		Map<Character,Integer> m = new HashMap<Character,Integer>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);
		
		int result = 0;
		for(int i = 0; i < s.length(); ++i)
		{
			if(i+1 < s.length())
			{
				if( m.get(s.charAt(i)) * 5 == m.get(s.charAt(i+1) ) 
						|| m.get(s.charAt(i)) * 10 == m.get(s.charAt(i+1)) )
				{
					result += m.get(s.charAt(i+1)) - m.get(s.charAt(i));
					++i;
					continue;
				}
			}
			result += m.get(s.charAt(i));
		}
		
		return result;
	}
}
