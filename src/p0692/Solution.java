package p0692;

import java.util.*;

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
                return i2.compareTo(i1);
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
