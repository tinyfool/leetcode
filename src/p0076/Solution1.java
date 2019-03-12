package p0076;

import java.util.HashMap;

class Solution1 {

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

                sdict.put(c, sdict.getOrDefault(c,0)+1);
                int scount = sdict.get(c);
                int tcount = tdict.get(c);

                if(scount==tcount) {

                    count++;
                    //System.out.println(" count++;");
                }
            }
            if(count<tdict.size())
                continue;
            while (count>=tdict.size()) {

                if (right-left+1<=min)  {
                    String fit = s.substring(left,right+1);
                    ans = fit;
                    min = right-left+1;
                }
                char cl = s.charAt(left);
                left++;
                if (tdict.containsKey(cl)) {

                    sdict.put(cl,sdict.getOrDefault(cl,0)-1);
                    if(sdict.get(cl)<tdict.get(cl)) {
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