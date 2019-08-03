package p1002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//暂时跳过
public class Solution {

    public List<String> commonChars(String[] A) {

        HashMap<Character, Integer> charMap = new HashMap<>();
        int i = 0;
        for (String word : A) {
            for (char c : word.toCharArray()) {
                if (i == 0) {
                    charMap.put(c, charMap.getOrDefault(c, 0) + 1);
                }else  {

                }
            }
            i = 1;
        }
        List<String> ret = new ArrayList<>();
        return ret;
    }

}
