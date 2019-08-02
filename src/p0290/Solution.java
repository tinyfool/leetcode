package p0290;

import java.util.HashMap;
//Runtime: 3 ms, faster than 15.36% of Java online submissions for Word Pattern.
//Memory Usage: 34.4 MB, less than 99.16% of Java online submissions for Word Pattern.

public class Solution {

    public boolean wordPattern(String pattern, String str) {

        String p = patten2patten(pattern);
        String sp = string2patten(str);
        return p.equals(sp);
    }

    private String patten2patten(String patten){

        String[] strs = patten.split("");
        return strArray2Pattern(strs);
    }

    private String string2patten(String str){

        String[] strs = str.split(" ");
        return strArray2Pattern(strs);
    }
    private String strArray2Pattern(String[] strs) {

        HashMap<String,Character> map = new HashMap<>();
        char i = 0;
        StringBuilder sb = new StringBuilder();
        for(String s:strs) {
            if(s.equals("")) {
                sb.append("0");
                continue;
            }
            if(!map.containsKey(s)) {
                map.put(s,i);
                char c = (char) ('a'+i);
                sb.append(c);
                i++;
            }else {

                char index = map.get(s);
                char c = (char) ('a'+index);
                sb.append(c );
            }
        }
        return sb.toString();
    }
}
