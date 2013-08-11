/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/11/13
 * Time: 11:38 AM
 */
public class StringToInteger
{
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null || str.isEmpty())
        {
            return 0;
        }

        str = str.trim();

        int sign = 1;
        int startIndex = 0;
        if( str.charAt(0) == '-' )
        {
            sign = -1;
            startIndex += 1;
        }
        else if(str.charAt(0) == '+' )
        {
            startIndex += 1;
        }

        long curVal = 0;
        for(int i = startIndex; i < str.length(); ++i)
        {
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
            {
                // return the value we have parsed so far on the encounter of a non numerical character
                break;
            }

            curVal = curVal * 10 + (str.charAt(i) - '0') * sign;

            if(curVal > Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            else if(curVal < Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }
        }

        return (int)curVal;
    }
}
