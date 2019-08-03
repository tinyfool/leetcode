package p0771;

import java.util.HashSet;
//Runtime: 1 ms, faster than 94.65% of Java online submissions for Jewels and Stones.
//Memory Usage: 35.1 MB, less than 97.77% of Java online submissions for Jewels and Stones.

public class Solution {

    public int numJewelsInStones(String J, String S) {

        int s = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c:J.toCharArray()) {
            set.add(c);
        }
        for(char c:S.toCharArray()) {
            if(set.contains(c))
                s++;
        }
        return s;
    }
}
