package p0050;
/**
 * Created by haopeiqiang on 2016/12/20.
 */
public class Solution050 {

    public double myPow(double x, int n) {

        double result = 1.0;

        int m = n;
        if (m == 0)
            return 1.0;
        if(n==-2147483648)
            m = 2147483647;

        if (m < 0)
            m = - m;
        double ox = x;
        while( m >0) {

            if(((int)m & 1) ==1 ) {
                result *= x;
            }

            x *= x;
            m >>= 1;
        }
        if(n==-2147483648)
            result *= ox;

        if (n < 0)
            return 1/result;
        else
            return result;
    }

    public static void main(String[] argv) {

        Solution050 s = new Solution050();
        System.out.print(s.myPow(-1
                ,-2147483648));
    }
}
