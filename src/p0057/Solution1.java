package p0057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Runtime: 3 ms, faster than 24.68% of Java online submissions for Insert Interval.
// Memory Usage: 41.5 MB, less than 43.37% of Java online submissions for Insert Interval.

public class Solution1 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
      ArrayList<int []> ni = new ArrayList<>();
      for (int i = 0; i < intervals.length; i++){
        ni.add(intervals[i]);
      }
      ni.add(newInterval);
      int[][] oa = new int[ni.size()][2];
      for (int i = 0; i < ni.size(); i++){
        oa[i] = ni.get(i);
      }
      return merge(oa);
    }

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
    
    Solution1 s1 =  new Solution1();
    
    int[][] input1 = new int[][]{
      {1,5},{2,3}
    };
    int[] ni = new int[]{2,3};
    int[][] out1 =  s1.insert(input1,ni);
    System.out.println(Arrays.deepToString(out1));

  }
}