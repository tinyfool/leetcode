package p0218;

import java.util.List;

public class Solution1 {


    public List<List<Integer>> getSkyline(int[][] buildings) {

        return null;
    }

    public static void main(String[] args) {

        //[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
        int[][] building = {
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getSkyline(building));
    }
}
