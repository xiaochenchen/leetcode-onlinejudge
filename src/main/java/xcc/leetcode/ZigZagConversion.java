package xcc.leetcode;
/**
 * Problem Description:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a 
 * given number of rows like this: (you may want to display 
 * this pattern in a fixed font for better legibility)
 *
 *  	P   A   H   N
 *		A P L S I I G
 *		Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion 
{
	public String convert(String s, int nRows)
	{
		if(s == null || nRows == 1 ||  s.trim().length() < 3)
		{
			return s;
		}
		
		StringBuilder[] sb = new StringBuilder[nRows];
		for(int i = 0; i < sb.length; ++i)
		{
			sb[i] = new StringBuilder();
		}
			
		int curRow = 0;
		int step = 1;
		for(int i = 0; i < s.length(); ++i)
		{
			sb[curRow].append(s.charAt(i));
			curRow += step;
			if(curRow == 0 || curRow == nRows - 1)
			{
				step *= -1;
			}					
		}
		
		StringBuilder rsb = new StringBuilder();
		for(int i = 0; i < sb.length; ++i)
		{
			rsb.append(sb[i]);
		}
		
		return rsb.toString();
	}
}
