package p1122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//Runtime: 2 ms, faster than 73.13% of Java online submissions for Relative Sort Array.
//        Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Relative Sort Array.

public class Solution1 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> others = new ArrayList<>();
        int[] ret = new int[arr1.length];
        for(int num:arr2) {
            map.put(num,0);
        }
        for(int num:arr1) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                count++;
                map.put(num,count);
            }else {
                others.add(num);
            }
        }
        int n = 0;
        for(int num:arr2) {
            int count = map.get(num);
            for (int i = 0; i <count ; i++) {
                ret[n] = num;
                n++;
            }
        }
        Collections.sort(others);
        for(int num:others) {
            ret[n] = num;
            n++;
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        Solution1 s1 = new Solution1();
        int[] ret = s1.relativeSortArray(arr1,arr2);
        System.out.println(Arrays.toString(ret));

    }
}
