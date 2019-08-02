package p0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//Runtime: 10 ms, faster than 48.19% of Java online submissions for Group Anagrams.
//Memory Usage: 42.4 MB, less than 88.40% of Java online submissions for Group Anagrams.

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String string:strs) {
            String key = ordered(string);
            ArrayList<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(string);
            map.put(ordered(string),list);
        }
        ArrayList<List<String>> ret = new ArrayList<>();
        for(String key:map.keySet()){
            ret.add(map.get(key));
        }
        return ret;
    }

    private String ordered(String string) {

        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
