package p0500;

import java.util.*;
//Runtime: 1 ms, faster than 74.11% of Java online submissions for Keyboard Row.
//Memory Usage: 34.6 MB, less than 99.28% of Java online submissions for Keyboard Row.
public class Solution {


    ArrayList<HashSet<Character>> keymap;
    Solution() {
        keymap = new ArrayList<HashSet<Character>>();
        HashSet<Character> set;

        set = new HashSet<Character>();
        for(char c:"qwertyuiop".toCharArray()) {
            set.add(c);
        }
        keymap.add(set);

        set = new HashSet<Character>();
        for(char c:"asdfghjkl".toCharArray()) {
            set.add(c);
        }
        keymap.add(set);

        set = new HashSet<Character>();
        for(char c:"zxcvbnm".toCharArray()) {
            set.add(c);
        }
        keymap.add(set);
    }
    public String[] findWords(String[] words) {

        List<String> ret = new ArrayList<>();
        for(String word:words) {
            String lword = word.toLowerCase();
            int i = 0;
            for(Set set:keymap) {
                if(inSet(lword, set))
                    i++;
            }
            if(i==1)
                ret.add(word);
        }
        return ret.toArray(new String[0]);
    }

    private boolean inSet(String word, Set set) {

        for (char c:word.toCharArray()) {
            if(set.contains(c)) {
                return true;
            }
        }
        return false;
    }

}
