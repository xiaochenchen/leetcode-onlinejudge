package xcc.leetcode.string;

/**
 * Given two numbers represented as strings,
 * return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 *
 * Created by lightsaber on 4/3/14.
 */
public class MultiplyString
{
    public String multiply(String num1, String num2)
    {
        String rNum1 = new StringBuilder(num1).reverse().toString();
        String rNum2 = new StringBuilder(num2).reverse().toString();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < rNum1.length(); ++i)
        {
            int digit1 = rNum1.charAt(i) - '0';
            int carry = 0;

            for(int j = 0; j < rNum2.length(); ++j)
            {
                int digit2 = rNum2.charAt(j) - '0';
                int product = digit1 * digit2;

                // add carry
                product += carry;

                // if current position exceed result length
                if(result.length() < j + i + 1)
                {
                    result.append(product % 10);
                }
                else
                {
                    int curDigit = result.charAt(j + i) - '0';
                    product += curDigit;
                    result.setCharAt(j + i, Character.forDigit(product % 10, 10));
                }

                // set new carry
                carry = product / 10;
            }

            // if there is carry at the end of one loop, append it to the beginning
            if(carry != 0) result.append(carry);
        }

        // remove the leading 0s if any
        while(result.length() > 1 && result.charAt(result.length() - 1) == '0')
        {
            result.deleteCharAt(result.length() - 1);
        }

        return result.reverse().toString();
    }
}
