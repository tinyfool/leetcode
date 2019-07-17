package p0075;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
// Memory Usage: 35.3 MB, less than 99.90% of Java online submissions for Sort Colors.
class Solution1 {

  public void sortColors(int[] nums) {
    int[] count = new int[3];
    for(int num:nums) {
      count[num]++;
    }
    for(int i = 0;i<nums.length;i++) {
      if(i<count[0])
        nums[i] = 0;
      else if(i<count[0]+count[1]) 
        nums[i] = 1;
      else 
        nums[i] = 2;
    }
  }

}