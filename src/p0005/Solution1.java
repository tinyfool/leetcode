package p0005;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by haopeiqiang on 2016/10/16.
 */


public class Solution1 {

    HashMap<String, Boolean> map = new HashMap<>();

    public String longestPalindrome(String s) {

        String rs = new StringBuilder(s).reverse().toString();
        String ret = "";
        if (s.equals(rs))
            return s;
        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String sub1 = s.substring(i, j);
                if (!rs.contains(sub1)) {

                    break;
                } else {

                    if (isPalindrome(sub1) && ret.length() < sub1.length()) {
                        ret = sub1;
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String s) {

        if (map.containsKey(s))
            return map.get(s);
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                map.put(s, false);
                return false;
            }
        }
        map.put(s, true);
        return true;
    }

}

