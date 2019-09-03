package p0005;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution2 {

    public String longestPalindrome(String s) {

        HashMap<Pair<Integer, Integer>, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        String ret = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalindromeDp(chars, i, j, map)) {
                    if (j - i + 1 > max) {

                        max = j - i + 1;
                        ret = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindromeDp(char[] chars, int start, int end, HashMap<Pair<Integer, Integer>, Boolean> map) {
        Pair<Integer, Integer> key = new Pair<>(start, end);
        if (chars.length == 1) {
            map.put(key, true);
            return true;
        }
        if (map.containsKey(key))
            return map.get(key);
        if (chars[start] != chars[end]) {
            map.put(key, false);
            return false;
        }
        if (end - start + 1 <= 3) {
            map.put(key, true);
            return true;
        }
        return isPalindromeDp(chars, start + 1, end - 1, map);
    }
}
