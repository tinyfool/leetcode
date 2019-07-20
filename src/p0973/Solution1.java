package p0973;

import java.util.*;
//Runtime: 36 ms, faster than 46.32% of Java online submissions for K Closest Points to Origin.
//        Memory Usage: 56.8 MB, less than 92.33% of Java online submissions for K Closest Points to Origin.

public class Solution1 {

    private class distance {

        Double d;
        int index;
    }
    public int[][] kClosest(int[][] points, int K) {

        List<distance> distances = new ArrayList<>();
        int i = 0;
        for(int[] p:points) {
            distance d = new distance();
            d.index = i;
            d.d = Math.sqrt(Math.pow(p[0],2)+Math.pow(p[1],2));
            distances.add(d);
            i++;
        }
        Collections.sort(distances, new Comparator<distance>() {
            @Override
            public int compare(distance o1, distance o2) {
                return o1.d.compareTo(o2.d);
            }
        });
        int[][] ret = new int[K][2];
        for (int j = 0; j <K; j++) {
            ret[j] = points[distances.get(j).index];
        }
        return ret;
    }


    public static void main(String[]args){

        int[][] points = new int[][]{{1,3},{-2,2}};
        Solution1 s1 = new Solution1();
        int[][] ret = s1.kClosest(points,1);
        System.out.println(Arrays.deepToString(ret));
    }

}
