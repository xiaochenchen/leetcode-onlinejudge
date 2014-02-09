package xcc.leetcode;

public class DivideTwoIntegers 
{
	public int divide(int dividend, int divisor)
	{
		// mark the sign of the result
		boolean neg = ((dividend < 0) != (divisor < 0));
		
		long lDividend = dividend;
		long lDivisor = divisor;
		if(lDividend < 0) lDividend = -lDividend;
		if(lDivisor < 0) lDivisor = -lDivisor;
		
		long result = 0;
		while(lDividend >= lDivisor)
		{
			int pos = 0;
			while( lDivisor << (pos + 1) <= lDividend ) pos++;
			lDividend -= lDivisor << pos;
			result |= 1 << pos;
		}
		
		return (int) (neg ? -result : result);
	}
}
