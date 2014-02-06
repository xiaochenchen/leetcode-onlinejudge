/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 8/11/13
 * Time: 1:17 AM
 *
 * Problem Description:
 *
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger
{
    public int reverse(int x)
    {
        int sign = 1;
        if(x < 0)
        {
            sign = -1;
            x *= -1;
        }

        int ret = 0;
        while(x > 0)
        {
            int last_digit = x % 10;
            ret = ret * 10 + last_digit;
            x = x / 10;
        }
        return ret * sign;
    }
    
    public int reverse2(int x)
    {
    	int sign = 1;
    	int number = 0;
    	int result = 0;
    	
    	if(x < 0)
    	{
    		sign = -1;
    		number = x * -1;
    	}
    	
    	while(number > 0)
    	{
    		int remainder = number % 10;
    		result = result * 10 + remainder;
    		number = number / 10;
    	}
    	
    	return result * sign;
    }
}
