package p0316;

import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

    public String removeDuplicateLetters(String s) {

        SortedSet<Character> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()) {
            set.add(c);
        }
        for(char c:set) {
            sb.append(c);
        }
        return sb.toString();
    }

}
