package p0202;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Runtime: 3 ms, faster than 10.10% of Java online submissions for Happy Number.
//Memory Usage: 34.1 MB, less than 5.11% of Java online submissions for Happy Number.

public class Solution {

    public boolean isHappy(int n) {

        List<Integer> nums;
        HashSet<Integer> set = new HashSet<>();
        while (n>3) {
            if(set.contains(n))
                return false;
            else
                set.add(n);
            nums = split(n);
            n = combine(nums);
        }
        if(n==1)
            return true;
        else
            return false;
    }

    List<Integer> split(int n) {

        ArrayList<Integer> nums = new ArrayList<>();
        int x = n;
        while(x>=10) {
            int remain = x % 10;
            x = x/10;
            nums.add(remain);
        }
        if(x>0)
            nums.add(x);
        return nums;
    }

    int combine(List<Integer> numbs) {

        int s = 0;
        for(int num:numbs) {

            s+= num*num;
        }
        return s;
    }
}
