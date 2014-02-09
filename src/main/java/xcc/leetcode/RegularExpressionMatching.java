package xcc.leetcode;

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

    public boolean isMatchDP(String s, String p)
    {
        if(s == null || p == null)
        {
            return false;
        }

        if(p.isEmpty())
        {
            return s.isEmpty();
        }

        if(p.charAt(0) == '*')
        {
            return false;
        }

        int n = p.length();
        int m = s.length();

        boolean[][] a = new boolean[n+1][m+1];

        // initialize first row
        // empty p only matches empty s
        a[0][0] = true;

        // initialize first column
        // for empty s, '*' and it's preceding character can be ignored for matching
        for(int i = 1; i < n+1; ++i)
        {
        	if(p.charAt(i-1) == '*')
            {
                a[i][0] = a[i-2][0];
            }
        }

        for(int i = 1; i < n+1; ++i)
        {
            for(int j = 1; j < m+1; ++j)
            {
                if(p.charAt(i-1) == '*')
                {
                    a[i][j] = a[i-2][j]
                            || ( a[i-1][j-1] && ( p.charAt(i-2) == s.charAt(j-1) ||  p.charAt(i-2) == '.' ) )
                            || ( a[i][j-1] && ( p.charAt(i-2) == s.charAt(j-1) || p.charAt(i-2) == '.' ) );
                }
                else if(p.charAt(i-1) == '.')
                {
                    a[i][j] = a[i-1][j-1];
                }
                else
                {
                    a[i][j] = a[i-1][j-1] && ( p.charAt(i-1) == s.charAt(j-1) );
                }
            }
        }

        return a[n][m];
    }

    public boolean isMatchDPOL(String s, String p)
    {
        boolean[] lastRow = new boolean[s.length()+1];
        boolean[] currRow = new boolean[s.length()+1];
        boolean[] tmpRow;

        // init star[] and pattern
        int cnt = 0;
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i)=='*')
                cnt++;
        }
        boolean[] star = new boolean[p.length()-cnt];
        StringBuffer sb = new StringBuffer(p.length());
        int index = -1;
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i)=='*') {
                star[index] = true;
            } else {
                sb.append(p.charAt(i));
                index++;
            }
        }
        p = sb.toString();

        // DP
        lastRow[0] = true;
        for (int i=0; i<p.length(); i++) {
            // set currRow[0]
            if (star[i] && lastRow[0]) {
                currRow[0] = true;
            } else {
                currRow[0] = false;
            }

            for (int j=0; j<s.length(); j++) {
                int rowIndex = j + 1;

                if (!star[i]) {
                    if (p.charAt(i)=='.') {
                        if (lastRow[rowIndex-1]) {
                            currRow[rowIndex] = true;
                        } else {
                            currRow[rowIndex] = false;
                        }
                    } else {
                        if (p.charAt(i)==s.charAt(j) && lastRow[rowIndex-1]) {
                            currRow[rowIndex] = true;
                        } else {
                            currRow[rowIndex] = false;
                        }
                    }
                } else {
                    if (lastRow[rowIndex]) {
                        currRow[rowIndex] = true;
                    } else if (lastRow[rowIndex-1] || currRow[rowIndex-1]) {
                        if (p.charAt(i)=='.' || p.charAt(i)==s.charAt(j)) {
                            currRow[rowIndex] = true;
                        } else {
                            currRow[rowIndex] = false;
                        }
                    } else {
                        currRow[rowIndex] = false;
                    }
                }
            }
            // swap lastRow and currRow
            tmpRow = lastRow;
            lastRow = currRow;
            currRow = tmpRow;
        }
        return lastRow[lastRow.length-1];
    }
}
