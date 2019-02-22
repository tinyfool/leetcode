package p076;

import java.util.HashMap;

public class Solution1 {

    public String minWindow(String s, String t) {

        int left =0;
        int right = 0;
        String ans = "";
        int min = s.length();
        int count = 0;
        HashMap<Character, Integer> tdict = new HashMap<Character, Integer>();
        HashMap<Character, Integer> sdict = new HashMap<Character, Integer>();

        for (char c:t.toCharArray()) {
            tdict.put(c, tdict.getOrDefault(c,0)+1);
        }
        for (int i = 0; i<s.length(); i++) {

            right = i;
            char c = s.charAt(right);
            if(tdict.containsKey(c)) {

                sdict.put(c, sdict.get(c)+1);
                if(sdict.get(c)==tdict.get(c)) {


                }
            }
            if(count<t.length())
                continue;
            while (count>=t.length()) {
                String fit = s.substring(left,right+1);
                //System.out.println(fit);
                if (right-left+1<=min)  {
                    ans = fit;
                    min = right-left+1;
                }
                char cl = s.charAt(left);
                left++;
                if (dict.containsKey(cl)) {

                    dict.put(cl,dict.get(cl)-1);
                    //System.out.println(dict.get(cl));
                    if(dict.get(cl)<=0) {
                        count--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String [] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution1 s1 = new Solution1();
        String ans = s1.minWindow(s,t);
        System.out.println(ans);

        s = "aa";
        t = "aa";
        ans = s1.minWindow(s,t);
        System.out.println(ans);

    }

}
