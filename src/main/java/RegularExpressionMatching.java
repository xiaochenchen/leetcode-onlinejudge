/**
 * Problem Description:
 * 
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "a*") ? true
 * isMatch("aa", ".*") ? true
 * isMatch("ab", ".*") ? true
 * isMatch("aab", "c*a*b") ? true
 * 
 * @author
 *
 */
public class RegularExpressionMatching 
{
	public boolean isMatch(String s, String p)
	{
		// if either source or pattern is null, return false
		if(s == null || p == null)
		{
			return false;
		}	
		
		// if pattern is empty, return true only if source is also empty
		if(p.isEmpty())
		{
			return s.isEmpty();
		}
		
		// if single non * character: must match current character
		// if next character is not '*': must match current character
		if(p.length() == 1 || p.charAt(1) != '*')
		{
			if(p.charAt(0) == '*' || s.isEmpty())
			{
				return false;
			}
			return ( p.charAt(0) == s.charAt(0) || p.charAt(0) == '.' )
					&& isMatch(s.substring(1), p.substring(1)) ;
		}
	
		// next character is *
		while(s.isEmpty() || p.charAt(0) == s.charAt(0) || p.charAt(0) == '.' )
		{
			if(isMatch(s, p.substring(2)))
			{
				return true;
			}
			else if(s.isEmpty())
			{
				return false;
			}
			
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));
	}
}
