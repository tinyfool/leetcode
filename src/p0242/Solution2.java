package p0242;

import java.util.Arrays;
import java.util.HashMap;

//Runtime: 16 ms, faster than 25.37% of Java online submissions for Valid Anagram.
//        Memory Usage: 37.5 MB, less than 77.26% of Java online submissions for Valid Anagram.

public class Solution2 {

    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> chars = new HashMap<>();
        for(char cs:s.toCharArray()){
            int count = chars.getOrDefault(cs,0);
            count++;
            chars.put(cs,count);
        }

        for(char ct:t.toCharArray()){
            int count = chars.getOrDefault(ct,0);
            if(count== 0)
                return false;
            count --;
            if(count==0)
                chars.remove(ct);
            else
                chars.put(ct,count);
        }
        if(chars.size()==0)
            return true;
        else
            return false;
    }

}
