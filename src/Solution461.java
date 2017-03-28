/**
 * Created by haopeiqiang on 2017/3/28.
 */
public class Solution461 {

    public int hammingDistance(int x, int y) {

        int n = 0;
        int d = 0;
        while (n<32) {

            int bx = x & 1;
            int by = y & 1;
            if (bx != by)
                d++;
            x = x >> 1;
            y = y >> 1;
            n++;
        }
        return d;
    }

    public static void main(String[] argv) {

        Solution461 solution = new Solution461();
        System.out.println(solution.hammingDistance(1,4));
    }
}
