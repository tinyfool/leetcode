package p0005;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution3 {

    public String longestPalindrome(String s) {

        HashMap<Pair<Integer, Integer>, Boolean> map = new HashMap<>();
        String rs = new StringBuilder(s).reverse().toString();
        String ret = "";
        if (s.equals(rs))
            return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String sub1 = s.substring(i, j);
                if (!rs.contains(sub1)) {

                    break;
                } else {

                    if (isPalindromeDp(chars,i,j-1,map) && ret.length() < sub1.length()) {
                        ret = sub1;
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
