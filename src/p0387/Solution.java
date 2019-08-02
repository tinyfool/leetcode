package p0387;

import java.util.HashMap;
//Runtime: 4 ms, faster than 98.56% of Java online submissions for First Unique Character in a String.
//Memory Usage: 37.8 MB, less than 99.18% of Java online submissions for First Unique Character in a String.
class Solution {
    public int firstUniqChar(String s) {

        char[] charCounts = new char[256];
        char[] chars = s.toCharArray();
        for(char c:chars) {
            charCounts[c]++;
        }
        for(int i=0;i<chars.length;i++) {
            if(charCounts[chars[i]]==1)
                return i;
        }
        return -1;
    }
}