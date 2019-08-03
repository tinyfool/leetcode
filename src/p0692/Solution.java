package p0692;

import java.util.*;
//Runtime: 6 ms, faster than 96.61% of Java online submissions for Top K Frequent Words.
//Memory Usage: 38.5 MB, less than 77.95% of Java online submissions for Top K Frequent Words.

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> map = new HashMap<>();
        for (String word:words) {

            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<HashMap.Entry> list = new ArrayList();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<HashMap.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {

                Integer i1 = (Integer) o1.getValue();
                Integer i2 = (Integer) o2.getValue();
                int compared = i2.compareTo(i1);
                if(compared==0) {
                    String s1 = (String) o1.getKey();
                    String s2 = (String) o2.getKey();
                    return s1.compareTo(s2);
                }
                return compared;
            }
        });
        List<String> ret = new ArrayList<>();
        int i = 0;
        for (HashMap.Entry entry:list) {

            i++;
            if(i>k)
                break;
            String str =(String)entry.getKey();
            ret.add(str);
        }
        return ret;
    }

}
