package p0219;

import java.util.HashSet;
//too slow
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums.length<2)
            return false;

        if(k>=nums.length)
           return containsDuplicate(nums,0,k);

        for(int i=0;i<nums.length-k;i++){

            if(containsDuplicate(nums,i,k))
                return true;
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums,int index,int k) {

        HashSet<Integer> set = new HashSet<>();
        for(int i=index;i<index+k+1 && i<nums.length;i++) {
            int num = nums[i];
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

}
