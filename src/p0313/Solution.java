package p0313;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-28 11:09
 */

//Runtime: 76 ms, faster than 17.26% of Java online submissions for Super Ugly Number.
//Memory Usage: 41.9 MB, less than 50.00% of Java online submissions for Super Ugly Number.
    
public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {

        int primeCount = primes.length;
        int[] step = new int[primeCount];
        int[] nextLine = new int[primeCount];
        int[] result = new int[n+1];
        result[0] = 1;
        Arrays.fill(step,0);
        int num = 1;
        Set numbers = new HashSet<>();
        while (num <= n) {
            for (int i = 0; i < primeCount; i++) {
                nextLine[i] = result[step[i]] * primes[i];
            }
            int[] minArray = min(nextLine);
            int min = minArray[0];
            int index = minArray[1];
            step[index]++;
            if(!numbers.contains(min)) {
                result[num] = min;
                num++;
            }
            numbers.add(min);
        }
        return result[n-1];
    }
//1,2,4,7,8,13,14,16,19,26,28,32]
    int[] min(int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                index = i;
            }
        }
        return new int[]{min, index};
    }
}
