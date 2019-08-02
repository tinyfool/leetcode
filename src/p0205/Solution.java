package p0205;

import java.util.HashMap;
import java.util.Map;

//Runtime: 13 ms, faster than 32.15% of Java online submissions for Isomorphic Strings.
//Memory Usage: 36.3 MB, less than 99.82% of Java online submissions for Isomorphic Strings.

public class Solution {

    public boolean isIsomorphic(String s, String t) {

        int[] si = indexArray(s);
        int[] st = indexArray(t);
        for (int i=0;i<s.length();i++) {
            if(si[i]!=st[i])
                return false;
        }
        return true;
    }

    int[] indexArray(String string) {

        HashMap<Character,Integer> map = new HashMap<>();
        char[] s = string.toCharArray();
        for(int i=0;i<s.length;i++) {
            if(!map.containsKey(s[i])) {

                map.put(s[i],i);
            }
        }
        int[] indexs = new int[s.length];
        for(int i=0;i<s.length;i++) {

            indexs[i] = map.get(s[i]);
        }
        return indexs;
    }
}
