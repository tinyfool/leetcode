package p0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Runtime: 6 ms, faster than 88.21% of Java online submissions for Merge Intervals.
//Memory Usage: 41.6 MB, less than 62.32% of Java online submissions for Merge Intervals.

class Solution1 {
  
  public int[][] merge(int[][] intervals) {
    if(intervals.length==0)
    return new int[0][];

      Arrays.sort(intervals, new Comparator<int[]>() {
          
        @Override
        public int compare(int[] entry1,int[] entry2) {
          return Integer.compare(entry1[0], entry2[0]);
        }
      });

      ArrayList<int []> out = new ArrayList<>();
      int[] current = intervals[0];
      for (int i = 1; i < intervals.length; i++){
        if(isOverlap(current, intervals[i])) {
          current = merge(current, intervals[i]);
        }
        else {
          out.add(current);
          current = intervals[i];
        }
      }
      out.add(current);
      int[][] oa = new int[out.size()][2];
      for (int i = 0; i < out.size(); i++){
        oa[i] = out.get(i);
      }
      return oa;
  }

  private boolean isOverlap(int[] in1,int[] in2) {

    if(in1[1]>=in2[0])
      return true;
    return false;
  }
  
  private int[] merge(int[] in1,int[] in2) {

    int[] out = new int[2];
    out[0] = Math.min(in1[0], in2[0]);
    out[1] = Math.max(in1[1], in2[1]);
    return out;
  }

  public static void main(String[] args) {
    
    Solution1 s1 = new Solution1();

    int[][] input1 = new int[][]{
      {1,3},{2,6},{8,10},{15,18}
    };
    int[][] out1 =  s1.merge(input1);
    System.out.println(Arrays.deepToString(out1));

    int[][] input2 = new int[][]{
      {1,4},{4,5}
    };
    int[][] out2 =  s1.merge(input2);
    System.out.println(Arrays.deepToString(out2));

    int[][] input3 = new int[][]{
      {1,4},{0,0}
    };
    int[][] out3 =  s1.merge(input3);
    System.out.println(Arrays.deepToString(out3));

  }
}