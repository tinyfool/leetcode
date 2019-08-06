package p0029;

import java.util.Map;

/**
 * Created by haopeiqiang on 2016/12/19.
 */
public class Solution029 {

    public int divide(int dividend, int divisor) {

        if (dividend == 0)
            return 0;

        int sign = 0;
        if(dividend>0 && divisor<0) {

            sign = 1;
        }
        if(dividend<0 && divisor>0) {

            sign = 1;
        }

        double end = Math.abs((double) dividend);
        double sor = Math.abs((double) divisor);

        double log = Math.log(end) - Math.log(sor);
        double result = Math.exp(log);

        if (sign == 1 )
            result = -result;
        return (int)result;
    }

    public static void main(String[] argv) {

        Solution029 s = new Solution029();
        System.out.println(s.divide(-2147483648,-2147483648));
    }
}
