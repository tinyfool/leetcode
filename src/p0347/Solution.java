package p0347;

import java.lang.reflect.Array;
import java.util.*;
//Runtime: 13 ms, faster than 71.98% of Java online submissions for Top K Frequent Elements.
//Memory Usage: 40.2 MB, less than 64.43% of Java online submissions for Top K Frequent Elements.
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums) {

            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int key:map.keySet()) {

            list.add(new int[]{key,map.get(key)});
        }
        Collections.sort(list, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[1]-o1[1];
                    }
                }
        );
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        for (int[] pair: list) {
            i++;
            if(i>k)
                break;
            ret.add(pair[0]);
        }
        return ret;
    }

}
