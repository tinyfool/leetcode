package p0217;

import java.util.HashMap;
import java.util.HashSet;
//Runtime: 8 ms, faster than 67.23% of Java online submissions for Contains Duplicate.
//Memory Usage: 44.2 MB, less than 56.25% of Java online submissions for Contains Duplicate.

public class Solution {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) {
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
