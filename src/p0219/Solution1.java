package p0219;

import java.util.HashSet;

//Runtime: 8 ms, faster than 79.60% of Java online submissions for Contains Duplicate II.
//Memory Usage: 42.2 MB, less than 92.08% of Java online submissions for Contains Duplicate II.

public class Solution1 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(k==0)
            return false;
        if(nums.length<2)
            return false;
        if(k>nums.length)
            k=nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<=k&&i<nums.length;i++){
                if(set.contains(nums[i]))
                    return true;
                else
                    set.add(nums[i]);
        }
        if(k==nums.length)
            return false;
        for(int i=k+1;i<nums.length;i++){

            set.remove(nums[i-k-1]);
            if(set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
}
