package p0044;

import java.util.HashMap;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-30 21:05
 */
class Solution {



    HashMap<String, Boolean> result = new HashMap<>();

    public boolean isMatch(String s, String p) {

        String newP = removeStars(p);
        return isMatchFun(s,newP);
    }

    public boolean isMatchFun(String s, String p) {
        String key = s + ":" + p;
        if (result.containsKey(key))
            return result.get(key);
        //System.out.println(s + ":" + p);
        if (s.length() == 0 && p.length() == 0) {
            result.put(key, true);
            return true;
        }
        if (p.length() == 0) {
            result.put(key, false);
            return false;
        }
        char first = p.charAt(0);
        switch (first) {
            case '?':
                if (s.length() != 0)
                    return isMatchFun(s.substring(1), p.substring(1));
                else {
                    result.put(key, false);
                    return false;
                }
            case '*':
                if(p.charAt(p.length()-1)!='*' && p.charAt(p.length()-1)!='?') {
                    if (s.length()==0|| p.charAt(p.length()-1)!=s.charAt(s.length()-1)) {
                        return false;
                    }
                }
                if (p.length() == 1) {
                    result.put(key, true);
                    return true;
                }
                for (int i = 0; i <= s.length(); i++) {
                    if (isMatchFun(s.substring(i, s.length()), p.substring(1))) {
                        result.put(key, true);
                        return true;
                    }
                }
                result.put(key, false);
                return false;
            default:
                if (s.length() == 0) {
                    result.put(key, false);
                    return false;
                }
                if (first == s.charAt(0))
                    return isMatchFun(s.substring(1), p.substring(1));
                else {
                    result.put(key, false);
                    return false;
                }
        }
    }

    public String removeStars(String p) {
        StringBuilder sb = new StringBuilder();
        int inStar = 0;
        for (Character c : p.toCharArray()) {
            if (c == '*' && inStar == 1) {

            } else {
                if (c == '*')
                    inStar = 1;
                else
                    inStar = 0;
                sb.append(c);
            }

        }
        return sb.toString();
    }
}