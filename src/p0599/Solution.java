package p0599;

import java.lang.reflect.Array;
import java.util.*;

//Runtime: 23 ms, faster than 19.81% of Java online submissions for Minimum Index Sum of Two Lists.
//Memory Usage: 39 MB, less than 95.51% of Java online submissions for Minimum Index Sum of Two Lists.

public class Solution {


    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> List1Map = new HashMap<>();
        TreeMap<String, Integer> restIndexMap = new TreeMap<>();
        for (int i = 0; i < list1.length; i++) {
            List1Map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (List1Map.containsKey(list2[i])) {
                int index1 = List1Map.get(list2[i]);
                restIndexMap.put(list2[i], index1 + i);
            }
        }
        List<Map.Entry<String,Integer>> list = new LinkedList(restIndexMap.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        int count = -1;
        ArrayList<String> ret = new ArrayList<>();
        for (Map.Entry<String,Integer> entry:list) {

            int c = entry.getValue();
            if(count==-1)
                count = c;
            if(count!=c)
                break;
            ret.add(entry.getKey());
        }
        return ret.toArray(new String[0]);
    }

}
